package com.dzjk.qzgw.endpoint.service;

import com.alibaba.fastjson.JSON;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.facade.api.account.AccountApiFacade;
import com.dzjk.ams.facade.api.account.AccountRestFacade;
import com.dzjk.ams.facade.base.ResponseData;
import com.dzjk.ams.facade.form.account.QueryAccountReqForm;
import com.dzjk.ams.facade.form.account.QueryRepayPlanReqForm;
import com.dzjk.product.facade.ProductService;
import com.dzjk.product.model.ProductRequest;
import com.dzjk.product.model.base.DefaultResponse;
import com.dzjk.qzgw.core.common.enums.ChannelType;
import com.dzjk.qzgw.core.common.enums.ResultEnum;
import com.dzjk.qzgw.core.common.enums.TransType;
import com.dzjk.qzgw.core.common.exception.CommonException;
import com.dzjk.qzgw.core.common.util.CommonUtil;
import com.dzjk.qzgw.dal.dao.BmgwKeyManagerDAO;
import com.dzjk.qzgw.dal.dao.QzgwOrgInfoDAO;
import com.dzjk.qzgw.dal.dao.QzgwTransInfoDAO;
import com.dzjk.qzgw.dal.dataobject.BmgwKeyManagerDO;
import com.dzjk.qzgw.dal.dataobject.QzgwTransInfoDO;
import com.dzjk.qzgw.endpoint.cache.QzgwKeyCache;
import com.dzjk.qzgw.endpoint.cache.QzgwOrgInfoCache;
import com.dzjk.qzgw.endpoint.cache.QzgwServiceInfoCache;
import com.dzjk.qzgw.endpoint.cache.QzgwServiceOrgCache;
import com.dzjk.qzgw.endpoint.share.converter.ProcessService;
import com.dzjk.qzgw.facade.InvokeService;
import com.dzjk.qzgw.facade.model.CommonRequest;
import com.dzjk.qzgw.facade.model.FmgwResponse;
import com.dzjk.qzgw.facade.model.Header;
import com.dzjk.product.facade.ProductSelectedService;
import com.dzjk.qzgw.facade.model.vo.QzgwKeyManagerVo;
import com.dzjk.qzgw.facade.model.vo.QzgwOrgInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceOrgVo;
import com.mike.leex.facade.api.ApiFacadeService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by daixiaohu on 2018/4/19.
 */
public class InvokeServiceImpl implements InvokeService {
    private static Logger logger = LoggerFactory.getLogger(InvokeServiceImpl.class);
    @Resource
    ProcessService processService;
    @Resource
    private ProductService productService;
    @Resource
    private AccountApiFacade accountApiFacade;
    @Resource
    private ApiFacadeService apiFacadeService;
    @Resource
    private QzgwTransInfoDAO qzgwTransInfoDAO;

    //1.判断机构信息是否存在；2.判断接口机构权限；3判断接口是否是所属系统；
    public Object invoke(String body) throws Exception {
        FmgwResponse response = new FmgwResponse();
        logger.info("service请求参数:" + body);
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(body);
        com.alibaba.fastjson.JSONObject responseHead = jsonObject.getJSONObject("header");
        String orgCode = responseHead.getString("orgCode");
        String orgPwd = responseHead.getString("orgPwd");
        String orgUser = responseHead.getString("orgUser");
        String serviceCode = responseHead.getString("serviceCode");
        String channelSystemId = responseHead.getString("channelSystemId");
        String key = responseHead.getString("key");
        QzgwOrgInfoVo qzgwOrgInfoVo = QzgwOrgInfoCache.get(orgCode, orgUser, orgPwd);
        if (qzgwOrgInfoVo == null) {
            throw new CommonException(ResultEnum.ORG_ERROR, ResultEnum.ORG_ERROR.getMsg());
        }

        QzgwServiceOrgVo qzgwServiceOrgVo = QzgwServiceOrgCache.get(serviceCode, orgCode);
        if (qzgwServiceOrgVo == null) {
            throw new CommonException(ResultEnum.SERVICE_ORG_ERROR, ResultEnum.SERVICE_ORG_ERROR.getMsg());
        }

        QzgwServiceInfoVo qzgwServiceInfoVo = QzgwServiceInfoCache.get(serviceCode, channelSystemId);
        if (qzgwServiceInfoVo == null) {
            throw new CommonException(ResultEnum.SERVICE_CHAL_ERROR, ResultEnum.SERVICE_CHAL_ERROR.getMsg());
        }

        QzgwKeyManagerVo qzgwKeyManagerVo = QzgwKeyCache.get(orgCode);
        if (qzgwKeyManagerVo == null) {
            throw new CommonException(ResultEnum.NoFindKey, ResultEnum.NoFindKey.getMsg());
        }
        String privateKey = qzgwKeyManagerVo.getPrivateKey();
        String data = processService.preService(jsonObject, key, privateKey);
        String apiResponse = "";
        if (ChannelType.CUOHE_SYS.getCode().equals(channelSystemId)) {
            CommonRequest request = new CommonRequest();
            request.setHeader(responseHead.toJavaObject(Header.class));
            request.setBody(data);
            String cuoheRequestData = JSON.toJSONString(request);
            logger.info("撮合请求：" + cuoheRequestData);
            apiResponse = apiFacadeService.doInvoke(cuoheRequestData);
            logger.info("撮合返回：" + apiResponse);
            insertTransInfo(serviceCode,orgCode,channelSystemId,cuoheRequestData,apiResponse);
            response = processService.afterService(responseHead, apiResponse, channelSystemId, privateKey );
        } else if (ChannelType.PRODUCT_SYS.getCode().equals(channelSystemId)){
            ProductRequest product = new ProductRequest();
            product.setData(data);
            product.setServiceCode(serviceCode);
            logger.info("产品系统请求参数：" + product);
            DefaultResponse defaultResponse=productService.invoke(product);
            logger.info("产品系统返回：" + defaultResponse);
            insertTransInfo(serviceCode,orgCode,channelSystemId,JSON.toJSONString(product),JSON.toJSONString(defaultResponse));
            response = processService.afterServiceProduct(responseHead, defaultResponse, privateKey );
        }   else if (ChannelType.ACCOUNT_SYS.getCode().equals(channelSystemId)){
            CommonRequest request = new CommonRequest();
            request.setHeader(responseHead.toJavaObject(Header.class));
            request.setBody(data);
            String amsRequestData = JSON.toJSONString(request);
            logger.info("账务系统请求参数：" + amsRequestData);
            String defaultResponse=accountApiFacade.doInvoke(amsRequestData);
            logger.info("账务系统返回：" + defaultResponse);
            insertTransInfo(serviceCode,orgCode,channelSystemId,amsRequestData,defaultResponse);
            response = processService.afterServiceAms(responseHead, defaultResponse, privateKey);
        }

        logger.info("返回结果:" + response);
        return response;
    }

    public void insertTransInfo(String serviceCode, String orgCode, String systemCode, String requestMsg, String apiResponse){
        QzgwTransInfoDO infoDO = new QzgwTransInfoDO();
        infoDO.setId(System.currentTimeMillis());
        infoDO.setTransNo(CommonUtil.getUUID());
        infoDO.setServiceCode(serviceCode);
        infoDO.setOrgCode(orgCode);
        infoDO.setSystemCode(systemCode);
        infoDO.setStatus("1");
        infoDO.setRequestMsg(requestMsg);
        infoDO.setResponseMsg(apiResponse);
        infoDO.setCreateTime(DateUtils.currentDateTime());
        infoDO.setModifiedTime(DateUtils.currentDateTime());
        qzgwTransInfoDAO.insert(infoDO);
    }

}

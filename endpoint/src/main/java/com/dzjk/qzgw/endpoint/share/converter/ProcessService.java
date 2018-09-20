package com.dzjk.qzgw.endpoint.share.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dzjk.product.model.base.DefaultResponse;
import com.dzjk.qzgw.core.common.enums.ChannelType;
import com.dzjk.qzgw.core.common.enums.ResultEnum;
import com.dzjk.qzgw.core.common.enums.TransType;
import com.dzjk.qzgw.core.common.exception.CommonException;
import com.dzjk.qzgw.core.common.util.AESUtil;
import com.dzjk.qzgw.core.common.util.MD5Util;
import com.dzjk.qzgw.core.common.util.RSAUtil;
import com.dzjk.qzgw.dal.dataobject.BmgwKeyManagerDO;
import com.dzjk.qzgw.endpoint.cache.QzgwKeyCache;
import com.dzjk.qzgw.endpoint.cache.QzgwOrgInfoCache;
import com.dzjk.qzgw.endpoint.cache.QzgwServiceInfoCache;
import com.dzjk.qzgw.endpoint.cache.QzgwServiceOrgCache;
import com.dzjk.qzgw.endpoint.service.InvokeServiceImpl;
import com.dzjk.qzgw.facade.model.*;
import com.dzjk.qzgw.facade.model.vo.QzgwKeyManagerVo;
import com.dzjk.qzgw.facade.model.vo.QzgwOrgInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceInfoVo;
import com.dzjk.qzgw.facade.model.vo.QzgwServiceOrgVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daixiaohu on 2018/5/2.
 */
@Service
public class ProcessService {
    private static Logger logger = LoggerFactory.getLogger(InvokeServiceImpl.class);
    private Header header = new Header();
    private Message message = new Message();
    private Body body = new Body();


    public String preService(JSONObject jsonObject, String key, String privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        String decryptData = "";

        JSONObject responseData = jsonObject.getJSONObject("body");
        if (responseData != null) {
            String encryData = responseData.getString("encryData");
            String signData = responseData.getString("signData");
            if (encryData != "") {
                if (!signData.equals(MD5Util.md5(encryData))) {
                    throw new CommonException(ResultEnum.VerifyFail, "");
                }
                String randomKey = RSAUtil.decryptByPrivateKey(key, privateKey);
                logger.info("解密出的随机key:" + randomKey);
                decryptData = AESUtil.decryptByAES(encryData, randomKey);
                logger.info("解密出的数据:" + decryptData);
            }
        }
        logger.info("解密结果数据:" + decryptData);
        return decryptData;
    }

    public FmgwResponse afterService(JSONObject responseHead, String responseData, String channelSystemId, String privateKey) throws Exception {
        FmgwResponse response = new FmgwResponse();
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(responseData);
        if (ChannelType.CUOHE_SYS.getCode().equals(channelSystemId)) {
            JSONObject rspMessage = (JSONObject) jsonObject.get("message");
            String status = rspMessage.getString("status");
            String desc = rspMessage.getString("desc");
            String encryData = "";
            String key = "";
            String signData = "";
            DataObject object = new DataObject();
            if ("000000".equals(status)) {
                String randomKey = AESUtil.getAutoCreateAESKey();
                JSONObject rspData = (JSONObject) jsonObject.get("body");
                encryData = AESUtil.encryptByAES(JSON.toJSONString(rspData), randomKey);
                key = RSAUtil.encryptByPrivateKey(randomKey, privateKey);
                signData = MD5Util.md5(encryData);
                header.setOrgCode(responseHead.getString("orgCode"));
                header.setOrgPwd(responseHead.getString("orgPwd"));
                header.setOrgUser(responseHead.getString("orgUser"));
                header.setOrgReqno(responseHead.getString("orgReqno"));
                header.setServiceCode(responseHead.getString("serviceCode"));
                header.setAgencyCode(responseHead.getString("agencyCode"));
                header.setKey(key);
                body.setEncryData(encryData);
                body.setSignData(signData);
                response.setHeader(header);
                message.setReturnCode(status);
                message.setReturnMsg(desc);
                response.setMessage(message);
                response.setBody(body);

            } else {
                response.setHeader(null);
                message.setReturnCode(status);
                message.setReturnMsg(desc);
                response.setMessage(message);
                response.setBody(null);
            }
        }
        return response;
    }

    public FmgwResponse afterServiceProduct(JSONObject responseHead, DefaultResponse defaultResponse, String privateKey) throws Exception {
        FmgwResponse response = new FmgwResponse();
        String status =  defaultResponse.getReturnCode();
        String desc =  defaultResponse.getReturnMsg();
        String encryData = "";
        String key = "";
        String signData = "";
        if ("0010000000".equals(status)) {
            String randomKey = AESUtil.getAutoCreateAESKey();
            String rspData = JSON.toJSONString(defaultResponse.getData());
            encryData = AESUtil.encryptByAES(rspData, randomKey);
            key = RSAUtil.encryptByPrivateKey(randomKey, privateKey);
            signData = MD5Util.md5(encryData);
            header.setOrgCode(responseHead.getString("orgCode"));
            header.setOrgPwd(responseHead.getString("orgPwd"));
            header.setOrgUser(responseHead.getString("orgUser"));
            header.setOrgReqno(responseHead.getString("orgReqno"));
            header.setServiceCode(responseHead.getString("serviceCode"));
            header.setKey(key);
            body.setEncryData(encryData);
            body.setSignData(signData);
            response.setHeader(header);
            message.setReturnCode(status);
            message.setReturnMsg(desc);
            response.setMessage(message);
            response.setBody(body);
        } else {
            response.setHeader(null);
            message.setReturnCode(status);
            message.setReturnMsg(desc);
            response.setMessage(message);
            response.setBody(null);
        }
        return response;
    }

    public FmgwResponse afterServiceAms(JSONObject responseHead, String responseData, String privateKey) throws Exception {
        FmgwResponse response = new FmgwResponse();
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(responseData);
            JSONObject rspMessage = (JSONObject) jsonObject.get("message");
            String status = rspMessage.getString("status");
            String desc = rspMessage.getString("desc");
        String encryData = "";
        String key = "";
        String signData = "";
        if ("000000".equals(status)) {
            String randomKey = AESUtil.getAutoCreateAESKey();
            logger.info("生成的随机数为randomKey:"+randomKey);
            Object rspData = jsonObject.get("data");
            logger.info("需要加密的数据为:"+rspData);
            if (rspData!=null){
                encryData = AESUtil.encryptByAES(JSON.toJSONString(rspData), randomKey);
            }
            key = RSAUtil.encryptByPrivateKey(randomKey, privateKey);
            signData = MD5Util.md5(encryData);
            header.setOrgCode(responseHead.getString("orgCode"));
            header.setOrgPwd(responseHead.getString("orgPwd"));
            header.setOrgUser(responseHead.getString("orgUser"));
            header.setOrgReqno(responseHead.getString("orgReqno"));
            header.setServiceCode(responseHead.getString("serviceCode"));
            header.setKey(key);
            body.setEncryData(encryData);
            body.setSignData(signData);
            response.setHeader(header);
            message.setReturnCode(status);
            message.setReturnMsg(desc);
            response.setMessage(message);
            response.setBody(body);
        } else {
            response.setHeader(null);
            message.setReturnCode(status);
            message.setReturnMsg(desc);
            response.setMessage(message);
            response.setBody(null);
        }
        return response;
    }

}

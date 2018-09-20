package com.dzjk.qzgw.web.controller;


import com.dzjk.qzgw.core.common.enums.ResultEnum;
import com.dzjk.qzgw.core.common.exception.CommonException;
import com.dzjk.qzgw.facade.InvokeService;
import com.dzjk.qzgw.facade.model.FmgwResponse;
import com.dzjk.qzgw.facade.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by daixiaohu on 2018/4/28.
 */
@Controller
@RequestMapping("/controller")
public class CommonController {
    private static Logger logger = LoggerFactory.getLogger(CommonController.class);
    @Resource
    private InvokeService invokeService;
//    @Value("${fmgw.url.white}")
//    private String urlWhite;

    @RequestMapping("/invoke")
    @ResponseBody
    public Object invoke(@RequestBody String body,HttpServletRequest request) throws Exception {
        logger.info("请求参数："+body);
        Message message = new Message();
        FmgwResponse response = new FmgwResponse();
        try {
            String ip = request.getHeader("X-Forwareded-For");
            logger.info("真实ip:"+ip);
            String remoteAddr = request.getRemoteAddr();
            logger.info("remoteAddr:"+remoteAddr);
            response = (FmgwResponse) invokeService.invoke(body);

        } catch (CommonException e) {
            message.setReturnCode(e.getCode());
            message.setReturnMsg(e.getMessage());
            response.setMessage(message);
            logger.error("异常", e);
        } catch (Exception e) {
            message.setReturnCode(ResultEnum.UNKONW_ERROR.getCode());
            message.setReturnMsg(ResultEnum.UNKONW_ERROR.getMsg());
            response.setMessage(message);
            logger.error("处理异常", e);
        }
        logger.info("返回信息："+response);
        return response;

    }
}

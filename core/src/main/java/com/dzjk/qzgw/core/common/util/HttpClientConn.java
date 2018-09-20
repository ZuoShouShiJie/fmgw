package com.dzjk.qzgw.core.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;


import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpClientConn {/*
    private String         endPoint;
    private SzrApplication szrApplication;
    private Header         dealInfo;
//    private String          dealInfo;
    private String         szrData;
    private String         publicKey;
    private InputStream    inputStream;
    private byte[]         fileBytes;
    private String         filePath;
    private File           file;
    private boolean        needEncrypt = false;
    private String         attribute1;
    private String         attribute2;
    private String         fileName    = "file";

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public SzrApplication getSzrApplication() {
        return szrApplication;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setSzrApplication(SzrApplication szrApplication) {
        this.szrApplication = szrApplication;
    }

    public String getSzrData() {
        return szrData;
    }

    public void setSzrData(String szrData) {
        this.szrApplication = JSONObject.parseObject(szrData, SzrApplication.class);
        this.szrData = szrData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isNeedEncrypt() {
        return needEncrypt;
    }

    public void setNeedEncrypt(boolean needEncrypt) {
        this.needEncrypt = needEncrypt;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Header getDealInfo() {
        return dealInfo;
    }

    public void setDealInfo(Header dealInfo) {
        this.dealInfo = dealInfo;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }




    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String postRequest() throws Exception {
        String result = "";
        if (this.szrApplication != null) {
            String key = null;
            String pwd = this.szrApplication.getHeader().getOrg_pwd();
            String body = JSON.toJSONString(szrApplication.getBody());
            key = AESUtil.getAutoCreateAESKey();
            this.szrApplication.setBody(AESUtil.encryptByAES(body, key));
            this.szrApplication.getHeader().setKey(RSAUtil.encryptByPublicKey(key, publicKey));
            if (pwd != null) {
                this.szrApplication.getHeader().setOrg_pwd(RSAUtil.encryptByPublicKey(pwd, publicKey));
            }
            Map paramMap = new HashMap();
            paramMap.put("szrData", JSON.toJSONString(this.szrApplication));
            //            this.szrApplication.getHeader().setOrg_pwd(pwd);
            //            this.szrApplication.setBody(body);
            //            this.szrApplication.getHeader().setKey(null);
            result = HttpUtil.post(this.endPoint, paramMap);
            if ((result != null) && (!"".equals(result))) {
                JSONObject jsonObject = JSON.parseObject(result);
                System.out.println(jsonObject);
                JSONObject message = jsonObject.getJSONObject("message");
                String status = message.getString("status");
                if (status != null && (status.equals("000000")|| status.equals("0000"))) {
                    JSONObject header = jsonObject.getJSONObject("header");
                    if (header != null) {
                        String bodyContent = jsonObject.getString("body");
                        if (bodyContent != null && bodyContent.trim() != "") {
                            key = RSAUtil.decryptByPublicKey(header.getString("key"), publicKey);

                            jsonObject.put("body", JSON.parseObject(AESUtil.decryptByAES(bodyContent, key)));
                        }
                    }
                    result = JSON.toJSONString(jsonObject);
                } else {
                    jsonObject.put("body", "");
                }
            }
        }
        return result;
    }

    public String deciphering(String responseMsg, String publickey) {
        JSONObject jsonObject = JSON.parseObject(responseMsg);
        JSONObject header = jsonObject.getJSONObject("header");
        if (header != null) {
            String key = "";
            try {
                key = RSAUtil.decryptByPublicKey(header.getString("key"), publicKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
            jsonObject.put("body", JSON.parseObject(AESUtil.decryptByAES(jsonObject.getString("body"), key)));
        }
        return JSON.toJSONString(jsonObject);
    }

    public static void main(String[] args) throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEb9QoSTWftbSoPKK2VjuwR58ZK/Rq/0gDrXqtMr8i5pp1m4veBn35QI0pKITe270vmOzIT0pI3AjeNVzYtFS+Z85+TD50QHRz2shJaBFNeVH2o0EMIakra0IYN/Qspv/cmFYH/xRSwHc7hXwbxrhq1rXkHWBparMbHUwq23B/8wIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIRv1ChJNZ+1tKg8orZWO7BHnxkr9Gr/SAOteq0yvyLmmnWbi94GfflAjSkohN7bvS+Y7MhPSkjcCN41XNi0VL5nzn5MPnRAdHPayEloEU15UfajQQwhqStrQhg39Cym/9yYVgf/FFLAdzuFfBvGuGrWteQdYGlqsxsdTCrbcH/zAgMBAAECgYA69OmWkZi8o5BsAKpSz6q8u/WYqBej9kch0/2z0s6CA/So/HjUe0FjT5hHxVD5QQtEgCiQt7OTIdkUyt6tXgIHJj0o/q7+3xmUbMvYLCNpJoLi9sToTjiESfzeuXRKWEfFzov0MIF9zGUR1fPYn9mWsKxoq2ChjM6Z+vGxOZsgmQJBAOEjv0oWrIvpOXsqzZK2/Rs3Ezd8sNkJOA2viUh9CDhVYmOtG+t8X1urzxqRkwp0xlJK3ru2meXdK5K86wJbd60CQQCWlxkAoPG1Zlo2niIhZb6oHCgRZe6b09Sh33P31hXsPRwK0xGuO1TxPhshFJO90MKn5J3uL70P3lN9A6/1eUofAkAAtEjr5WhCw8b/QKIF/HaMOD7iJIy1ERdQy6TFSkbVTkcRgsAcm3X85muubJgmJzlblopd0fNnSarSOa8OgdS9AkASCaM7CgwpuErSA/r+mRtPM6AxBU6hZ6wuf396jjAuDdvQCBw0DHNOOiwxuC9CK0FFrwKjxyAUSIMjlE99TbvtAkEAsbIlajQO2IZ2WBcXZSwN/2IvIAYf3fU8ovISPzwfA/ItaCjcuzlLhgq3dXsjQPNXLfGiLtVQQhBduzV400AEMw==";

        String key = AESUtil.getAutoCreateAESKey();
        String body = "{aaa:123}";
        String pwd = "123456";
        String encrybody = AESUtil.encryptByAES(body, key);
        String encrykey = RSAUtil.encryptByPublicKey(key, publicKey);
        String encrypwd = RSAUtil.encryptByPublicKey(pwd, publicKey);

        String depwd = RSAUtil.decryptByPrivateKey(encrypwd, privateKey);
        String dekey = RSAUtil.decryptByPrivateKey(encrykey, privateKey);
        String debody = AESUtil.decryptByAES(encrybody, dekey);
        System.out.println(depwd);
        System.out.println(key);
        System.out.println(dekey);
        System.out.println(debody);
        System.out.println(MD5Util.md5(depwd));
    }
*/
}
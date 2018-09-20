package com.dzjk.qzgw.test.account;

import com.alibaba.fastjson.JSON;
import com.dzjk.ams.core.common.util.DateUtils;
import com.dzjk.ams.facade.form.account.CapitalCostTrialReqForm;
import com.dzjk.qzgw.core.common.util.AESUtil;
import com.dzjk.qzgw.core.common.util.MD5Util;
import com.dzjk.qzgw.core.common.util.RSAUtil;
import com.dzjk.qzgw.endpoint.cache.QzgwKeyCache;
import com.dzjk.qzgw.test.account.form.Product;
import com.dzjk.qzgw.web.Slite2WebSpringBootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by daixiaohu on 2018/3/4.
 */
//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Slite2WebSpringBootApplication.class)//App是springboot 的启动类
public class AccountTest {
    static String ADD_URL = "http://localhost:8090/account/queryAccount";
    private static Logger logger = LoggerFactory.getLogger(AccountTest.class);

    /**
     *资金申请
     * @throws Exception
     */
    @Test
    public void testPreRepay() throws Exception {
      /*  String signData = RSAUtil.sign("daixiaohu".getBytes(),"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIRv1ChJNZ+1tKg8orZWO7BHnxkr9Gr/SAOteq0yvyLmmnWbi94GfflAjSkohN7bvS+Y7MhPSkjcCN41XNi0VL5nzn5MPnRAdHPayEloEU15UfajQQwhqStrQhg39Cym/9yYVgf/FFLAdzuFfBvGuGrWteQdYGlqsxsdTCrbcH/zAgMBAAECgYA69OmWkZi8o5BsAKpSz6q8u/WYqBej9kch0/2z0s6CA/So/HjUe0FjT5hHxVD5QQtEgCiQt7OTIdkUyt6tXgIHJj0o/q7+3xmUbMvYLCNpJoLi9sToTjiESfzeuXRKWEfFzov0MIF9zGUR1fPYn9mWsKxoq2ChjM6Z+vGxOZsgmQJBAOEjv0oWrIvpOXsqzZK2/Rs3Ezd8sNkJOA2viUh9CDhVYmOtG+t8X1urzxqRkwp0xlJK3ru2meXdK5K86wJbd60CQQCWlxkAoPG1Zlo2niIhZb6oHCgRZe6b09Sh33P31hXsPRwK0xGuO1TxPhshFJO90MKn5J3uL70P3lN9A6/1eUofAkAAtEjr5WhCw8b/QKIF/HaMOD7iJIy1ERdQy6TFSkbVTkcRgsAcm3X85muubJgmJzlblopd0fNnSarSOa8OgdS9AkASCaM7CgwpuErSA/r+mRtPM6AxBU6hZ6wuf396jjAuDdvQCBw0DHNOOiwxuC9CK0FFrwKjxyAUSIMjlE99TbvtAkEAsbIlajQO2IZ2WBcXZSwN/2IvIAYf3fU8ovISPzwfA/ItaCjcuzlLhgq3dXsjQPNXLfGiLtVQQhBduzV400AEMw==");
        System.out.print("signData:"+signData+"/n");
        System.out.print("boolean:"+RSAUtil.verify("daixiaohu".getBytes(),"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEb9QoSTWftbSoPKK2VjuwR58ZK/Rq/0gDrXqtMr8i5pp1m4veBn35QI0pKITe270vmOzIT0pI3AjeNVzYtFS+Z85+TD50QHRz2shJaBFNeVH2o0EMIakra0IYN/Qspv/cmFYH/xRSwHc7hXwbxrhq1rXkHWBparMbHUwq23B/8wIDAQAB",signData));

*/
//        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEb9QoSTWftbSoPKK2VjuwR58ZK/Rq/0gDrXqtMr8i5pp1m4veBn35QI0pKITe270vmOzIT0pI3AjeNVzYtFS+Z85+TD50QHRz2shJaBFNeVH2o0EMIakra0IYN/Qspv/cmFYH/xRSwHc7hXwbxrhq1rXkHWBparMbHUwq23B/8wIDAQAB";
//        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIRv1ChJNZ+1tKg8orZWO7BHnxkr9Gr/SAOteq0yvyLmmnWbi94GfflAjSkohN7bvS+Y7MhPSkjcCN41XNi0VL5nzn5MPnRAdHPayEloEU15UfajQQwhqStrQhg39Cym/9yYVgf/FFLAdzuFfBvGuGrWteQdYGlqsxsdTCrbcH/zAgMBAAECgYA69OmWkZi8o5BsAKpSz6q8u/WYqBej9kch0/2z0s6CA/So/HjUe0FjT5hHxVD5QQtEgCiQt7OTIdkUyt6tXgIHJj0o/q7+3xmUbMvYLCNpJoLi9sToTjiESfzeuXRKWEfFzov0MIF9zGUR1fPYn9mWsKxoq2ChjM6Z+vGxOZsgmQJBAOEjv0oWrIvpOXsqzZK2/Rs3Ezd8sNkJOA2viUh9CDhVYmOtG+t8X1urzxqRkwp0xlJK3ru2meXdK5K86wJbd60CQQCWlxkAoPG1Zlo2niIhZb6oHCgRZe6b09Sh33P31hXsPRwK0xGuO1TxPhshFJO90MKn5J3uL70P3lN9A6/1eUofAkAAtEjr5WhCw8b/QKIF/HaMOD7iJIy1ERdQy6TFSkbVTkcRgsAcm3X85muubJgmJzlblopd0fNnSarSOa8OgdS9AkASCaM7CgwpuErSA/r+mRtPM6AxBU6hZ6wuf396jjAuDdvQCBw0DHNOOiwxuC9CK0FFrwKjxyAUSIMjlE99TbvtAkEAsbIlajQO2IZ2WBcXZSwN/2IvIAYf3fU8ovISPzwfA/ItaCjcuzlLhgq3dXsjQPNXLfGiLtVQQhBduzV400AEMw==";
//        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALVesBM+mC2IO2YG7+oX4JPtqo+zLuGU7/xPrT/gn0P9KdIaCGbj3PK/AWRwGNyuTeUIYMw08mW95ym+t9Rnwvrke1xuLbnJ0rJbM06cvX/3n9bEbvOLaP0w32lDs7qRpyS1587LJiI0GCiZiEReAr2LSPN6qtttGEi7mUiq9SwjAgMBAAECgYEAmHxvlP5/e2iaaAFVHH/OtRCQ4hhIRiiuTHfAtX/o54Sl8JsqjTbuwLiONx94B7IUk4cjuwyY76ll/Nb4P4CtkE52XdGkkEd4WkFV7MN91Fe5SXDfq3MDCmgF+zd4jGB3oWMSo3pSFYF9gueYuRu/o643Hf4m50MYEEiM/9aC0iECQQDxX+jqQj0ZvnzyPiL9XJrpgDf8jL//WIWhkRc/G9oWDqlbVShAT0SCx2GOlIU7r6LLeSlJqJdgxB3ye8q/5x13AkEAwFwDGSj5UIic/dYf7SkkcHbsnuse0CVeLYgaUFNk5FGS4z4K5MMOSvUPy6fJ93Jr/doaahPNi3e9lLOFmIchtQJBAOBQmptB7ZiEL4fMeSXuLsT7dIxOnYuGz8Fjni/3CUjgXUFUtXB2ehvzgNVJbzwVsHvZ4KXkeLHj8FTN+JE5DmcCQAnV6pajwLO8eIKGK1W+D83sVsb9cLLl5j3fwrCuwu7luOQDrRzrWFS+2RLpvmr3n8v4FfeskYr7EWeEEmWtKy0CQCOAG0E0Ud1W+SRWSbSL3c1yehp3xZWQEzaPJeUwfZE/oF27wfee7CgSa/yXXXrFZHIacwnawB7OrWr5LZqsNc0=";
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";

        String key = AESUtil.getAutoCreateAESKey();
        ApplyAccountRequest request = new ApplyAccountRequest();
        request.setAppletime(DateUtils.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
        request.setName("小王");
        request.setIdType("06000");
        request.setIdNo("711001199101012301");
        request.setBirthdate("19910101");
        request.setGender("07000");
        request.setCellphone("13800001234");
        request.setBankCode("0302");
        request.setBankCardNo("6226900819212312");
        request.setHomePhone("010-12589632");
        request.setEmail("123456@qq.com");
        request.setAbodeDetail("上海市闵行区虹梅路269号");
        request.setAbodeZipcode("201801");
        request.setConAddress("上海市江场西路199号");
        request.setConZipcode("201804");
        request.setEmpPhone("010-12345678");
        request.setEmpProvince("上海市");
        request.setEmpCity("上海市");
        request.setEmpZone("嘉定区");
        request.setEmpAdd("上海市嘉定区陈翔路88号1幢3层B区2159室");
        request.setUnitName("上海幂科信息技术有限公司");
        request.setEmpStructure("11014");
        request.setEmpType("12007");
        request.setYearsOfWork("1");
        request.setEmpPost("15009");
        request.setEmpTitle("21002");
        request.setMaritalStatus("08002");
        request.setChildStatus("13001");
        request.setSocialIdentity("SI07");
        request.setQualification("09002");
        request.setDegree("20001");
        request.setSalary("10000.00");
        request.setHouseCondition("18006");
        request.setAppLmt("10000");
        request.setPeriodType("22001");
        request.setPeriod("6");
        List<ContactInfos> contactInfosList = new ArrayList<>();
        ContactInfos contactInfos = new ContactInfos();
        contactInfos.setContactSeq("0");
        contactInfos.setContactName("联系人1");
        contactInfos.setContactRelation("25001");
        contactInfos.setContactMobile("15800000000");
        contactInfosList.add(contactInfos);
        contactInfos = new ContactInfos();
        contactInfos.setContactSeq("1");
        contactInfos.setContactName("张三");
        contactInfos.setContactRelation("25007");
        contactInfos.setContactMobile("15800000001");
        contactInfosList.add(contactInfos);
        contactInfos = new ContactInfos();
        contactInfos.setContactSeq("2");
        contactInfos.setContactName("李四");
        contactInfos.setContactRelation("25012");
        contactInfos.setContactMobile("15800000002");
        contactInfosList.add(contactInfos);
        contactInfos = new ContactInfos();
        contactInfos.setContactSeq("3");
        contactInfos.setContactName("王五");
        contactInfos.setContactRelation("25013");
        contactInfos.setContactMobile("15800000003");
        contactInfosList.add(contactInfos);
        request.setContactInfos(contactInfosList);

        List<FileInfos> fileInfosList = new ArrayList<>();
        FileInfos fileInfos = new FileInfos();
        fileInfos.setFileType("05001");
        fileInfos.setFileSeq("1");
        fileInfos.setFilePath("home/leex/A20180119.zip>3.jpg");
        fileInfos.setSize("1");
        fileInfos.setDigest("111111");
        fileInfosList.add(fileInfos);
        fileInfos = new FileInfos();
        fileInfos.setFileType("05002");
        fileInfos.setFileSeq("2");
        fileInfos.setFilePath("home/leex/A20180119.zip>4.jpg");
        fileInfos.setSize("2");
        fileInfos.setDigest("222222");
        fileInfosList.add(fileInfos);
        fileInfos = new FileInfos();
        fileInfos.setFileType("05003");
        fileInfos.setFileSeq("3");
        fileInfos.setFilePath("home/leex/A20180119.zip>3.jpg");
        fileInfos.setSize("3");
        fileInfos.setDigest("333333");
        fileInfosList.add(fileInfos);
        fileInfos = new FileInfos();
        fileInfos.setFileType("05004");
        fileInfos.setFileSeq("4");
        fileInfos.setFilePath("home/leex/A20180119.zip>4.jpg");
        fileInfos.setSize("4");
        fileInfos.setDigest("444444");
        fileInfosList.add(fileInfos);
        request.setFileInfos(fileInfosList);

        String body = JSON.toJSONString(request);
        System.out.println("body:" + body);
        String randomKey = AESUtil.getAutoCreateAESKey();
        String encryData = AESUtil.encryptByAES(body, randomKey);
        key = RSAUtil.encryptByPublicKey(randomKey, publicKey);
        String signData = MD5Util.md5(encryData);
        System.out.println("encryData:" + encryData);
        System.out.println("key:" + key);
        System.out.println("signData:" + signData);

//        String encryData = AESUtil.encryptByAES("1234" ,"88888");
//        String key = RSAUtil.encryptByPrivateKey("88888", privateKey);
//        System.out.println("encryData:"+encryData);
//        System.out.println("key:"+key);
//        String pwd = "123456";
//        String encrybody = AESUtil.encryptByAES(body, key);
//        String encrykey = RSAUtil.encryptByPublicKey(key, publicKey);
////        String encrypwd = RSAUtil.encryptByPublicKey(pwd, publicKey);

//        String dekey = RSAUtil.decryptByPublicKey("oBaWBI5p+qrZirE+iUlVRXg22QkzD1R0bRkMo2c/CKqTqLBfWSo7u3FwSiS7Nj7zkxXIDqGRnEVKcipQHfYQaXVVcbu0updcYXNJg81pPDHx1QaxrZ8K7GQpqVoRHt4EsUltdxcab5tTzKcMM5pMKcTjhTzEheznLtMoeivrE2M=", publicKey);
//        String debody = AESUtil.decryptByAES("5414752916BABB356977A50A493848E21FFEE1BA2CFCC6056E1DD6DD7B52F0C7", dekey);
//       System.out.println("dekey:"+dekey);
//       System.out.println("debody:"+debody);
//        System.out.println(dekey);
//        System.out.println(debody);
//        System.out.println(MD5Util.md5(depwd));

    }

    /**
     * 资金申请查询
     * @throws Exception
     */
    @Test
    public void testPreRepaySelect() throws Exception {

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";

        String key = AESUtil.getAutoCreateAESKey();

        MoneySelect aselect=new MoneySelect();
        //场景资金申请编号
        aselect.setSerialNo("2000");
        //平台交易id（和serial二选一）
        aselect.setApplyDealId("2000");

        String body = JSON.toJSONString(aselect);
        System.out.println("body:" + body);
        String randomKey = AESUtil.getAutoCreateAESKey();
        String encryData = AESUtil.encryptByAES(body, randomKey);
        key = RSAUtil.encryptByPublicKey(randomKey, publicKey);
        String signData = MD5Util.md5(encryData);
        System.out.println("encryData:" + encryData);
        System.out.println("key:" + key);
        System.out.println("signData:" + signData);
    }

    /**
     *征信查询
     * @throws Exception
     */
    @Test
    public void testCredit() throws Exception {
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";
            String key=AESUtil.getAutoCreateAESKey();
            Credit credit=new Credit();

            credit.setSerialNo("2000");
            credit.setCertType("06000");
            credit.setCertId("711001199101012301");
            credit.setFullname("小王");
            credit.setQueryReason("35000");
            //贷款品种
            credit.setBusinessType("");

            String body=JSON.toJSONString(credit);
            System.out.println("body:"+body);
            String randomKey=AESUtil.getAutoCreateAESKey();
            String encryData=AESUtil.encryptByAES(body,randomKey);
            key=RSAUtil.encryptByPublicKey(randomKey,publicKey);
            String signData=MD5Util.md5(encryData);
            System.out.println("encryData:" + encryData);
            System.out.println("key:" + key);
            System.out.println("signData:" + signData);
    }

    /**
     * 短信发送
     * @throws Exception
     */
    @Test
    public void testMessae() throws  Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";
        String key=AESUtil.getAutoCreateAESKey();
        Message message=new Message();
        message.setMobileNo("13800001234");

        String body=JSON.toJSONString(message);
        System.out.println("body:"+body);
        String randomKey=AESUtil.getAutoCreateAESKey();
        String encryData=AESUtil.encryptByAES(body,randomKey);
        key=RSAUtil.encryptByPublicKey(randomKey,publicKey);
        String signData=MD5Util.md5(encryData);
        System.out.println("encryData:" + encryData);
        System.out.println("key:" + key);
        System.out.println("signData:" + signData);
    }
    /**
     * 开户
     * @throws Exception
     */
    @Test
    public void testAccount() throws  Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";
        String key=AESUtil.getAutoCreateAESKey();
        Account account=new Account();
        account.setCertType("06000");
        account.setCertId("722001199101012301");
        account.setCustBankMobile("18614231234");
        //银行卡账户
        account.setCustAcctNo("1234567890987654321");
        //短信验证码
        account.setOtp("063214");
        account.setFullName("小明");
        account.setMobileNo("13412673421");

        String body=JSON.toJSONString(account);
        System.out.println("body:"+body);
        String randomKey=AESUtil.getAutoCreateAESKey();
        String encryData=AESUtil.encryptByAES(body,randomKey);
        key=RSAUtil.encryptByPublicKey(randomKey,publicKey);
        String signData=MD5Util.md5(encryData);
        System.out.println("encryData:" + encryData);
        System.out.println("key:" + key);
        System.out.println("signData:" + signData);
    }

    @Test
    public void testproduct() throws  Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";
        String key=AESUtil.getAutoCreateAESKey();
        Product product=new Product();
      product.setProductCode("MC1032");

        String body=JSON.toJSONString(product);
        System.out.println("body:"+body);
        String randomKey=AESUtil.getAutoCreateAESKey();
        String encryData=AESUtil.encryptByAES(body,randomKey);
        key=RSAUtil.encryptByPublicKey(randomKey,publicKey);
        String signData=MD5Util.md5(encryData);
        System.out.println("encryData:" + encryData);
        System.out.println("key:" + key);
        System.out.println("signData:" + signData);
    }

    @Test
    public void testAms() throws  Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";
        String key=AESUtil.getAutoCreateAESKey();
        CapitalCostTrialReqForm form  =new CapitalCostTrialReqForm();
        form.setAmount("10000");
        form.setPeriod("4");
        form.setPrice("0.02");
        form.setType("2");

        String body=JSON.toJSONString(form);
        System.out.println("body:"+body);
        String randomKey=AESUtil.getAutoCreateAESKey();
        String encryData=AESUtil.encryptByAES(body,randomKey);
        key=RSAUtil.encryptByPublicKey(randomKey,publicKey);
        String signData=MD5Util.md5(encryData);
        System.out.println("encryData:" + encryData);
        System.out.println("key:" + key);
        System.out.println("signData:" + signData);
    }
    @Test
    public void testCache(){
       System.out.print( QzgwKeyCache.get("CUOHE1000"));

    }
}

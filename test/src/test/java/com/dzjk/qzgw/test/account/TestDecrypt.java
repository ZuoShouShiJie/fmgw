package com.dzjk.qzgw.test.account;

import com.dzjk.qzgw.core.common.util.AESUtil;
import com.dzjk.qzgw.core.common.util.RSAUtil;
import com.dzjk.qzgw.endpoint.share.converter.ProcessService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by daixiaohu on 2018/7/26.
 */
public class TestDecrypt {

    public static void main(String[] args) throws Exception {
  /*      String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1XrATPpgtiDtmBu/qF+CT7aqPsy7hlO/8T60/4J9D/SnSGghm49zyvwFkcBjcrk3lCGDMNPJlvecpvrfUZ8L65Htcbi25ydKyWzNOnL1/95/WxG7zi2j9MN9pQ7O6kacktefOyyYiNBgomYhEXgK9i0jzeqrbbRhIu5lIqvUsIwIDAQAB";
            //对返回的数据进行解签

        String key1="VEXedbVm+R+0Ynolx2Asyla7BTx5FQAxiFJAc3onEOvtrDvEyiRBYuHdmWlPNhBouM+oCX1Za0vZN170168yAIUyMfWp9c0o8ZbG5pyr/xfYsgRfGpTO0wIpDXI20IlW+H1SNI8aHh2FrrGfeVKuZjoMSGsOfEgYAlvTnjbZUJw=";
           String encryDataRe="FC8B45C70DDC128BC201ACBF71778BFB";
            String randomKeyRe = RSAUtil.decryptByPublicKey(key1, publicKey);
//            logger.info("用公钥解密出的随机key:" + randomKeyRe);
            //对返回的数据进行解密
                String decryptData = AESUtil.decryptByAES(encryDataRe, randomKeyRe);
//            logger.info("公钥解密后的明文数据:" + decryptData);
*/

        ProcessService service = new ProcessService();
        String a="{\"data\":[{\"boId\":\"sGEFHYq2oAgpZJchrlb0c7bq4eofP6wN\",\"extFields\":{},\"firstRepayDate\":\"2018-03-20\",\"idNo\":\"3333333\",\"idType\":\"1\",\"lastRepayDate\":\"2018-03-23\",\"orgId\":\"1000\",\"overdueTimes\":\"0\",\"repayPeriod\":\"6\",\"repayStatus\":\"1\",\"totalCapital\":10000.00,\"totalFine\":0.00,\"totalInterest\":3750.00,\"totalServiceFee\":0.00,\"userName\":\"dxh\"},{\"boId\":\"1122344\",\"extFields\":{},\"idNo\":\"3333333\",\"idType\":\"1\",\"lastRepayDate\":\"2018-05-25\",\"orgId\":\"1000\",\"overdueTimes\":\"16\",\"repayPeriod\":\"4\",\"repayStatus\":\"4\",\"totalCapital\":100.00,\"totalFine\":0.00,\"totalServiceFee\":7250.00,\"userName\":\"dxh\"},{\"boId\":\"333333\",\"extFields\":{},\"firstRepayDate\":\"2017-02-01\",\"idNo\":\"3333333\",\"idType\":\"1\",\"lastRepayDate\":\"2017-05-01\",\"orgId\":\"1000\",\"overdueTimes\":\"0\",\"repayPeriod\":\"4\",\"repayStatus\":\"1\",\"totalCapital\":100.00,\"totalFine\":0.00,\"totalServiceFee\":0.00,\"userName\":\"dxh\"}],\"extFields\":{},\"message\":{\"desc\":\"成功\",\"extFields\":{},\"status\":\"000000\"}}";
        service.afterServiceAms(null,a,null);


    }

}

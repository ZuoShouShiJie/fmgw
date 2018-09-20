package com.dzjk.qzgw.core.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**http://blog.csdn.net/defonds/article/details/42775183
 */
public class RSAUtil {
	private static Logger logger = LoggerFactory.getLogger(RSAUtil.class);

	/**加密算法RSA*/
    public static final String KEY_ALGORITHM = "RSA";
    
    /**签名算法*/
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**获取公钥的key*/
    private static final String PUBLIC_KEY = "RSAPublicKey";
    
    /**获取私钥的key*/
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    
    /**RSA最大加密明文大小*/
    private static final int MAX_ENCRYPT_BLOCK = 117;
    
    /** RSA最大解密密文大小*/
    private static final int MAX_DECRYPT_BLOCK = 128;
    

    /** 
     *  生成密钥对(公钥和私钥)
     * @return Map 密钥对
     * @throws NoSuchAlgorithmException 
     */
    public static Map<String, Object> genKeyPair(){
        KeyPairGenerator keyPairGen;
        KeyPair keyPair = null;
		try {
				keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
				keyPairGen.initialize(1024);
				keyPair = keyPairGen.generateKeyPair();	
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
	    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(PUBLIC_KEY, publicKey);
        map.put(PRIVATE_KEY, privateKey);
        return map;
    }
    
    /** 
     * 用私钥对信息生成数字签名
     * @param data 签名数据
     * @param privateKey 私钥
     * @return String 签名信息
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws InvalidKeyException 
     * @throws SignatureException 
     * @throws Exception 
     */
    public static String sign(byte[] data, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] keyBytes = Base64Util.base64ToByteArray(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);
        return Base64Util.byteArrayToBase64(signature.sign());
    }

    /** 
     * 校验数字签名
     * @param data 签名数据
     * @param publicKey 公钥
     * @param sign 签名信息
     * @return Boolean
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws InvalidKeyException 
     * @throws SignatureException 
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException  {
        byte[] keyBytes = Base64Util.base64ToByteArray(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);
        return signature.verify(Base64Util.base64ToByteArray(sign));
    }

    /**
     * 私钥解密
     * @param encryptedData 加密后数据
     * @param privateKey 私钥
     * @return byte[] 原数据
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws IOException 
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException  {
        byte[] keyBytes = Base64Util.base64ToByteArray(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        byte[] decryptedData=null;
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, privateK);
			int inputLen = encryptedData.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			while (inputLen - offSet > 0) {
			    if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
			        cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			    } else {
			        cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			    }
			    out.write(cache, 0, cache.length);
			    i++;
			    offSet = i * MAX_DECRYPT_BLOCK;
			}
			decryptedData = out.toByteArray();
			out.close();
			return decryptedData;
        
    }

    /**
     * 私钥解密
     * @param encryptedData
     * @param privateKey
     * @return
     */
    public static String decryptByPrivateKey(String encryptedData, String privateKey)  {
				byte[] decryptData;
				String result="";
				try {
					decryptData = decryptByPrivateKey(Base64Util.base64ToByteArray(encryptedData), privateKey);
					result=new String(decryptData,ConstValue.CHAR_SET_UTF8);
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (InvalidKeySpecException e) {
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				} catch (BadPaddingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return result;
    }
    /**
     * 公钥解密
     * @param encryptedData 加密后数据
     * @param publicKey 公钥
     * @return byte[] 原数据
     * @throws NoSuchAlgorithmException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeySpecException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws IOException 
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keyBytes = Base64Util.base64ToByteArray(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }
    
    public static String decryptByPublicKey(String encryptedData, String publicKey) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, IOException {
					byte[] decryptData = decryptByPublicKey(Base64Util.base64ToByteArray(encryptedData), publicKey);
					return new String(decryptData,ConstValue.CHAR_SET_UTF8);
				
    }

    /**
     * 公钥加密
     * @param data 原数据
     * @param publicKey 公钥
     * @return byte[] 加密后数据
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws IOException 
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keyBytes = Base64Util.base64ToByteArray(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 公钥加密
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, String publicKey) throws Exception{
    	try {
			byte[] encodeData = null;
			encodeData = RSAUtil.encryptByPublicKey(data.getBytes(ConstValue.CHAR_SET_UTF8), publicKey);
			return Base64Util.byteArrayToBase64(encodeData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getCause());
			throw e;
		}
		
    }
    /**
     * 私钥加密
     * @param data 原数据
     * @param privateKey 私钥
     * @return byte[] 加密后数据
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws IOException 
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keyBytes = Base64Util.base64ToByteArray(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    public static String encryptByPrivateKey(String data, String privateKey) {
    		String result="";
			try {
				byte[] encodeData = RSAUtil.encryptByPrivateKey(data.getBytes(ConstValue.CHAR_SET_UTF8), privateKey);
				result=Base64Util.byteArrayToBase64(encodeData);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		
		
    }
    /**
     * 获取私钥
     * @param keyMap 密钥对
     * @return String 私钥
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64Util.byteArrayToBase64(key.getEncoded());
    }

    /** 
     * 获取公钥
     * @param keyMap 密钥对
     * @return String 公钥
     */
    public static String getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64Util.byteArrayToBase64(key.getEncoded());
    }

}

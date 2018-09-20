package com.dzjk.qzgw.core.common.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 
 * 类功能描述：<br>
 * http://blog.csdn.net/guotong1988/article/details/8314646
 * http://baike.baidu.com/subview/133041/5358738.htm
 * http://blog.csdn.net/hbcui1984/article/details/5201247
 * http://www.cnblogs.com/freeliver54/archive/2011/10/08/2202136.html
 * <ul>    
 * <li>类功能描述1<br>
 * <li>类功能描述2<br>
 * <li>类功能描述3<br>
 * </ul>
 * 修改记录：<br>
 * <ul>    
 * <li>修改记录描述1<br>
 * <li>修改记录描述2<br>
 * <li>修改记录描述3<br>
 * </ul>
 * @author zhouwy
 * @version since 2015年7月31日
 */
public class AESUtil {
	private static final String AES="AES";
	private static final String SHA1_PRNG = "SHA1PRNG";     
	private static final int AES_KEY_SIZE = 128; 

	/*
	 * 转为十六进制
	 */
	private static String asHex(byte buf[]) {
		StringBuffer strbuf = new StringBuffer(buf.length * 2);
		int i;
		for (i = 0; i < buf.length; i++) {
			if (((int) buf[i] & 0xff) < 0x10)
				strbuf.append("0");
			strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
		}
		return strbuf.toString().toUpperCase();
	}

	/*
	 * 转为二进制
	 */
	private static byte[] asBin(String src) {
		if (src.length() < 1)
			return null;
		byte[] encrypted = new byte[src.length() / 2];
		for (int i = 0; i < src.length() / 2; i++) {
			int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);
			encrypted[i] = (byte) (high * 16 + low);
		}
		return encrypted;
	}

	public static String encryptByAES(byte[] data, String password) {
		try {             
            KeyGenerator kgen = KeyGenerator.getInstance(AES);  
//            http://www.jb51.net/article/40941.htm
//            kgen.init(128, new SecureRandom(password.getBytes())); 
            SecureRandom secureRandom = SecureRandom.getInstance(SHA1_PRNG );
            secureRandom.setSeed(password.getBytes());
            kgen.init(AES_KEY_SIZE, secureRandom);
            SecretKey secretKey = kgen.generateKey();  
            byte[] enCodeFormat = secretKey.getEncoded();  
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);  
            Cipher cipher = Cipher.getInstance(AES);// 创建密码器  
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
            byte[] result = cipher.doFinal(data);  
            return asHex(result); // 加密  
	    } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	    } catch (NoSuchPaddingException e) {  
	            e.printStackTrace();  
	    } catch (InvalidKeyException e) {  
	            e.printStackTrace();  
	    } catch (IllegalBlockSizeException e) {  
	            e.printStackTrace();  
	    } catch (BadPaddingException e) {  
	            e.printStackTrace();  
	    }  
	    return null;  
	}
	
	public static String encryptByAES(String data, String password) {
		try {             
            KeyGenerator kgen = KeyGenerator.getInstance(AES);  
//            kgen.init(128, new SecureRandom(password.getBytes()));
            SecureRandom secureRandom = SecureRandom.getInstance(SHA1_PRNG );
            secureRandom.setSeed(password.getBytes());
            kgen.init(AES_KEY_SIZE, secureRandom);
            SecretKey secretKey = kgen.generateKey();  
            byte[] enCodeFormat = secretKey.getEncoded();  
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);  
            Cipher cipher = Cipher.getInstance(AES);// 创建密码器  
            byte[] byteContent = data.getBytes(ConstValue.CHAR_SET_UTF8);  
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
            byte[] result = cipher.doFinal(byteContent);  
            return asHex(result); // 加密  
	    } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	    } catch (NoSuchPaddingException e) {  
	            e.printStackTrace();  
	    } catch (InvalidKeyException e) {  
	            e.printStackTrace();  
	    } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	    } catch (IllegalBlockSizeException e) {  
	            e.printStackTrace();  
	    } catch (BadPaddingException e) {  
	            e.printStackTrace();  
	    }  
	    return null;  
	}
	
	
	
	/**解密 
	 * @param encrpytedStr  待解密内容 
	 * @param password 解密密钥 
	 * @return 
	 */  
	public static String decryptByAES(String encrpytedStr, String password) {  
	        try {  
	                 KeyGenerator kgen = KeyGenerator.getInstance(AES);  
//	                 kgen.init(128, new SecureRandom(password.getBytes()));
	                 SecureRandom secureRandom = SecureRandom.getInstance(SHA1_PRNG );
	                 secureRandom.setSeed(password.getBytes());
	                 kgen.init(AES_KEY_SIZE, secureRandom);
	                 SecretKey secretKey = kgen.generateKey();  
	                 byte[] enCodeFormat = secretKey.getEncoded();  
	                 SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);              
	                 Cipher cipher = Cipher.getInstance(AES);// 创建密码器  
	                cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
	                byte[] result = cipher.doFinal(asBin(encrpytedStr));  
	                return new String(result,ConstValue.CHAR_SET_UTF8); // 加密  
	        } catch (NoSuchAlgorithmException e) {  
	                e.printStackTrace();  
	        } catch (NoSuchPaddingException e) {  
	                e.printStackTrace();  
	        } catch (InvalidKeyException e) {  
	                e.printStackTrace();  
	        } catch (IllegalBlockSizeException e) {  
	                e.printStackTrace();  
	        } catch (BadPaddingException e) {  
	                e.printStackTrace();  
	        }  
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	        return null;  
	}  
	
	 public static String getAutoCreateAESKey() {  
		 	String result="";
			try {
				KeyGenerator kg = KeyGenerator.getInstance(AES);
				kg.init(AES_KEY_SIZE);//要生成多少位，只需要修改这里即可128, 192或256  
			    SecretKey sk = kg.generateKey();  
			    result=asHex(sk.getEncoded());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
	        return result;
	    }  
}

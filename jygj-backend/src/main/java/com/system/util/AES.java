package com.system.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class AES {
	private static Logger log = Logger.getLogger(AES.class);
	/** 
	 * 加密 
     *  
     * @param content 需要加密的内容 
     * @param password  加密密码 
     * @return 
     */  
	public static String encrypt(String content, String password) {  
		try {             
			KeyGenerator kgen = KeyGenerator.getInstance("AES");  
//			kgen.init(256, new SecureRandom(password.getBytes())); 
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" ); 
	        secureRandom.setSeed(password.getBytes());
	        kgen.init(256,secureRandom);
			SecretKey secretKey = kgen.generateKey();  
            byte[] enCodeFormat = secretKey.getEncoded();  
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器  AES/ECB/PKCS5Padding
            byte[] byteContent = content.getBytes("utf-8");  
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
            byte[] encryptResult = cipher.doFinal(byteContent);
            String result =  parseByte2HexStr(encryptResult);
            return result;
		} catch (Exception e) {
        	log.error(e.getMessage());
        }
        return null;  
    }
    
    /**解密 
     * @param content  待解密内容 
     * @param password 解密密钥 
     * @return 
     */  
    public static String decrypt(String content, String password) {  
    	try {  
    		KeyGenerator kgen = KeyGenerator.getInstance("AES");  
//    		kgen.init(256, new SecureRandom(password.getBytes()));  
    		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" ); 
	        secureRandom.setSeed(password.getBytes());
	        kgen.init(256,secureRandom);
    		SecretKey secretKey = kgen.generateKey();  
    		byte[] enCodeFormat = secretKey.getEncoded();  
    		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
    		Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
    		cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
    		byte[] decryptFrom = parseHexStr2Byte(content);
    		byte[] decryptResult = cipher.doFinal(decryptFrom);  
    		String result = new String(decryptResult,"utf-8");
    		return result;
    	} catch (Exception e) {
    		e.printStackTrace();
    		log.error(e.getMessage());
        }
        return null;  
    }
    
    /**将二进制转换成16进制 
     * @param buf 
     * @return 
     */  
    public static String parseByte2HexStr(byte buf[]) {  
    	StringBuffer sb = new StringBuffer();  
    	for (int i = 0; i < buf.length; i++) {  
    		String hex = Integer.toHexString(buf[i] & 0xFF);  
    		if (hex.length() == 1) {  
    			hex = '0' + hex;  
    		}  
    		sb.append(hex.toUpperCase());  
    	}  
    	return sb.toString();  
    }
    
    /**将16进制转换为二进制 
     * @param hexStr 
     * @return 
     */  
    public static byte[] parseHexStr2Byte(String hexStr) {  
    	if (hexStr.length() < 1) { 
    		return null;
    	}
    	byte[] result = new byte[hexStr.length()/2];  
    	for (int i = 0;i< hexStr.length()/2; i++) {  
    		int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
    		int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
    		result[i] = (byte) (high * 16 + low);  
    	}  
    	return result;
    }  
}

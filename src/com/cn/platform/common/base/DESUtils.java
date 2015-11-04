package com.cn.platform.common.base;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DESUtils {
	/**
	 * ��Կ
	 */
	public static final String DEFAULT_KEY = "sjz.hbbill.com";

	/**
	 * ����
	 * 
	 * @param message
	 *            ���ܺ������
	 * @param key
	 *            ��Կ
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String message, String key) throws Exception {

		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	/**
	 * ����
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		return cipher.doFinal(message.getBytes("UTF-8"));
	}

	public static byte[] convertHexString(String ss) {
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}

		return digest;
	}

	public static String encryptEN(String message) throws Exception {
		return DESUtils.encrypt2(message, "cuifei88");
	}

	/**
	 * ���ܣ����ص��Ǽ��ܺ���ַ���
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt2(String message, String key) throws Exception {
		String jiami = java.net.URLEncoder.encode(message, "utf-8")
				.toLowerCase();
		String a = toHexString(encrypt(jiami, key)).toUpperCase();
		return a;
	}

	public static String decryptEN(String message) throws Exception {
		return DESUtils.decrypt2(message, "cuifei88");
	}

	/**
	 * ���ܣ����ص��ǽ��ܺ���ַ���
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt2(String message, String key) throws Exception {
		String result = java.net.URLDecoder.decode(decrypt(message, key),
				"utf-8");
		return result;
	}

	public static void main(String[] args) throws Exception {
		String key = "BOTWAVEE";
		/*
		 * macun,macun,13,1 macun,macun,14,2 macun,macun,15,3 hhh,hhh,16,1
		 * hhh,hhh,17,2 hhh,hhh,18,3
		 */
		String jiami = "macun,macun,13,1";

		System.out.println("\n��������:" + jiami);
		String a = toHexString(encrypt(jiami, key)).toUpperCase();
		System.out.println("\n1���ܺ������Ϊ1:" + a);
		String r = toHexString(encrypt(a, key)).toUpperCase();
		System.out.println("\n2���ܺ������Ϊ2:" + r);
		
		/*
		 * String b = java.net.URLDecoder.decode(decrypt(r, "BOTWAVEE"),
		 * "utf-8"); System.out.println("1���ܺ������:" + b);
		 * 
		 * String e = java.net.URLDecoder.decode(decrypt(b, "BOTWAVEE"),
		 * "utf-8"); System.out.println("2���ܺ������:" + e);
		 */
		
	}

	public static String encryptENOrC(String jiami) throws Exception {// ����
		String key = "BOTWAVEE";
		String a = toHexString(encrypt(jiami, key)).toUpperCase();
		return a;
	}

	public static String decryptENOrC(String jiemi) throws Exception {// ����
		String key = "BOTWAVEE";
		String b = java.net.URLDecoder.decode(decrypt(jiemi, key), "utf-8");
		return b;
	}

	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}

		return hexString.toString();
	}
}
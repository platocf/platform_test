package com.cn.platform.common.base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static void main(String[] argc)
	{
		System.out.print(Md5("wlj123",baseVar.MD5TYPE16));
	}
	public static String Md5(String plainText ,int type) { 
		try { 
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainText.getBytes()); 
		byte b[] = md.digest(); 

		int i; 

		StringBuffer buf = new StringBuffer(""); 
		for (int offset = 0; offset < b.length; offset++) 
		{ 
			i = b[offset]; 
			if(i<0) i+= 256; 
			if(i<16) 
			buf.append("0"); 
			buf.append(Integer.toHexString(i)); 
		} 

		//System.out.println("result: " + buf.toString());//32位的加密 
		
		//System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 
		switch(type)
		{
			case baseVar.MD5TYPE32:
				return buf.toString();
			case baseVar.MD5TYPE16:
				return buf.toString().substring(8,24);
			default:
				return "&&&&&&&&&&&&&&&&Error&&&&&&&&&&&&&&&&&&&";
		}
		} catch (NoSuchAlgorithmException e) { 
			
		// TODO Auto-generated catch block 
		e.printStackTrace(); 
		}
		return "mustn't arrived here"; 
		} 
}

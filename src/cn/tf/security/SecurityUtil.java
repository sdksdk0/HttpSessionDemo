package cn.tf.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

import com.sun.mail.util.BASE64EncoderStream;

public class SecurityUtil {
	
	
	public static String md5(String message){
		
		try {
			MessageDigest  md=MessageDigest.getInstance("md5");
			byte b[] = md.digest(message.getBytes());
			
			BASE64Encoder  base64=new BASE64Encoder();
			return base64.encode(b);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(md5("abc"));
	}

}

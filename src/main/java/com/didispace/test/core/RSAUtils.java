package com.didispace.test.core;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RSAUtils {
	public static String encryptBase64(String text, String key) {
		return new String(new BASE64Encoder().encodeBuffer(encrypt(text, key)));
	}

	private static byte[] encrypt(String text, String key) {
		try {
			PublicKey publicKey = KeyFactory.getInstance("RSA")
					.generatePublic(new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(key)));
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] plainText = cipher.doFinal(new BASE64Decoder().decodeBuffer(text));
			return plainText;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String decryptBase64(String text, String key) {
		return new String(new BASE64Encoder().encodeBuffer(decrypt(text, key)));
	}

	private static byte[] decrypt(String text, String key) {
		try {
			PrivateKey privateKey = KeyFactory.getInstance("RSA")
					.generatePrivate(new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(key)));
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] plainText = cipher.doFinal(new BASE64Decoder().decodeBuffer(text));
			return plainText;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

//	public static void main(String[] args) throws Exception {
//		File privfile = new File("D:\\Document\\Cryptographic\\privkey.txt");
//		File pubfile = new File("D:\\Document\\Cryptographic\\pubkey.txt");
//		FileReader reader = new FileReader(pubfile);
//
//		BufferedReader br = new BufferedReader(reader);
//		StringBuilder sb = new StringBuilder();
//		String s;
//		while ((s = br.readLine()) != null) {
//			sb.append(s);
//		}
//		br.close();
//		reader.close();
////        String pubstr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArscq6NtMvcVyrjJtWd5Y1+tsj/SQaN55\nP9qeS2u1j4yMHGvuyF9Jodq6yHkPdgHbAMv84zsVWK/4T7vDn8SO51qY/wutw3M86x8HDwdD45Wj\nM7szk9fDn0mkdDAqBHk+cdsQ4lwQCDigzF6cfhvM/FZDwFCKo4cwoPhViId4NRt+4MGH8RbIYx4r\nBN+cqRCqx4y5UiCTspX/GO6zIQ4wXpeI+pTyeEqp2J1bYXrwyBq6XD4HwuPtr44vOpn9m0MZgOzl\nKRAMS2m5rjGI+ADki9QhPNunS0sZi1WkP8yZ3KCV4r86UieT+Ahox4vkRjq4pkhuaN1mA4X8YW8Z\n82kaUQIDAQAB";
////        String pristr = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCuxyro20y9xXKuMm1Z3ljX62yP9JBo3nk/2p5La7WPjIwca+7IX0mh2rrIeQ92AdsAy/zjOxVYr/hPu8OfxI7nWpj/C63DczzrHwcPB0PjlaMzuzOT18OfSaR0MCoEeT5x2xDiXBAIOKDMXpx+G8z8VkPAUIqjhzCg+FWIh3g1G37gwYfxFshjHisE35ypEKrHjLlSIJOylf8Y7rMhDjBel4j6lPJ4SqnYnVthevDIGrpcPgfC4+2vji86mf2bQxmA7OUpEAxLabmuMYj4AOSL1CE826dLSxmLVaQ/zJncoJXivzpSJ5P4CGjHi+RGOrimSG5o3WYDhfxhbxnzaRpRAgMBAAECggEAVspQZJGB6jrCV/5yjs37ED24C0RG8cyIKU1Gje1Om5oPeY2fZaDrz5PubN6w7si9GAgz7CLK1t+LTwzOd+gDjp9OmlgSUZxIA/nEZ5IUBE+qW2X6ls/uNIs9PvUr6EzM1X0TRVSyIWL9dn8E9xqXEDdGLZnRPqNDYqvuzX14E+ZfApPKBjDWRuD5lb36k7h61EiRWaSde4UggNiKlXPNTvvxu8EsBG1A8uRcdIFovNWNzYXTBUtGoG0OR6wStsR9hponNBB2IE7G79PZYk/GYemT1WSz+a2uedtgZv30xAXjnyCC6UREPFsgkMtBGJSGNJKG6T2wAsT1HxGIgMywgQKBgQD17xMJ7W8LAPnGmxDxsJLyd3yrZj6EclFLqtSvfrXLreCqGwHmQLfLPWFp7KRZe4NhOaSIEgJ529A0lcrvT6EeHIFxsT6foB2LqLisFsL75qho6twnatAgmTjbh7uEOjy+FBWLDikTBpN3zDAuyOVG763G8SeFGDgWJFTGpCH7HwKBgQC17oNZT3aumNWZmXLpwvn0oBVL08v6W28Fca4wFCLBTTY8U7h+M9nQAWQZCF0IFXpRDk67w8Xrzk0Xriq58ldQIojLNO0ImqU7X6EQz80RycvlIntFvftJL3Rtk9T05SNXpFdbHSw17O5Lge+Ue+e0GJSl/Zb4U1oLtqGxDqusjwKBgQCwx/KSj0bjzQa+mZabdQacHgHSnwNPZ3FCiACsSdPaHhnBjPpXjavP/0Y3wu/8lolA6RN48CExgS1vr0EZts6k+26c0ACo84ppapWcthvgwNPL3w7zkpca56j0POQwzz/8jilSNJKX54E3euIjrysIS59Jwu1agadHW0RJKZB3lwKBgB6wWCnFlMCI+WcKkm7KO/2+zzjWRk86AzVI4tgrXV18F8z/Vly7hF9pDKiIV6EYdmSb5D4aHRXU2/5Fm+F39rCG0spsaBuOcpbcX8AFPZNlleZV9bNjA7NptNsTF9YjnN2Y1D+DYUTLbbsA9Rf3+rLPfqutZj0HWmYlbYr/bYgTAoGAaX7AA0HOIr00laNKggTrB0VPGwaw9tQDm38LOAscB9PQfVMQIgrG2D226rc1MoqJrmxfSQ+eLOW0hwLF7wuRHd3ZZtJoDxa5AWT5U4CVa5m+vJUXbLoLkec/kV1BHvOY3km5wQPfuzGuIDrmqX47KZGHp5acR+k4ahx38IecBE8=";
//		String encryptedText = encryptBase64("111", sb.toString());
//		//String encryptedText = encryptBase64("111111", pubstr);
//		System.out.println("encrypted: " + encryptedText);
//		reader = new FileReader(privfile);
//		br = new BufferedReader(reader);
//		sb = new StringBuilder();
//		while ((s = br.readLine()) != null) {
//			sb.append(s);
//		}
//		br.close();
//		reader.close();
//		String decryptedText = decryptBase64(encryptedText, sb.toString());
//		//String decryptedText = decryptBase64(encryptedText, pristr);
//		System.out.println("decrypted: " + decryptedText);
//	}
}


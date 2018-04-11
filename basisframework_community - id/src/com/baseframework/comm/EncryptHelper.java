package com.baseframework.comm;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;

/***
 *  加密解密帮助类
 * @author 王鸿钦
 *
 */
public class EncryptHelper {
	private static byte[] DESkey = "wanghongqin".substring(0, 8).getBytes();
	private static byte[] DESIV = { 0x12, 0x34, 0x56, 0x78, (byte) 0x90,
			(byte) 0xAB, (byte) 0xCD, (byte) 0xEF };// 设置向量，略去

	private static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现
	private static SecretKey key = null;

	static {
		DESKeySpec keySpec;
		try {
			keySpec = new DESKeySpec(DESkey);
			iv = new IvParameterSpec(DESIV);// 设置向量
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
			key = keyFactory.generateSecret(keySpec);// 得到密钥对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 设置密钥参数

	}

	/**
	 * 加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
		enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
		byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
		Base64 base64Encoder = new Base64();
		return base64Encoder.encodeToString(pasByte);
	}

	/**
	 * 解密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		deCipher.init(Cipher.DECRYPT_MODE, key, iv);
		Base64 base64Decoder = new Base64();
		byte[] databyte = base64Decoder.decode(data.getBytes());
		byte[] pasByte = deCipher.doFinal(databyte);
		return new String(pasByte, "UTF-8");
	}
}

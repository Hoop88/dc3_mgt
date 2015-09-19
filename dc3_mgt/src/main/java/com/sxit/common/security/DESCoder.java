package com.sxit.common.security;

import java.nio.charset.Charset;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 
 * @author agu
 * 
 */
public abstract class DESCoder {

	public static final String KEY_ALGORITHM = "DES";

	public static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";

	private static final byte[] ENCIV = { (byte) 0xEF, (byte) 0xAB,
			(byte) 0x56, (byte) 0x78, (byte) 0x90, (byte) 0x34, (byte) 0xCD,
			(byte) 0x12 };

	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance(KEY_ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(dks);
		return secretKey;
	}

	public static byte[] encrypt(byte[] data, byte[] key) {
		try {
			Key k = toKey(key);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			AlgorithmParameterSpec iv = new IvParameterSpec(ENCIV);
			cipher.init(Cipher.ENCRYPT_MODE, k, iv);
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] data, byte[] key) {
		try {
			Key k = toKey(key);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			AlgorithmParameterSpec iv = new IvParameterSpec(ENCIV);
			cipher.init(Cipher.DECRYPT_MODE, k, iv);
			return cipher.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密
	 * 
	 * @param dataStr
	 * @param keyStr
	 * @return
	 */
	public static String encrypt(String dataStr, String keyStr) {

		byte[] dateBytes = DESCoder.encrypt(
				dataStr.getBytes(Charset.forName("utf-8")), keyStr.getBytes());
		
		return Base64.encode(dateBytes);
	}

	/**
	 * 解密
	 * 
	 * @param dataStr
	 * @param keyStr
	 * @return
	 */
	public static String decrypt(String dataStr, String keyStr) {
		try {
			byte[] dataBytes = Base64.decode(dataStr);
			dataBytes = DESCoder.decrypt(dataBytes, keyStr.getBytes());
			return new String(dataBytes, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		String key = "123556000000";
		String data = "[{\"createTime\":\"2013-01-15T11:15:21\",\"deskey\":\"123123123\",\"name\":\"测试\",\"state\":1,\"taggedId\":1,\"taggedStr\":\"www.baidu.com\"},{\"createTime\":\"2013-01-15T11:15:21\",\"deskey\":\"123123123\",\"name\":\"测试2\",\"state\":1,\"taggedId\":2,\"taggedStr\":\"www.zhg3.com\"}]";

		byte[] sb = DESCoder.encrypt(data.getBytes(), key.getBytes());

		byte[] sb2 = DESCoder.decrypt(sb, key.getBytes());

		System.out.println(new String(sb2));

		String s = DESCoder.encrypt(data, key);
		System.out.println(s);
		String s1 = DESCoder.decrypt(s, key);

		System.out.println(s1);

	}

}

package com.sxit.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageUtil {
	/**
     * 将图片文件转换成十六进制
     * @param file
     * @return
     */
    public static String imageFileToHexStr(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
 
            byte[] buff = new byte[1024];
            int len = 0;
            int i=0;
            while ((len = fis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            // 得到图片的字节数组
            byte[] result = bos.toByteArray();
            // 字节数组转成十六进制
            return "0x"+byte2HexStr(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
 
    /**
     * 将十六进制字符串转换成字节输出流
     * @param src
     * @return
     */
    public static ByteArrayOutputStream strToOutStream(String src) {
        if (src == null || src.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte[] bytes = src.getBytes();
            for (int i = 0; i < bytes.length; i += 2) {
                out.write(charToInt(bytes[i]) * 16 + charToInt(bytes[i + 1]));
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
 
    /**
     * 将十六进制字符串转换成字节输入流
     * @param src
     * @return
     */
    public static ByteArrayInputStream strToInStream(String src) {
        if (src == null || src.length() == 0) {
            return null;
        }
        if(src.startsWith("0x"))
        {
        	src=src.substring(2);
        }
        ByteArrayInputStream input = new ByteArrayInputStream(strToOutStream(src).toByteArray());
        try {
            input.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return input;
    }
 
    /*
     * 实现字节数组向十六进制的转换方法一
     */
    private static String byte2HexStr(byte[] b) {
        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
            {
                hs.append("0" + stmp);
            }
            else
            	hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }
 
    private static int charToInt(byte ch) {
        int val = 0;
        if (ch >= 0x30 && ch <= 0x39) {
            val = ch - 0x30;
        } else if (ch >= 0x41 && ch <= 0x46) {
            val = ch - 0x41 + 10;
        }
        return val;
    }
	/** 
	 * @Description: TODO
	 * @param args  
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.out.println(imageFileToHexStr("C:\\D\\build\\2.jpg"));
	}

}

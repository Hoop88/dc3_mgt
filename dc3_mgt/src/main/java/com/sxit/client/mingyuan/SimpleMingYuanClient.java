package com.sxit.client.mingyuan;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;



public class SimpleMingYuanClient {
	public static final Logger LOG = Logger.getLogger(SimpleMingYuanClient.class);

	public static String execute(String url, String params) {
		LOG.info("====================================调用明源接口 begin====================================");
		LOG.info("HTTP Request url : " + url);
		LOG.info("HTTP Request params : " + params);

		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		try {
			URL uri = new URL(url);
			URLConnection connection = uri.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);

			outputStream = httpURLConnection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
			outputStreamWriter.write(params);
			outputStreamWriter.flush();

			if (httpURLConnection.getResponseCode() >= 300) {
				throw new Exception(
						"HTTP Request is not success, Response code is "
								+ httpURLConnection.getResponseCode());
			}

			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}
			LOG.info("ResponseContext : " + resultBuffer.toString());
			return resultBuffer.toString();
		} catch (Exception e) {
			LOG.error("调用明源接口发生异常", e);
			return null;
		} finally {
			try {
				if (outputStreamWriter != null) {
					outputStreamWriter.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (inputStreamReader != null) {
					inputStreamReader.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (Exception e) {
				LOG.error("关闭流异常", e);
			}
			LOG.info("====================================调用明源接口 end====================================");
		}
	}

}

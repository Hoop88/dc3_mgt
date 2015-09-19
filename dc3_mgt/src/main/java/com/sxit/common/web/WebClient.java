package com.sxit.common.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class WebClient {

	private DefaultHttpClient httpclient;
	private String host;
	public String Referer;
	public String cookies;
	public String contentType;

	public WebClient() {
		httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter("http.socket.timeout", 10000);
		httpclient.getParams().setParameter("http.connection.timeout", 30000);
		httpclient.getParams().setParameter("http.connection-manager.timeout",
				60 * 60L);

		CookieSpecFactory csf = new CookieSpecFactory() {
			public CookieSpec newInstance(HttpParams params) {
				return new BrowserCompatSpec() {
					@Override
					public void validate(Cookie cookie, CookieOrigin origin)
							throws MalformedCookieException {
						// Oh, I am easy
					}
				};
			}
		};
		httpclient.getCookieSpecs().register("easy", csf);
		httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY, "easy");
		httpclient.getParams().setParameter(
				CookieSpecPNames.SINGLE_COOKIE_HEADER, true);
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setCooiesStore(CookieStore cookieStore) {
		httpclient.setCookieStore(cookieStore);
	}

	public void setTimeOut(Integer times) {
		httpclient.getParams().setParameter("http.connection.timeout", times);
	}

	public void setSocketTimeOut(Integer times) {
		httpclient.getParams().setParameter("http.socket.timeout", times);
	}

	public String doGet(String url) {
		String charset = "UTF-8";
		
		return doGet(url, charset);
	}

	public String doGet(String url, String charset) {

		HttpUriRequest httpget = new HttpGet(url);
		
		httpget.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
		
		if (cookies != null) {
			httpget.addHeader("Cookie", cookies);
		}

		try {
			HttpResponse response = httpclient.execute(httpget);

			Header[] headers = response.getHeaders("Set-Cookie");
			for (Header header : headers) {
				cookies = header.getValue();
				cookies = cookies.replace("HttpOnly", "");
				cookies = cookies.replace("path=/;", "");
			}

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return new String(EntityUtils.toByteArray(entity),charset);
			}
			return null;
		} catch (ClientProtocolException e) {
			System.err.println(e);
			return null;
		} catch (IOException e) {
			System.err.println(e);
			return null;
		} finally {
			if (httpget != null) {
				httpget.abort();
			}
		}
	}

	public InputStream getImage(String url) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		HttpUriRequest httpget = new HttpGet(url);

		if (cookies != null) {
			httpget.addHeader("Cookie", cookies);
		}

		try {
			HttpResponse response = httpclient.execute(httpget);

			Header[] headers = response.getHeaders("Set-Cookie");

			for (Header header : headers) {
				// System.out.println(header.getName() + ":" +
				// header.getValue());
				cookies = header.getValue();
				cookies = cookies.replace("HttpOnly", "");
				cookies = cookies.replace("path=/;", "");
			}

			/*
			 * headers = response.getAllHeaders(); for (Header header : headers)
			 * { System.out.println(header.getName() + ":" + header.getValue());
			 * }
			 */

			HttpEntity entity = response.getEntity();

			entity.writeTo(output);
			InputStream imageStream = new ByteArrayInputStream(
					output.toByteArray());
			return imageStream;
		} catch (ClientProtocolException e) {
			System.err.println(e);
			return null;
		} catch (IOException e) {
			System.err.println(e);
			return null;
		} finally {
			if (httpget != null) {
				httpget.abort();
			}
			try {
				output.close();
			} catch (IOException e) {
				System.err.println(e);
				return null;
			}
		}
	}

	public String doPost(String url, String params, String charset) {

		HttpPost httppost = new HttpPost(url);

		if (contentType == null) {
			httppost.addHeader("Content-Type", "application/json");
		} else {
			httppost.addHeader("Content-Type", contentType);
		}

		if (Referer != null) {
			httppost.addHeader("Referer", Referer);
		}

		if (cookies != null) {
			httppost.addHeader("Cookie", cookies);
		}

		try {
			// 构造最简单的字符串数据
			StringEntity reqEntity = new StringEntity(params,
					Charset.forName(charset));
			// 设置类型
			reqEntity.setContentType("application/x-www-form-urlencoded");
			// 设置请求的数据
			httppost.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(httppost);

			Header[] headers = response.getHeaders("Set-Cookie");
			for (Header header : headers) {
				cookies = header.getValue();
				cookies = cookies.replace("HttpOnly", "");
				cookies = cookies.replace("path=/;", "");
			}

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return new String(EntityUtils.toByteArray(entity),charset);
			}
			return null;
		} catch (ClientProtocolException e) {
			System.err.println(e);
			return null;
		} catch (IOException e) {
			System.err.println(e);
			return null;
		} finally {
			if (httppost != null) {
				httppost.abort();
			}
		}
	}

	/**
	 * 
	 * @param url
	 * @param files
	 * @return
	 */
	public String doPostFile(String url, List<File> files) {

		return doPostFile(url, files, "utf-8");

	}

	/**
	 * 
	 * @param url
	 * @param files
	 * @param charset
	 * @return
	 */
	public String doPostFile(String url, List<File> files, String charset) {

		HttpPost httppost = new HttpPost(url);

	

		if (Referer != null) {
			httppost.addHeader("Referer", Referer);
		}

		if (cookies != null) {
			httppost.addHeader("Cookie", cookies);
		}

		try {

			MultipartEntity reqEntity = new MultipartEntity();

			int i = 0;
			for (File file : files) {
				FileBody bin = new FileBody(file);
				i++;
				reqEntity.addPart("uploadfile" + i, bin);
			}

			// 设置请求的数据
			httppost.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(httppost);

			Header[] headers = response.getHeaders("Set-Cookie");
			for (Header header : headers) {
				cookies = header.getValue();
				cookies = cookies.replace("HttpOnly", "");
				cookies = cookies.replace("path=/;", "");
			}

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				return EntityUtils.toString(entity, Charset.forName(charset));
			}
			return null;
		} catch (ClientProtocolException e) {
			System.err.println(e);
			return null;
		} catch (IOException e) {
			System.err.println(e);
			return null;
		} finally {
			if (httppost != null) {
				httppost.abort();
			}
		}
	}

	/**
	 * @Description:
	 * @param args
	 */

	public static void main(String[] args) {
		// Auto-generated method stub

		WebClient client = new WebClient();
		String url = "http://epg.tvsou.com/program/TV_61/Channel_497/W1.htm";
		String html = client.doGet(url, "gb2312");

		System.out.println(html);

	}
}

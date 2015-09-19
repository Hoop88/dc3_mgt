package com.sxit.common.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpsClient {

	private DefaultHttpClient httpclient;
	private String host;
	public String Referer;
	public String cookies;

	public HttpsClient() {

	}

	/**
	 * 初始化HTTPS
	 * 
	 * @return
	 */
	public boolean init() {
		return init(443);
	}

	/**
	 * 初始化HTTPS
	 * 
	 * @param port
	 * @return
	 */
	public boolean init(int port) {
		try {
			X509TrustManager trustManager = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
					// Don't do anything.
				}

				public void checkServerTrusted(X509Certificate[] chain,
						String authType) throws CertificateException {
					// Don't do anything.
				}

				public X509Certificate[] getAcceptedIssuers() {
					// Don't do anything.
					return null;
				}
			};
			SSLContext sslcontext = SSLContext.getInstance("SSL");
			sslcontext.init(null, new TrustManager[] { trustManager }, null);

			SSLSocketFactory sf = new SSLSocketFactory(sslcontext);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			httpclient = new DefaultHttpClient();
			httpclient.getConnectionManager().getSchemeRegistry()
					.register(new Scheme("https", sf, port));

			httpclient.getParams().setParameter("http.socket.timeout", 10000);
			httpclient.getParams().setParameter("http.connection.timeout",
					30000);
			httpclient.getParams().setParameter(
					"http.connection-manager.timeout", 60 * 60L);

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
			httpclient.getParams().setParameter(ClientPNames.COOKIE_POLICY,
					"easy");
			httpclient.getParams().setParameter(
					CookieSpecPNames.SINGLE_COOKIE_HEADER, true);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void setCooiesStore(CookieStore cookieStore) {
		httpclient.setCookieStore(cookieStore);
	}

	public void setTimeOut(long times) {
		httpclient.getParams().setParameter("http.connection.timeout", times);
	}

	public String doGet(String url) {
		String charset = "utf-8";
		return doGet(url, charset);
	}

	public String doGet(String url, String charset) {

		HttpUriRequest httpget = new HttpGet(url);

		if (cookies != null) {
			httpget.addHeader("Cookie", cookies);
		}

		try {
			HttpResponse response = httpclient.execute(httpget);

			Header[] headers = response.getHeaders("Set-Cookie");
			for (Header header : headers) {
				System.out.println(header.getName() + ":" + header.getValue());
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
		httppost.addHeader("Content-Type", "application/json");

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
		//  Auto-generated method stub

		HttpsClient client = new HttpsClient();
		client.init();
		String url = "https://103.242.2.20/auth/login.html";
		String html = client.doGet(url, "utf-8");

		System.out.println(html);

	}
}

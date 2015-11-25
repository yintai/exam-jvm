package com.yintai.exam.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http 请求工具类
 * 
 * @author 刘腾飞
 */
public class HttpClientUtil {
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * Http json post 请求
	 * 
	 * @author 刘腾飞
	 * @param url
	 * @param content
	 * @return
	 */
	public static String postMethod(String url, String content, String contentType) throws Exception {
		if (contentType == null || "".equals(contentType.trim())) {
			contentType = "application/json;charset=UTF-8";
		}
		HttpClient client = new HttpClient();
		client.getParams().setContentCharset("UTF-8");
		// 使用POST方法
		PostMethod method = new PostMethod(url);
		method.setRequestHeader("Content-Type", contentType);
		method.setRequestEntity(new StringRequestEntity(content, contentType, "UTF-8"));
		method.getParams().setContentCharset("UTF-8");
		logger.info("发送请求内容=》" + content);
		// 设置参数编码
		HttpMethodParams param = method.getParams();
		param.setContentCharset("UTF-8");
		int status = 0;
		try {
			status = client.executeMethod(method);
			if (status == HttpStatus.SC_OK) {
				logger.info(status + "发送请求成功=》" + url);
				// String resp = method.getResponseBodyAsString();
				String resp = inputStream2String(method.getResponseBodyAsStream()); // 如果返回请求数据量大，以流的形式返回数据
				logger.info("返回内容：" + resp);
				if (null != resp) {
					return resp;
				} else {
					logger.info("返回结果是空的");
					return "";
				}
			} else {
				logger.info(status + "发送请求失败=》" + url);
				String resp = method.getResponseBodyAsString();
				if (null != resp) {
					method.abort();
					return resp;
				} else {
					method.abort();
					logger.info("返回结果是空的");
					return "";
				}
			}
		} catch (HttpException e) {
			logger.error("", e);
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			// 释放连接
			method.releaseConnection();
		}
		return null;
	}

	private static String inputStream2String(InputStream is) throws UnsupportedEncodingException {
		BufferedReader in = null;
		in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			logger.error("", e);
		}
		return buffer.toString();
	}
}

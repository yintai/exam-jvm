package com.linzhijia.boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 * PAYING_STATE(1,"支付中"),
UNPAY_STATE(0,"待付款"),
PAID_STATE(2,"支付完成"),
UNEXCEPTION_STATE(3,"其他异常状态"),
ALL_STATE(-1,"全部状态");
 */
public class AddTradeTestMain {

	public static void main(String[] args) {
		try {
			//使用用户张三创建一条86元5角人民币的交易记录，验证交易状态为等待付款，并且交易的金额是正确的。
			String result = executeHttpPost("0","86.5","张三");
			System.out.println(result);
			//初始化3条交易成功信息，2条交易失败信息（测第一个问题顺便把第二个初始化）
			executeHttpPost("3","100","张三");
			executeHttpPost("0","70","王五");
			executeHttpPost("2","50","张三");
			executeHttpPost("2","40","王五");
			executeHttpPost("2","20","李四");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String executeHttpPost(String tradeState,String tradeAmount,String customerName) throws Exception {
		BufferedReader in = null;
		try {
			// 定义HttpClient
			HttpClient client = new DefaultHttpClient();
			// 实例化HTTP方法
			HttpPost request = new HttpPost("http://localhost:8080/trade/createTradeInfo");
			
			// 创建名/值组列表
			List<NameValuePair> parameters = new ArrayList<NameValuePair>();
				parameters.add(new BasicNameValuePair("tradeState", tradeState));
				parameters.add(new BasicNameValuePair("tradeAmount", tradeAmount));
				parameters.add(new BasicNameValuePair("customerName", customerName));
			

			// 创建UrlEncodedFormEntity对象
			UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(
					parameters,"UTF-8");
			request.setEntity(formEntiry);
			// 执行请求
			HttpResponse response = client.execute(request);

			in = new BufferedReader(new InputStreamReader(response.getEntity()
					.getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();
			String result = sb.toString();
			return result;
	 
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}

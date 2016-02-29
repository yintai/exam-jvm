package com.linzhijia.boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/**
 * 测试就是
 * @author linzhijia
 *
 */
public class GetTradeByStateTestMain {

	public static void main(String[] args) {
		/**
		 * PAYING_STATE(1,"支付中"),
	UNPAY_STATE(0,"待付款"),
	PAID_STATE(2,"支付完成"),
	UNEXCEPTION_STATE(3,"其他异常状态"),
	ALL_STATE(-1,"全部状态");
		 */
		/**
		 * 验证查询接口按全部状态查询共5条交易，只查询成功的交易是3条，只查询失败的交易是2条。
		 * -1 http://localhost:8080/trade/queryTradeByState/-1
		 * 2 http://localhost:8080/trade/queryTradeByState/2
		 * 3 http://localhost:8080/trade/queryTradeByState/3
		 */
		try {
			String result = executeHttpPost(0);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String executeHttpPost(Integer tradeState) throws Exception {
		BufferedReader in = null;
		try {
			// 定义HttpClient
			HttpClient client = new DefaultHttpClient();
			// 实例化HTTP方法
			HttpGet request = new HttpGet("http://localhost:8080/trade/queryTradeByState/"+tradeState);
			
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

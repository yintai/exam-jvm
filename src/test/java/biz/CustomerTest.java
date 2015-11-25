package biz;

import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.yintai.exam.domain.Customer;
import com.yintai.exam.util.HttpClientUtil;

public class CustomerTest {
	// 根据用户id查询用户信息
	@Test
	@Ignore//单元测试的时候先把这个注解去掉，否则该单元测试方法不起作用
	public void queryCustomerById() throws Exception {
		String url = "http://127.0.0.1:8080/exam/customer/queryCustomerById";
		Customer cus = new Customer();
		cus.setId(1L);
		String resp = HttpClientUtil.postMethod(url, JSON.toJSONString(cus), null);
		System.out.println(resp);
	}

	// 根据用户id查询用户信息2
	@Test
	@Ignore//单元测试的时候先把这个注解去掉，否则该单元测试方法不起作用
	public void queryCustomerById2() throws Exception {
		String url = "http://127.0.0.1:8080/exam/customer/queryCustomerById2";
		Customer cus = new Customer();
		cus.setId(1L);
		String resp = HttpClientUtil.postMethod(url, JSON.toJSONString(cus), null);
		System.out.println(resp);
	}
}

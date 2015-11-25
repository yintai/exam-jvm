package biz;

import java.math.BigDecimal;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.yintai.exam.domain.Order;
import com.yintai.exam.enums.OrderCurrency;
import com.yintai.exam.enums.OrderState;
import com.yintai.exam.enums.OrderType;
import com.yintai.exam.util.HttpClientUtil;
import com.yintai.exam.util.JsonFormatTool;

public class OrderTest {
	/**
	 * 使用用户张三创建一条86元5角人民币的交易记录，验证交易状态为等待付款，并且交易的金额是正确的。
	 */
	@Test
	public void createTrade() throws Exception {
		String url = "http://127.0.0.1:8080/exam/order/createTrade";
		Order order = new Order();
		order.setCustomerno(1L);
		order.setStatus(OrderState.WAIT_PAYMENT.getValue());
		order.setType(OrderType.PAYMENT.getValue());
		order.setMoney(new BigDecimal(86.5));
		order.setCurrency(OrderCurrency.RMB.getValue());

		String resp = HttpClientUtil.postMethod(url, JSON.toJSONString(order), null);
		System.out.println(resp);
	}

	/**
	 * 验证查询接口按全部状态查询共5条交易，只查询成功的交易是3条，只查询失败的交易是2条。
	 */
	@Test
	public void queryOrderByStatus() throws Exception {
		// String url =
		// "http://127.0.0.1:8080/exam/order/queryOrderByStatus/-1";//查询全部
		// String url =
		// "http://127.0.0.1:8080/exam/order/queryOrderByStatus/0";//查询失败
		String url = "http://127.0.0.1:8080/exam/order/queryOrderByStatus/1";// 查询成功
		String resp = HttpClientUtil.postMethod(url, "", null);
		System.out.println(new JsonFormatTool().formatJson(resp));
	}
}

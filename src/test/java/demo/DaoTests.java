package demo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yintai.exam.Application;
import com.yintai.exam.dao.CustomerMapper;
import com.yintai.exam.dao.OrderMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class DaoTests {
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private OrderMapper orderMapper;

	@Test
	public void findsFirstPageOfCities() {
		System.out.println("=======================================");
		System.out.println(customerMapper);
		System.out.println(orderMapper); 
		System.out.println("=======================================");
	}
}
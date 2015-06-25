import com.sample.entity.Business;
import com.sample.service.BusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liuwang
 * Date: 15-6-26
 * Time: 上午12:01
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BusinessSerivceTest {

    @Configuration
    @ComponentScan(basePackages={"com.sample.service"})
    static class ContextConfiguration {}
    @Resource
    private BusinessService businessService;

    @Test
    public void testSave(){
        Business b=new     Business();
        b.setStatus("交易成功");
        b.setId(1);
        b.setCreateTime(new Date(System.currentTimeMillis()));
        b.setCustomerId(1);
        b.setCurrency("RMB");
        b.setMoney(34.5);
        b.setType("支付");
        b.setCustomerName("张三");
        businessService.addBusiness(b);

        b.setStatus("交易成功");
        b.setId(2);
        b.setCreateTime(new Date(System.currentTimeMillis()));
        b.setCustomerId(1);
        b.setCurrency("RMB");
        b.setMoney(44.5);
        b.setType("支付");
        b.setCustomerName("张三");

        businessService.addBusiness(b);
        b.setStatus("交易成功");
        b.setId(3);
        b.setCreateTime(new Date(System.currentTimeMillis()));
        b.setCustomerId(1);
        b.setCurrency("RMB");
        b.setMoney(41.5);
        b.setType("支付");
        b.setCustomerName("张三");
        businessService.addBusiness(b);

        b.setStatus("交易失败");
        b.setId(4);
        b.setCreateTime(new Date(System.currentTimeMillis()));
        b.setCustomerId(1);
        b.setCurrency("RMB");
        b.setMoney(11.5);
        b.setType("退款");
        b.setCustomerName("张三");
        businessService.addBusiness(b);

        b.setStatus("交易失败");
        b.setId(5);
        b.setCreateTime(new Date(System.currentTimeMillis()));
        b.setCustomerId(1);
        b.setCurrency("RMB");
        b.setMoney(31.5);
        b.setType("支付");
        b.setCustomerName("张三");
        businessService.addBusiness(b);
    }

    @Test
    public void testQuery(){
        Business b=new     Business();
        b.setStatus("交易成功");
       List<Business> blist= businessService.getBusiness(b);
        for(Business bb:blist){
          System.out.println(bb.toStr());
        }
    }
}

package contraller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Order;
import service.Service;

@RestController
public class CustomController {

	private Service ser=new Service();
	
	@RequestMapping("/test")
	public void test(){
		System.out.println("ni da ye !");
	}
	
	
	

    @RequestMapping("/create")
    public Order create(@RequestParam(value="name") String name,@RequestParam(value="createTime") String createTime,@RequestParam(value="type") int type,@RequestParam(value="money") double money,@RequestParam(value="moneyType") int moneyType) {
        
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	Order order=new Order();
		try {
			order.setCreateTime(format.parse(createTime));
			order.setState(1);
			order.setType(type);
			order.setMoney(money);
			order.setInfo(name);
			order.setMoneyType(moneyType);
	    	order.setId(System.currentTimeMillis());
	    	ser.saveOrder(order);
	    	return order;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return order;
		}
    }
    
    
    @RequestMapping("/check")
    public List<Order> check(@RequestParam(value="name") String name,@RequestParam(value="type") int type) {
    	List<Order> order=ser.checkOrder(name, type);
        return order;
    }
}
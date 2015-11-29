package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OrderList") 
public class OrderList {

    
    private ArrayList<Order> orderL=new ArrayList<Order>();  

  
    public void setOrderL(ArrayList<Order> orderList) {  
        this.orderL = orderList;
    }
  
    @XmlElement(name = "Order")
    public ArrayList<Order> getOrderL() {  
        return orderL;  
    } 
}

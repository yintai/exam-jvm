package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import entity.CustomList;
import entity.OrderList;

public class ExchangeXMLandBean {

	private static final String ORDER_XML = "./src/main/resources/Order.xml";
	private static final String CUSTOM_XML = "./src/main/resources/Customs.xml";
	
	
	public void customBeanToXML(CustomList custom) {
		try {
			JAXBContext context = JAXBContext.newInstance(CustomList.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(custom, System.out);
	        Writer w = null;  
	        try {  
	            w = new FileWriter(CUSTOM_XML);  
	            marshaller.marshal(custom, w);  
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {  
	            try {  
	                w.close();  
	            } catch (Exception e) {  
	            }  
	        }
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public CustomList xMLToCustomBean() {
		
		try {
			JAXBContext context = JAXBContext.newInstance(CustomList.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			CustomList custom = (CustomList) unmarshaller.unmarshal(new FileReader(CUSTOM_XML));
			return custom;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void orderBeanToXMLString(OrderList order) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(OrderList.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(order, System.out);
	        Writer w = null;  
	        try {  
	            w = new FileWriter(ORDER_XML);  
	            marshaller.marshal(order, w);  
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {  
	            try {  
	                w.close();  
	            } catch (Exception e) {  
	            }  
	        }
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	public OrderList xMLStringToOrderBean() {


		try {
			JAXBContext context = JAXBContext.newInstance(OrderList.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			OrderList order = (OrderList) unmarshaller.unmarshal(new FileReader(ORDER_XML));
			return order;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class RestImpl implements RestInter {

	public void addTrans(String userId ,String userName,double money,int tranState){
		//生成随机字符串作为交易记录的Id
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";  
		Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < base.length(); i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		TransRecord trans1 =new TransRecord();
		trans1.setTranId(sb.toString());
		trans1.setTranAmount(money);
		trans1.setTranBZ("人民币");
		trans1.setTranState(tranState);
		trans1.setTranTime(new Date());
		trans1.setTranType("支付");
		trans1.setUser(user);
		System.out.println("交易记录已生成！");
	}
	/**
	 * @param tranState 交易状态
	 *@return 交易记录的List集合 
	 **/
	public List<TransRecord> queryTrans(int tranState){
		if(tranState != 0 && tranState != 1){
			return null;
		}else{
			List<TransRecord> list = init();
			List<TransRecord> retList = new ArrayList<TransRecord>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTranState() == tranState){
					retList.add(list.get(i));
				}
			}
			for(int j=0;j<retList.size();j++){
				System.out.print(retList.get(j).getTranId()+"  ");
				System.out.print(retList.get(j).getTranTime()+"  ");
				System.out.print(retList.get(j).getTranState()+"  ");
				System.out.print(retList.get(j).getTranType()+"  ");
				System.out.print(retList.get(j).getTranAmount()+"  ");
				System.out.print(retList.get(j).getTranBZ()+"  ");
				System.out.print(retList.get(j).getUser().getUserId()+"  ");
				System.out.println();
			}
			return retList;
		}
	}
	private List<TransRecord> init(){
		List<TransRecord> list = new ArrayList<TransRecord>();
		User user = new User();
		user.setUserId("001");
		user.setUserName("张三");
		TransRecord trans1 =new TransRecord();
		trans1.setTranId("01");
		trans1.setTranAmount(54.5);
		trans1.setTranBZ("人民币");
		trans1.setTranState(0);
		trans1.setTranTime(new Date());
		trans1.setTranType("支付");
		trans1.setUser(user);
		list.add(trans1);
		
		TransRecord trans2 =new TransRecord();
		trans2.setTranId("02");
		trans2.setTranAmount(99.5);
		trans2.setTranBZ("人民币");
		trans2.setTranState(0);
		trans2.setTranTime(new Date());
		trans2.setTranType("支付");
		trans2.setUser(user);
		list.add(trans2);
		
		TransRecord trans3 =new TransRecord();
		trans3.setTranId("03");
		trans3.setTranAmount(11.3);
		trans3.setTranBZ("人民币");
		trans3.setTranState(1);
		trans3.setTranTime(new Date());
		trans3.setTranType("支付");
		trans3.setUser(user);
		list.add(trans3);
		
		TransRecord trans4 =new TransRecord();
		trans4.setTranId("04");
		trans4.setTranAmount(11.3);
		trans4.setTranBZ("人民币");
		trans4.setTranState(1);
		trans4.setTranTime(new Date());
		trans4.setTranType("支付");
		trans4.setUser(user);
		list.add(trans4);
		
		TransRecord trans5 =new TransRecord();
		trans5.setTranId("05");
		trans5.setTranAmount(9999);
		trans5.setTranBZ("人民币");
		trans5.setTranState(1);
		trans5.setTranTime(new Date());
		trans5.setTranType("支付");
		trans5.setUser(user);
		list.add(trans5);
		
		return list;
		
	}
}

/**
 *客户端 
 **/
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RestInter res = new RestImpl();
		res.addTrans("001", "张三", 100, 1);
		res.queryTrans(0);//查询未完成的订单
		res.queryTrans(1);//查询已完成的订单

	}

}

import java.util.List;


public interface RestInter {

	//添加交易记录
	public void addTrans(String userId ,String userName,double money,int tranState);
	//根据交易状态查询交易记录
	public List<TransRecord> queryTrans(int tranState);
}

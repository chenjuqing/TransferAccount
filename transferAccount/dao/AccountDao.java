package cn.sxt.dao;

import java.util.List;
import java.util.Map;

public interface AccountDao {
	
	void addAccount(Map<String, Object> paramMap);
	
	List<Map<String,Object>> queryAccountList(Map<String, Object> paramMap);
	
	//还款账户修改余额
	void updateRepaymentAccount(Map<String, Object> paramMap);
	
	//收款账户修改余额
	void updateReceiveAccount(Map<String, Object> paramMap);
}

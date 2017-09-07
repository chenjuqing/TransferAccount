package cn.sxt.service;

import java.util.List;
import java.util.Map;

public interface AccountService {
	
	void addAccount(Map<String, Object> paramMap);
	
	List<Map<String,Object>> queryAccountList(Map<String, Object> paramMap);
	
	void updateTransferMoney(Map<String, Object> paramMap);
}

package cn.sxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.AccountDao;
import cn.sxt.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public void addAccount(Map<String, Object> paramMap) {
		accountDao.addAccount(paramMap);
	}

	@Override
	public List<Map<String, Object>> queryAccountList(
			Map<String, Object> paramMap) {
		return accountDao.queryAccountList(paramMap);
	}

	@Override
	public void updateTransferMoney(Map<String, Object> paramMap) {
		
		Map<String, Object> repayParamMap = new HashMap<String, Object>();
		repayParamMap.put("ACCOUNT_NUM", paramMap.get("repaymentAccountNum"));
		repayParamMap.put("money", paramMap.get("money"));
		accountDao.updateRepaymentAccount(repayParamMap);
		
//		paramMap.get("abccd").toString();
		
		Map<String, Object> receiveParamMap = new HashMap<String, Object>();
		receiveParamMap.put("ACCOUNT_NUM", paramMap.get("receiveAccountNum"));
		receiveParamMap.put("money", paramMap.get("money"));
		accountDao.updateReceiveAccount(receiveParamMap);
		
	}

}

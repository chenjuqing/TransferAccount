package cn.sxt.advice;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sxt.dao.AccountTransferLogDao;

/**
 * 环绕通知：添加日志 
 * @author Administrator
 */
public class AroundAdivce implements MethodInterceptor{
	
	@Autowired
	private AccountTransferLogDao accountTransferLogDao;
	
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		insertRepayLog(arg0);
		arg0.proceed();
		insertReceiveLog(arg0);
		return null;
	}
	
	
	public void insertRepayLog(MethodInvocation arg0){
		Map<String, Object> repayParamMap = new HashMap<String, Object>();
		Object[] arr = arg0.getArguments();
		Map<String, Object> paramMap = (Map<String, Object>) arr[0];
		repayParamMap.put("ACCOUNT_NUM", paramMap.get("repaymentAccountNum"));
		repayParamMap.put("ACCOUNT_TRANSFER_MONY", paramMap.get("money"));
		repayParamMap.put("ACCOUNT_TRANSFER_TYPE", 1);
		accountTransferLogDao.insertAccountTransferLog(repayParamMap);
	}
	

	public void insertReceiveLog(MethodInvocation arg0){
		Map<String, Object> receiveParamMap = new HashMap<String, Object>();
		Object[] arr = arg0.getArguments();
		Map<String, Object> paramMap = (Map<String, Object>) arr[0];
		receiveParamMap.put("ACCOUNT_NUM", paramMap.get("receiveAccountNum"));
		receiveParamMap.put("ACCOUNT_TRANSFER_MONY", paramMap.get("money"));
		receiveParamMap.put("ACCOUNT_TRANSFER_TYPE", 2);
		accountTransferLogDao.insertAccountTransferLog(receiveParamMap);
	}
}

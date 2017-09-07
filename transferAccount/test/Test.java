package cn.sxt.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sxt.service.AccountService;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("cn/sxt/config/spring_context.xml");
		AccountService accountService = (AccountService) applicationContext.getBean("accountServiceImpl");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		/*paramMap.put("USER_ID", 2);
		paramMap.put("ACCOUNT_NUM", 332377709);
		paramMap.put("ACCOUNT_BLANCE", 1000);
		accountService.addAccount(paramMap);*/
		
		
		/*paramMap.put("ACCOUNT_BLANCE", 1000);
		List<Map<String,Object>> list = accountService.queryAccountList(paramMap);
		for (Map<String, Object> map : list) {
			System.out.println(map.get("ACCOUNT_NUM")+"--"+map.get("ACCOUNT_BLANCE"));
		}*/
		
		paramMap.put("repaymentAccountNum", "1667984648");
		paramMap.put("receiveAccountNum", "332377709");
		paramMap.put("money", "100");
		accountService.updateTransferMoney(paramMap);
	}
}

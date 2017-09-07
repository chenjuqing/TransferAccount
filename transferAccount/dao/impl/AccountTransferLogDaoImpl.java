package cn.sxt.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.AccountTransferLogDao;

@Repository
public class AccountTransferLogDaoImpl implements AccountTransferLogDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertAccountTransferLog(Map<String, Object> paramMap) {
		String sqlStr = "INSERT INTO account_transfer_log (ACCOUNT_NUM,ACCOUNT_TRANSFER_MONY,ACCOUNT_TRANSFER_TYPE)  "+
				" VALUES(?,?,?)";
		
		Object[] args = {
				paramMap.get("ACCOUNT_NUM"),
				paramMap.get("ACCOUNT_TRANSFER_MONY"),
				paramMap.get("ACCOUNT_TRANSFER_TYPE")
				};
		jdbcTemplate.update(sqlStr, args);
	}

}

package cn.sxt.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.sxt.dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addAccount(Map<String, Object> paramMap) {
		String sql = "INSERT INTO ACCOUNT(USER_ID, ACCOUNT_NUM, ACCOUNT_BLANCE)"+
				"VALUES(?,?,?)";
		Object[] args = {
				paramMap.get("USER_ID"), 
				paramMap.get("ACCOUNT_NUM"), 
				paramMap.get("ACCOUNT_BLANCE")};
		jdbcTemplate.update(sql, args);
	}

	@Override
	public List<Map<String, Object>> queryAccountList(
			Map<String, Object> paramMap) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("SELECT ACCOUNT_NUM, ACCOUNT_BLANCE FROM ACCOUNT WHERE 1=1");
		
		StringBuffer paramBuffer = new StringBuffer();
		List<Object> paramList = new ArrayList<Object>();
		
		if (paramMap.get("ACCOUNT_BLANCE") != null) {
			paramBuffer.append(" AND ACCOUNT_BLANCE >=?");//注意语句间需存在空格
			paramList.add(paramMap.get("ACCOUNT_BLANCE"));
		}
		if (paramMap.get("USER_ID") != null) {
			paramBuffer.append(" AND USER_ID =?");//注意语句间需存在空格
			paramList.add(paramMap.get("USER_ID"));
		}
		
		Object[] args = paramList.toArray();
		sqlBuffer.append(paramBuffer);
		String sql = sqlBuffer.toString();
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, args);
		return list;
	}

	@Override
	public void updateRepaymentAccount(Map<String, Object> paramMap) {
		String sql ="UPDATE ACCOUNT SET ACCOUNT_BLANCE = ACCOUNT_BLANCE-? WHERE ACCOUNT_NUM =?";
		Object[] args = {paramMap.get("money"), paramMap.get("ACCOUNT_NUM")};
		jdbcTemplate.update(sql, args);
	}

	@Override
	public void updateReceiveAccount(Map<String, Object> paramMap) {
		String sql ="UPDATE ACCOUNT SET ACCOUNT_BLANCE = ACCOUNT_BLANCE+? WHERE ACCOUNT_NUM =?";
		Object[] args = {paramMap.get("money"), paramMap.get("ACCOUNT_NUM")};
		jdbcTemplate.update(sql, args);
	}
	

}
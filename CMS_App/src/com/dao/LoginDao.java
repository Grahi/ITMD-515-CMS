package com.dao;

import com.bean.Login;

public interface LoginDao {
	
	public Login authenticateUser(Login loginBean);
	
}

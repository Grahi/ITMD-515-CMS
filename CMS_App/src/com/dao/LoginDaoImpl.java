package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Login;
import com.util.DBConnection;

public class LoginDaoImpl implements LoginDao {

	public LoginDaoImpl() {

	}

	@Override
	public Login authenticateUser(Login loginBean) {
		Login user = new Login();
		String userName = loginBean.getUserName();
		String password = loginBean.getPassword();

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String roleDB = "";
		int roleId;
		String query = "";

		try {

			con = DBConnection.createConnection();
			query = "SELECT username,password,role,roleId FROM users WHERE username = ? AND password = ?";

			statement = con.prepareStatement(query);
			statement.setString(1, userName);
			statement.setString(2, password);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				roleDB = resultSet.getString("role");
				roleId = resultSet.getInt("roleId");
				user.setUserName(userName);
				user.setRole(roleDB);
				user.setRoleId(roleId);

				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

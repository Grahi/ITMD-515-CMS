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

			if (resultSet.next()) {
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

	@Override
	public int addUser(Login newUser) {
		
		Connection con = null;
		PreparedStatement statement = null;		
		int result=0;
		String query = "";

		try {
			con = DBConnection.createConnection();
			query = "INSERT INTO `cms`.`users` (`username`,`password`,`role`,`roleId`) VALUES "
					+ "(?,?,?,?)";

			statement = con.prepareStatement(query);
			statement.setString(1, newUser.getUserName());
			statement.setString(2, newUser.getPassword());
			statement.setString(3, newUser.getRole());
			statement.setInt(4, newUser.getRoleId());
			result = statement.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

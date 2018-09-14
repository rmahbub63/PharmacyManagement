package com.diu.pharmacyController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.diu.PharmacyModel.Login;
import info.diu.connection.MysqlConnect;

public class LoginController {

	MysqlConnect mysqlConnect = new MysqlConnect();
	Statement stmt = null;
	PreparedStatement ps;
	ResultSet rs;

	public ArrayList<Login> getAllInfo() {

		ArrayList<Login> logins = new ArrayList<Login>();

		try {
			String sql = "SELECT * FROM user where username=? and password=?";
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				// login.setId(rs.getString("id"));
				// login.setUsername(rs.getString("username"));
				// login.setPassword(rs.getString("password"));
				// login.setStatus(rs.getString("status"));
				logins.add(login);
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return logins;
	}

	public Login getLoginInfoByUserName(String userName) {
		Login login = new Login();
		try {
			String sql = "SELECT * FROM user where username = '" + userName + "'";
			System.out.println(sql);
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				login.setUserName(rs.getString("username"));
				login.setPassWord(rs.getString("password"));
				login.setStatus(rs.getString("status"));
				login.setRole(rs.getString("role_no"));
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return login;
	}
}

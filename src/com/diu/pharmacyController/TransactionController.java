package com.diu.pharmacyController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.bind.ValidationEvent;

import com.diu.PharmacyModel.Employee;
import com.diu.PharmacyModel.Login;
import com.diu.PharmacyModel.Transiction;

import info.diu.connection.MysqlConnect;

public class TransactionController {

	MysqlConnect mysqlConnect = new MysqlConnect();
	Statement stmt = null;
	PreparedStatement ps;
	ResultSet rs;

	public void saveTransiction(Transiction transiction) {
		try {
			String sql = "INSERT INTO transaction values(?,?,?,?,?,?,?,?)";
			System.out.println(sql);
			ps = mysqlConnect.connect().prepareStatement(sql);
			ps.setString(1, transiction.getTransictionNo());
			ps.setString(2, transiction.getTransictionDate());
			ps.setString(3, transiction.getCustomerName());
			ps.setString(4, transiction.getMobileNo());
			ps.setString(5, transiction.getServiceProviderName());
			ps.setString(6, String.valueOf(transiction.getPayableAmount()));
			ps.setString(7, String.valueOf(transiction.getRecievedAmount()));
			ps.setString(8, String.valueOf(transiction.getReturnAmount()));
			System.out.println("OK");
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();
		} catch (Exception e) {
			e.printStackTrace();
			mysqlConnect.disconnect();

		} finally {
			// Step 5: Always free resources
			mysqlConnect.disconnect();
		}
	}

	public ArrayList<Transiction> getAllTransiction() {

		ArrayList<Transiction> transictionList = new ArrayList<>();
		try {
			String sql = "select * from transaction order by transactionNo";
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Transiction transiction = new Transiction();
				transiction.setTransictionNo(rs.getString("transactionNo"));
				transiction.setTransictionDate(rs.getString("date"));
				transiction.setCustomerName(rs.getString("customerName"));
				transiction.setMobileNo(rs.getString("mobileNo"));
				transiction.setServiceProviderName(rs.getString("serviceProvider"));
				transiction.setPayableAmount(Double.parseDouble(rs.getString("payableAmount")));
				transiction.setRecievedAmount(Double.parseDouble(rs.getString("receiveAmount")));
				transiction.setReturnAmount(Double.parseDouble(rs.getString("returnAmount")));
				transictionList.add(transiction);
			}
			ps.execute();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				mysqlConnect.disconnect();
			} catch (Exception e) {
			}
		}
		return transictionList;
	}

	public void deleteTransiction(Transiction transiction) {
		try {
			String sql = "DELETE from transaction where transactionNo = '" + transiction.getTransictionNo() + "'";
			ps = mysqlConnect.connect().prepareStatement(sql);
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
	}

	public String getNewTransactionNo() {
		String value = null;
		try {
			String sql = "SELECT transactionNo FROM  commondata";
			System.out.println(sql);
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				value = rs.getString("transactionNo");
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return value;
	}

	public void updateNewTransactionNo(String value) {
		try {
			stmt = mysqlConnect.connect().createStatement();
			String sql = "update commondata set transactionNo= '" + value + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			mysqlConnect.connect().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
	}
}

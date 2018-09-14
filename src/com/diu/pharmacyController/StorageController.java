package com.diu.pharmacyController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.diu.PharmacyModel.Employee;
import com.diu.PharmacyModel.Medicine;
import info.diu.connection.MysqlConnect;

public class StorageController {

	MysqlConnect mysqlConnect = new MysqlConnect();
	Statement stmt = null;
	PreparedStatement ps;
	ResultSet rs;

//	public ArrayList<Employee> getAllEmployee() {
//
//		ArrayList<Employee> employeeList = new ArrayList<>();
//		try {
//			String sql = "select * from pharmacyemployee order by Name";
//			ps = mysqlConnect.connect().prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Employee employee = new Employee();
//				employee.setEmployeId(rs.getString("ID"));
//				employee.setEmployeeName(rs.getString("Name"));
//				employee.setFatherName(rs.getString("DateOfBirth"));
//				employee.setMotherName(rs.getString("FatherName"));
//				employee.setDepartment(rs.getString("MotherName"));
//				employee.setPresentAddress(rs.getString("Department"));
//				employee.setPermanentAddress(rs.getString("PermanentAddress"));
//				employee.setPresentAddress(rs.getString("PresentAddress"));
//				employee.setContact(rs.getString("Contact"));
//				employee.setEmail(rs.getString("Email"));
//				employee.setJoinDate(rs.getString("JoiningDate"));
//				employee.setReference(rs.getString("Reference"));
//				employeeList.add(employee);
//			}
//			ps.execute();
//			ps.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//				mysqlConnect.disconnect();
//			} catch (Exception e) {
//			}
//		}
//		return employeeList;
//	}
}

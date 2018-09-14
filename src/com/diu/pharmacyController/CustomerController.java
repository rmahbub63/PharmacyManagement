package com.diu.pharmacyController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import com.diu.PharmacyModel.Customer;

import info.diu.connection.MysqlConnect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author softbinDeveloper
 */
public class CustomerController {

	MysqlConnect mysqlConnect = new MysqlConnect();
	Statement stmt = null;
	PreparedStatement ps;
	ResultSet rs;

	public CustomerController() {
	}

	// public boolean saveCustomer(Customer customer) {
	// boolean saveCustomer = false;
	//
	// UUID uuid = UUID.randomUUID();
	//
	// try {
	// String sql = "insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	// ps = mysqlConnect.connect().prepareStatement(sql);
	// ps.setString(1, uuid.toString());
	// ps.setString(2, customer.getName());
	// ps.setString(3, customer.getDesignation());
	// ps.setString(4, customer.getDepartment());
	// ps.setString(5, customer.getInstitution());
	// ps.setString(6, customer.getEmail());
	// ps.setString(7, customer.getAddress());
	// ps.setString(8, customer.getCity());
	// ps.setString(9, customer.getTnt());
	// ps.setString(10, customer.getMobile());
	// ps.setString(11, customer.getEntryDate());
	// ps.setString(12, customer.getWebsite());
	// ps.setString(13, customer.getCompanyLogo());
	//
	// Alert alert = new Alert(AlertType.INFORMATION);
	// alert.setTitle("Message");
	// alert.setContentText("Saved");
	// alert.showAndWait();
	//
	// ps.execute();
	//
	// saveCustomer = true;
	//
	// ps.close();
	// mysqlConnect.connect().close();
	//
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	//
	// } finally {
	// // Step 5: Always free resources
	// mysqlConnect.disconnect();
	// }
	// return saveCustomer;
	// }

	public ArrayList<Customer> getAllCustomer() {

		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {
			String sql = "SELECT * FROM customer ORDER BY customer_name ASC";
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// Customer customer = new Customer();
				// customer.setCustomerId(rs.getString("customer_id"));
				// customer.setCustomername(rs.getString("customer_name"));
				// customer.setDepartment(rs.getString("department"));
				// customer.setDesignation(rs.getString("department"));
				// customer.setEmail(rs.getString("email"));
				// customer.setAddress(rs.getString("address"));
				// customer.setTnt(rs.getString("tnt"));
				// customer.setMobile(rs.getString("mobile"));
				// customer.setEntryDate(rs.getString("entryDate"));
				// customer.setWebsite(rs.getString("website"));
				// customer.setCompanyLogo(rs.getString("photo"));
				// customers.add(customer);
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			mysqlConnect.disconnect();
		}
		return customers;
	}

	public ArrayList<Customer> getAllCustomerBySearchKey(String name) {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {
			String sql = "SELECT * FROM pharmacycustomer  WHERE Contact LIKE '" + name + "%'";
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("ID"));
				customer.setCustomername(rs.getString("Name"));
				customer.setCustomerGender(rs.getString("Gender"));
				customer.setCustomerNID(rs.getString("NID"));
				customer.setCustomerContact(rs.getString("Contact"));
				customer.setCustomerDateOfBirth(rs.getString("DateOfBirth"));
				customer.setCustomeraddress(rs.getString("Address"));
				customer.setCustomerEmail(rs.getString("Email"));
				customer.setCustomerRegistrationDate(rs.getString("RegistrationDate"));
				customers.add(customer);
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			mysqlConnect.disconnect();
		}
		return customers;
	}

	public Customer getCustomerByCustomerMobileNo(String MobileNo) {

		Customer customer = new Customer();
		try {
			String sql = "SELECT * FROM pharmacycustomer where Contact = '" + MobileNo + "'";
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCustomerId(rs.getString("ID"));
				customer.setCustomername(rs.getString("Name"));
				customer.setCustomerGender(rs.getString("Gender"));
				customer.setCustomerNID(rs.getString("NID"));
				customer.setCustomerContact(rs.getString("Contact"));
				customer.setCustomerDateOfBirth(rs.getString("DateOfBirth"));
				customer.setCustomeraddress(rs.getString("Address"));
				customer.setCustomerEmail(rs.getString("Email"));
				customer.setCustomerRegistrationDate(rs.getString("RegistrationDate"));
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			mysqlConnect.disconnect();
		}
		return customer;
	}

	/*
	 * public Customer getCustomerByCustomerID(String id) {
	 * 
	 * Customer customer = new Customer();
	 * 
	 * try { String sql = "SELECT * FROM customer where customer_id = '" + id +
	 * "'"; ps = mysqlConnect.connect().prepareStatement(sql); rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * customer.setCompanyId(rs.getString("customer_id"));
	 * customer.setName(rs.getString("customer_name"));
	 * customer.setEmail(rs.getString("email"));
	 * customer.setAddress(rs.getString("address"));
	 * customer.setTnt(rs.getString("tnt"));
	 * customer.setEntryDate(rs.getString("entryDate"));
	 * customer.setWebsite(rs.getString("website")); } ps.execute(); ps.close();
	 * mysqlConnect.connect().close();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } finally { // Step 5: Always free resources mysqlConnect.disconnect(); }
	 * return customer; }
	 * 
	 * public boolean editCustomer(Customer customer) { boolean editCustomer =
	 * false;
	 * 
	 * try { stmt = mysqlConnect.connect().createStatement(); String sql =
	 * "update customer set customer_name = '" + customer.getName() + "'," +
	 * "email= '" + customer.getEmail() + "', entryDate='" +
	 * customer.getEntryDate() + "', customer_logo='" +
	 * customer.getCompanyLogo() + "'," + "address = '" + customer.getAddress()
	 * + "', tnt='" + customer.getTnt() + "', website='" + customer.getWebsite()
	 * + "'" + " where customer_id = '" + customer.getCompanyId() + "'";
	 * System.out.println(sql);
	 * 
	 * int isSaved = stmt.executeUpdate(sql);
	 * 
	 * if (isSaved > 0) { editCustomer = true; } mysqlConnect.connect().close();
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * } finally { mysqlConnect.disconnect(); } return editCustomer; }
	 * 
	 * public boolean deleteCustomer(Customer customer) { boolean deleteCustomer
	 * = false;
	 * 
	 * try { String sql = "DELETE from customer where customer_id = '" +
	 * customer.getCompanyId() + "'"; ps =
	 * mysqlConnect.connect().prepareStatement(sql); ps.execute(); ps.close();
	 * mysqlConnect.connect().close();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } finally { mysqlConnect.disconnect(); } return deleteCustomer; }
	 * 
	 * public Customer getCustomerPhotoByName(String name) {
	 * 
	 * Customer customer = new Customer();
	 * 
	 * try { String sql = "SELECT * FROM customer where customer_name = '" +
	 * name + "'"; ps = mysqlConnect.connect().prepareStatement(sql); rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * customer.setCompanyId(rs.getString("customer_id"));
	 * customer.setName(rs.getString("customer_name"));
	 * customer.setCompanyLogo(rs.getString("photo")); } ps.execute();
	 * ps.close(); mysqlConnect.connect().close(); } catch (Exception e) {
	 * e.printStackTrace(); mysqlConnect.disconnect();
	 * 
	 * } finally { mysqlConnect.disconnect(); } return customer; }
	 */
}

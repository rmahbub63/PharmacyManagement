package com.diu.pharmacyController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.diu.PharmacyModel.Medicine;
import info.diu.connection.MysqlConnect;

public class MedicineController {

	MysqlConnect mysqlConnect = new MysqlConnect();
	Statement stmt = null;
	PreparedStatement ps;
	ResultSet rs;

	public ArrayList<Medicine> getAllMedicine() {

		ArrayList<Medicine> medicineList = new ArrayList<>();
		try {
			String sql = "select * from medicine order by name";
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Medicine medicine = new Medicine();
				medicine.setMedicineCode(rs.getString("id"));
				medicine.setMedicineName(rs.getString("name"));
				medicine.setMedicineGenericName(rs.getString("genericName"));
				medicine.setMedicineCompanyName(rs.getString("companyName"));
				medicine.setMedicineCategory(rs.getString("catagory"));
				medicine.setMedicinePackTotalSize(Double.parseDouble(rs.getString("packTotal")));
				medicine.setMedicinePackTotalPrice(Double.parseDouble(rs.getString("priceTotal")));
				medicine.setMedicineIndividualPrice(Double.parseDouble(rs.getString("individualPrice")));
				medicine.setMedicineInfo(rs.getString("info"));
				medicineList.add(medicine);
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
		return medicineList;
	}

	public Medicine getMedicineByProductName(String productName) {
		Medicine medicine = new Medicine();
		try {
			String sql = "SELECT * FROM medicine WHERE name = '" + productName + "'";
			System.out.println(sql);
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				medicine.setMedicineCode(rs.getString("id"));
				medicine.setMedicineName(rs.getString("name"));
				medicine.setMedicineGenericName(rs.getString("genericName"));
				medicine.setMedicineCompanyName(rs.getString("companyName"));
				medicine.setMedicineCategory(rs.getString("catagory"));
				medicine.setMedicinePackTotalSize(Double.parseDouble(rs.getString("packTotal")));
				medicine.setMedicinePackTotalPrice(Double.parseDouble(rs.getString("priceTotal")));
				medicine.setMedicineIndividualPrice(Double.parseDouble(rs.getString("individualPrice")));
				medicine.setMedicineInfo(rs.getString("info"));
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mysqlConnect.disconnect();
		}
		return medicine;
	}

	public ArrayList<Medicine> getAllMedicineByProductNameSearch(String productName) {

		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();

		try {
			String sql = "SELECT * FROM medicine WHERE name LIKE '" + productName + "%'";
			System.out.println(sql);
			ps = mysqlConnect.connect().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Medicine medicine = new Medicine();
				medicine.setMedicineName(rs.getString("name"));
				medicineList.add(medicine);
			}
			ps.execute();
			ps.close();
			mysqlConnect.connect().close();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			// Step 5: Always free resources
			mysqlConnect.disconnect();
		}
		return medicineList;
	}
}

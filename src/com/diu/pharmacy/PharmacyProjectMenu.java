package com.diu.pharmacy;

import com.diu.pharmacy.ui.NewTransictionForm;
import com.diu.pharmacy.ui.PharmacyExpendature;
import com.diu.pharmacy.ui.PharmacyHome;
import com.diu.pharmacy.ui.PharmacyLogin;
import com.diu.pharmacy.ui.TransactionList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class PharmacyProjectMenu {

	public static MenuBar getMneuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setCursor(Cursor.HAND);

		// --- Menu
		Menu menuFile = new Menu("File");
		Menu menuTransaction = new Menu("Transaction");
		Menu menuMedicine = new Menu("Medicine");
		Menu menuCustomer = new Menu("Customer");
		Menu menuEmployee = new Menu("Employee");
		Menu menuStorage = new Menu("Storage");
		Menu menuReport = new Menu("Report");
		Menu menuSettings = new Menu("Settings");
		Menu menuAbout = new Menu("About");
		Menu menuHelp = new Menu("Help");
		// --- Menu

		// --- Menu Item
		MenuItem itemLogout = new MenuItem("Logout");
		MenuItem itemExit = new MenuItem("Exit");
		MenuItem itemTransaction = new MenuItem("New Transaction");
		MenuItem itemTransactionList = new MenuItem("Transaction List");
		MenuItem itemAddMedicine = new MenuItem("Add Medicine");
		MenuItem itemMedicineList = new MenuItem("Medicine List");
		MenuItem itemAddCustomer = new MenuItem("Add Customer");
		MenuItem itemCutomerList = new MenuItem("Customer List");
		MenuItem itemAddEmployee = new MenuItem("Add Employee");
		MenuItem itemEmployeeList = new MenuItem("Employee List");
		MenuItem itemOrderEntry = new MenuItem("Order Entry");
		MenuItem itemNeededOrder = new MenuItem("Needed Order");
		MenuItem itemCheckExpireDate = new MenuItem("CheckExpire Date");
		MenuItem itemAddCompany = new MenuItem("Add Company");
		MenuItem itemRegistration = new MenuItem("Registration");
		MenuItem itemRolePermission = new MenuItem("Role Permission");
		MenuItem itemSalesReport = new MenuItem("Sales Report");
		MenuItem itemInformation = new MenuItem("Information");

		// --- Menu Item

		menuFile.getItems().addAll(itemLogout, itemExit);
		menuTransaction.getItems().addAll(itemTransaction, itemTransactionList);
		menuMedicine.getItems().addAll(itemAddMedicine, itemMedicineList);
		menuCustomer.getItems().addAll(itemAddCustomer, itemCutomerList);
		menuEmployee.getItems().addAll(itemAddEmployee, itemEmployeeList);
		menuStorage.getItems().addAll(itemOrderEntry, itemNeededOrder, itemCheckExpireDate);
		menuSettings.getItems().addAll(itemAddCompany, itemRegistration, itemRolePermission);
		menuReport.getItems().addAll(itemSalesReport, itemInformation);

		// --- Menu View
		Label menuLabelHome = new Label("Home");
		menuLabelHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				PharmacyHome pharmacyHome = new PharmacyHome(PharmacyProjectScene.primarySatge);
			}
		});
		Menu menuHomeButton = new Menu();
		menuHomeButton.setGraphic(menuLabelHome);

		itemTransaction.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				NewTransictionForm newTransictionForm = new NewTransictionForm(PharmacyProjectScene.primarySatge);
			}
		});

		itemTransactionList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				TransactionList transactionList = new TransactionList(PharmacyProjectScene.primarySatge);
			}
		});

		/*
		 * itemAttendence.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * @Override public void handle(ActionEvent event) { Attendence
		 * attendence = new Attendence(EmsProjectScene.primarySatge); } });
		 */
		menuBar.getMenus().addAll(menuFile, menuHomeButton, menuTransaction, menuMedicine, menuCustomer, menuEmployee,
				menuStorage, menuReport, menuSettings, menuAbout, menuHelp);

		return menuBar;
	}
}
package com.diu.pharmacy;

import com.diu.pharmacy.ui.PharmacyHome;
import com.diu.pharmacy.ui.PharmacyLogin;

import javafx.application.Application;
import javafx.stage.Stage;

public class PharmacyLauncher extends Application {

	private Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {

		this.primaryStage = stage;
		PharmacyProjectScene.primarySatge = primaryStage;

		primaryStage.setTitle("Pharamacy Management");
		primaryStage.setResizable(true);

		@SuppressWarnings("unused")
//		PharmacyHome pharmacyHome = new PharmacyHome(primaryStage);
		PharmacyLogin pharmacyLogin = new PharmacyLogin(primaryStage);
	}
}

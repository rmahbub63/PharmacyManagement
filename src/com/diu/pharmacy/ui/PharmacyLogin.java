package com.diu.pharmacy.ui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.diu.PharmacyModel.Login;
import com.diu.pharmacy.PharmacyLoginProjectScene;
import com.diu.pharmacy.PharmacyProjectScene;
import com.diu.pharmacyController.LoginController;

import info.diu.connection.MysqlConnect;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PharmacyLogin {

	Stage primaryStage;

	int top = 90;
	int left = 0;
	int bottom = 0;
	int right = 30;
	int rightTxtField = 100;

	int textFieldWidth = 250;
	// ALL Label
	private Label lblLogInFrame = new Label("Log In");
	private Label lblUserName = new Label("Username");
	private Label lblPassword = new Label("Password");

	// ALL Text Field
	private TextField txtfldUserName = new TextField();
	private PasswordField txtfldPassword = new PasswordField();

	private Button btnClear = new Button("Clear");
	private Button btnLogIn = new Button("Login");

	public PharmacyLogin(Stage stage) {
		MysqlConnect mysqlConnect = new MysqlConnect();
		Statement stmt = null;
		PreparedStatement ps;
		ResultSet rs;
		mysqlConnect.connect();
		this.primaryStage = stage;
		primaryStage.setScene(expendatureScene());
		primaryStage.show();
	}

	public Scene expendatureScene() {

		StackPane mainPane = new StackPane();
		mainPane.setAlignment(Pos.TOP_LEFT);

		StackPane pane = new StackPane();
		pane.setAlignment(Pos.TOP_LEFT);

		txtfldUserName.setMaxWidth(textFieldWidth);
		txtfldPassword.setMaxWidth(textFieldWidth);
		txtfldUserName.setMaxHeight(30);
		txtfldPassword.setMaxHeight(30);
		lblLogInFrame.setMinHeight(40);
		lblLogInFrame.setMinWidth(430);
		lblLogInFrame.setAlignment(Pos.CENTER);

		btnClear.setMaxWidth(60);
		btnLogIn.setMaxWidth(60);
		lblLogInFrame.setTextFill(Color.BLUE);

		StackPane.setMargin(lblLogInFrame, new Insets(0, 0, 250, 0));
		StackPane.setMargin(lblUserName, new Insets(top + 5, left, bottom, right));
		StackPane.setMargin(txtfldUserName, new Insets(top, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblPassword, new Insets(top + 55, left, bottom, right));
		StackPane.setMargin(txtfldPassword, new Insets(top + 50, left, bottom, right + rightTxtField));

		// StackPane.setMargin(separator, new Insets(top + 205, left, bottom,
		// 0));

		StackPane.setMargin(btnClear, new Insets(190, 15, 0, 245));
		StackPane.setMargin(btnLogIn, new Insets(190, 15, 0, 320));

		pane.getChildren().addAll(lblLogInFrame, lblUserName, lblPassword, txtfldUserName, txtfldPassword, btnClear,
				btnLogIn);

		StackPane.setMargin(pane, new Insets(130, 270, 200, 200));

		mainPane.getChildren().addAll(pane);

		// cartPane.getStyleClass().add("pane");
		pane.getStyleClass().add("pane");
		lblUserName.getStyleClass().add("custom_Label");
		lblPassword.getStyleClass().add("custom_Label");
		lblLogInFrame.getStyleClass().add("LoginLabel");

		btnLogIn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (loginCheck()) {
					PharmacyHome pharmacyHome = new PharmacyHome(PharmacyProjectScene.primarySatge);
				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Login Error");
					alert.setHeaderText("");
					alert.setContentText("Username Or Password incorrect");
					alert.showAndWait();
					// JOptionPane.showMessageDialog(null, "Username Or Password
					// incorrect");
					refreshForm();
				}
			}
		});

		btnClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				refreshForm();
			}
		});
		return PharmacyLoginProjectScene.returnScene(mainPane);
	}

	public boolean loginCheck() {
		// For working approach set value as True
		boolean value = true;
		String userName = txtfldUserName.getText();
		String passWord = txtfldPassword.getText();

		Login login = new Login();
		LoginController loginController = new LoginController();
		login = loginController.getLoginInfoByUserName(userName);
		System.out.println(login.getPassWord());
		if (login.getPassWord() != null && !login.getPassWord().isEmpty()) {
			if (passWord.matches(login.getPassWord())) {
				System.out.println(login.getPassWord());
				value = true;
			}
		}
		return value;
	}

	public void refreshForm() {
		txtfldUserName.setText(null);
		txtfldPassword.setText(null);
	}
}

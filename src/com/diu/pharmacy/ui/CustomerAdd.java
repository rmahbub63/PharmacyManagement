package com.diu.pharmacy.ui;

import com.diu.pharmacy.PharmacyProjectScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CustomerAdd {

	Stage primarySatge;

	int top = 30;
	int left = 0;
	int bottom = 0;
	int right = 40;
	int rightTxtField = 120;

	int textFieldWidth = 335;

	private Label lblEmployeeID = new Label("Employee ID");
	private Label lblEmployeeName = new Label("Employee Name");
	private Label lblEmployeeNationalID = new Label("National ID");
	private Label lblDesignation = new Label("Designation");
	private Label lblDepartment = new Label("Department");
	private Label lblJoiningDate = new Label("Joining Date");
	private Label lblPresentAddress = new Label("Present Address");
	private Label lblPermanentAddress = new Label("Permanent Address");
	private Label lblMobileNo = new Label("Mobile No");
	private Label lblEmergencyContact = new Label("Emergency Contact");
	private Label lblEmail = new Label("Email");
	private Label lblReference = new Label("Reference");
	
	private Label lblEmployeeImage = new Label();
	private Label lblStatus = new Label("Status");
	private Label lblAreaofWork = new Label("Area of work");
	private Label lblLocation = new Label("Location");
	private Label lblEmployeeSignature = new Label();
	
	private RadioButton r1 = new RadioButton("Active");
	private RadioButton r2 = new RadioButton("Inactive");
	private ToggleGroup group = new ToggleGroup();
	
	private TextField txtFldEmployeeID = new TextField();
	private TextField txtFldName = new TextField();
	private TextField txtFldNationalID = new TextField();
	private TextField txtFldDesignation = new TextField();
	private TextField txtFldDepartment = new TextField();
	private DatePicker txtJoiningdate = new DatePicker();
	private TextField txtFldPresentAddress = new TextField();
	private TextField txtFldPermanentAddress = new TextField();
	private TextField txtFldMobile = new TextField();
	private TextField txtFldEmergencyContact = new TextField();
	private TextField txtFldEmail = new TextField();
	private TextField txtFldReference = new TextField();
	private TextField txtFldAreaOfWork = new TextField();
	private TextField txtFldLocation = new TextField();
	
	private Separator separator = new Separator();
	
	private Button btnAddEmployeeImage = new Button("Add Image");
	private Button btnAddEmployeeSignature = new Button("Add Signature");
	private Button btnSave = new Button("Save");
	private Button btnCancel = new Button("Cancel");

	String s;
	String imageName;
	String status;

	String uuid = null;

	public CustomerAdd(Stage pStage) {
		this.primarySatge = pStage;
		this.primarySatge.setScene(employeeAddScene());
		this.primarySatge.show();
	}

	public Scene employeeAddScene() {

		StackPane mainPane = new StackPane();
		mainPane.setAlignment(Pos.TOP_LEFT);

		StackPane stackPane = new StackPane();
		stackPane.setAlignment(Pos.TOP_LEFT);

		txtFldEmployeeID.setMaxWidth(textFieldWidth);
		txtFldName.setMaxWidth(textFieldWidth);
		txtFldNationalID.setMaxWidth(textFieldWidth);
		txtFldDesignation.setMaxWidth(textFieldWidth);
		txtFldDepartment.setMaxWidth(textFieldWidth);
		txtJoiningdate.setMaxWidth(textFieldWidth);
		txtFldPresentAddress.setMaxWidth(textFieldWidth);
		txtFldPermanentAddress.setMaxWidth(textFieldWidth);
		txtFldMobile.setMaxWidth(textFieldWidth);
		txtFldEmergencyContact.setMaxWidth(textFieldWidth);
		txtFldEmail.setMaxWidth(textFieldWidth);
		txtFldReference.setMaxWidth(textFieldWidth);
		txtFldAreaOfWork.setMaxWidth(textFieldWidth);
		txtFldLocation.setMaxWidth(textFieldWidth);
		
		lblEmployeeImage.setMaxHeight(130);
		lblEmployeeImage.setMaxWidth(120);
		lblEmployeeSignature.setMaxHeight(85);
		lblEmployeeSignature.setMaxWidth(430);
		
		btnAddEmployeeImage.setMaxWidth(80);
		btnSave.setMaxWidth(80);
		btnCancel.setMaxWidth(80);
		
		r1.setToggleGroup(group);
		r2.setToggleGroup(group);
		separator.setMaxWidth(700);
		
		separator.setOrientation(Orientation.HORIZONTAL);

		StackPane.setMargin(lblEmployeeID, new Insets(top + 5, left, bottom, right)); // top,// right,
		StackPane.setMargin(txtFldEmployeeID, new Insets(top, left, bottom, right + rightTxtField)); // top,right,
		StackPane.setMargin(lblEmployeeName, new Insets(top + 45, left, bottom, right)); // top,right,
		StackPane.setMargin(txtFldName, new Insets(top + 40, left, bottom, right + rightTxtField)); // top,right,
		StackPane.setMargin(lblEmployeeNationalID, new Insets(top + 85, left, bottom, right)); // top,right,
		StackPane.setMargin(txtFldNationalID, new Insets(top + 80, left, bottom, right + rightTxtField)); // top,right,
		StackPane.setMargin(lblDesignation, new Insets(top + 125, left, bottom, right)); // top,right,
		StackPane.setMargin(txtFldDesignation, new Insets(top + 120, left, bottom, right + rightTxtField)); // top,right,
		StackPane.setMargin(lblDepartment, new Insets(top + 165, left, bottom, right)); // top,// right,
		StackPane.setMargin(txtFldDepartment, new Insets(top + 160, left, bottom, right + rightTxtField)); // top,right,
		StackPane.setMargin(lblJoiningDate, new Insets(top + 205, left, bottom, right)); // top,// right,
		StackPane.setMargin(txtJoiningdate, new Insets(top + 200, left, bottom, right + rightTxtField)); // top,
		StackPane.setMargin(lblPresentAddress, new Insets(top + 245, left, bottom, right)); // top,// right,
		StackPane.setMargin(txtFldPresentAddress, new Insets(top + 240, left, bottom, right + rightTxtField)); // top,// right,
		StackPane.setMargin(lblPermanentAddress, new Insets(top + 285, left, bottom, right)); // top,right,
		StackPane.setMargin(txtFldPermanentAddress, new Insets(top + 280, left, bottom, right + rightTxtField)); // top,// right,
		StackPane.setMargin(lblMobileNo, new Insets(top + 325, left, bottom, right)); // top,// right,
		StackPane.setMargin(txtFldMobile, new Insets(top + 320, left, bottom, right + rightTxtField)); // top, // right,
		StackPane.setMargin(lblEmergencyContact, new Insets(top + 365, left, bottom, right)); // top,// right,
		StackPane.setMargin(txtFldEmergencyContact, new Insets(top + 360, left, bottom, right + rightTxtField)); // top, // right,
		StackPane.setMargin(lblEmail, new Insets(top + 405, left, bottom, right)); // top,
		StackPane.setMargin(txtFldEmail, new Insets(top + 400, left, bottom, right + rightTxtField)); // top,
		StackPane.setMargin(lblReference, new Insets(top + 445, left, bottom, right)); // top,
		StackPane.setMargin(txtFldReference, new Insets(top + 440, left, bottom, right + rightTxtField)); // top,
		
		StackPane.setMargin(lblEmployeeImage, new Insets(top, left, bottom, 700)); // top,
		StackPane.setMargin(btnAddEmployeeImage, new Insets(170, left, bottom, 720)); // top,
		
		StackPane.setMargin(lblStatus, new Insets(top + 220, left, bottom, 560)); // top,
		StackPane.setMargin(r1, new Insets(top + 220, left, bottom, 650)); // top,
		StackPane.setMargin(r2, new Insets(top + 220, left, bottom, 750)); // top,// right,
		
		StackPane.setMargin(lblAreaofWork, new Insets(top + 265, left, bottom, 560)); // top,// right,
		StackPane.setMargin(txtFldAreaOfWork, new Insets(top + 260, left, bottom, 530 + rightTxtField)); // top,// right,
		StackPane.setMargin(lblLocation, new Insets(top + 305, left, bottom, 560)); // top,// right,
		StackPane.setMargin(txtFldLocation, new Insets(top + 300, left, bottom, 530 + rightTxtField)); // top,// right,
		StackPane.setMargin(lblEmployeeSignature, new Insets(top + 340, left, bottom, 560)); // top,// right,
		StackPane.setMargin(btnAddEmployeeSignature, new Insets(top + 437, left, bottom, 720)); // top,// right,
		
		StackPane.setMargin(separator, new Insets(top + 480, left, bottom, 0)); // top,// right,
		
		StackPane.setMargin(btnSave, new Insets(540, 15, 30, 865));
		StackPane.setMargin(btnCancel, new Insets(540, 15, 30, 960));

		btnCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				ForensicHome forensicHome = new ForensicHome(ForensicProjectScene.primarySatge);
			}
		});
		lblEmployeeImage.getStyleClass().add("pane");
		lblEmployeeSignature.getStyleClass().add("pane");
		
		stackPane.getChildren().addAll( lblEmployeeID, txtFldEmployeeID, lblEmployeeName, txtFldName, lblEmployeeNationalID,
				txtFldNationalID, txtFldDesignation, lblDesignation, txtFldDepartment, lblDepartment, txtJoiningdate, lblJoiningDate,
				txtFldPresentAddress, lblPresentAddress, lblPermanentAddress, txtFldPermanentAddress, txtFldMobile, lblMobileNo,
				lblEmergencyContact, txtFldEmergencyContact, lblEmail, txtFldEmail, lblReference, txtFldReference, lblEmployeeImage, 
				btnAddEmployeeImage, lblStatus, r1, r2, lblAreaofWork, txtFldAreaOfWork, lblLocation, txtFldLocation, lblEmployeeSignature,
				btnAddEmployeeSignature);

		StackPane.setMargin(stackPane, new Insets(15, 15, 70, 15));
		stackPane.getStyleClass().add("pane");

		mainPane.getChildren().addAll(stackPane, btnSave, btnCancel);
		return PharmacyProjectScene.returnScene(mainPane);
	}

	private boolean formValidation() {
		boolean formValidated = true;

		if (!textFieldValidation(txtFldName, true)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Feild Empty");
			alert.setContentText("Please Insert Employee Name");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtFldNationalID, false)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Feild Empty");
			alert.setContentText("Please Insert Employee's Fathername");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtFldPermanentAddress, false)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Feild Empty");
			alert.setContentText("Please Insert Employee's Mothername");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtFldMobile, false)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Feild Empty");
			alert.setContentText("Please Insert Mobile Number");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtFldEmail, false)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Feild Empty");
			alert.setContentText("Please insert E-mail");
			alert.showAndWait();
			return formValidated;
		}

		return formValidated;
	}

	private boolean textFieldValidation(TextField textField, boolean txtFldName) {
		boolean textFieldValidated;

		if (txtFldName) {

			if (textField.getText().isEmpty()) {
				textFieldValidated = false;
			} else {
				textFieldValidated = true;
			}
		} else {
			if (textField.getText().isEmpty()) {
				textFieldValidated = false;
			} else {
				textFieldValidated = true;
			}
		}
		return textFieldValidated;
	}

	private void refreshForm() {

		txtFldEmail.setText("");
		txtJoiningdate.getEditor().clear();
		txtFldPermanentAddress.setText("");
		txtFldPresentAddress.setText("");
		txtFldReference.setText("");
		txtFldMobile.setText("");
		txtFldName.setText("");
		txtFldDepartment.setText("");
		txtFldDesignation.setText("");
	}
}
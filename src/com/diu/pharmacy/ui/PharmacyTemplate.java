package com.diu.pharmacy.ui;

import com.diu.pharmacy.PharmacyProjectScene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PharmacyTemplate {
	
	Stage primaryStage;
	
	int top = 20;
	int left = 0;
	int bottom = 0;
	int right = 30;
	int rightTxtField = 120;

	int textFieldWidth = 350;
	
	// ALL Label
	private Label lblExpendatureNo = new Label("Expendature No");
	private Label lblSector = new Label("Sector");
	
	// ALL Text Field
	private TextField txtfldExpendatureNo = new TextField();
	private TextField txtfldSector = new TextField();
	//private Separator separator = new Separator();
	
	private Button btnConfirm = new Button("Confirm");
	private Button btnCancel = new Button("Cancel");
	
	public PharmacyTemplate(Stage stage) {
		
		this.primaryStage = stage;
		primaryStage.setScene(expendatureScene());
	}
	
	public Scene expendatureScene() {
		
		StackPane mainPane = new StackPane();
		mainPane.setAlignment(Pos.TOP_LEFT);
		
		StackPane pane = new StackPane();
		pane.setAlignment(Pos.TOP_LEFT);
		
		txtfldExpendatureNo.setMaxWidth(textFieldWidth);
		txtfldSector.setMaxWidth(textFieldWidth);
		
		
		btnCancel.setMaxWidth(80);
		btnConfirm.setMaxWidth(80);
		
		StackPane.setMargin(lblExpendatureNo,new Insets(top + 5, left, bottom, right));
		StackPane.setMargin(txtfldExpendatureNo, new Insets(top, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblSector, new Insets(top + 45, left, bottom, right));
		StackPane.setMargin(txtfldSector, new Insets(top + 40, left, bottom, right + rightTxtField));
		
		//StackPane.setMargin(separator, new Insets(top + 205, left, bottom, 0));
		
		StackPane.setMargin(btnConfirm, new Insets(537, 15, 0, 425));
		StackPane.setMargin(btnCancel, new Insets(537, 15, 0, 515));
		
		pane.getChildren().addAll(lblExpendatureNo, lblSector,
				txtfldExpendatureNo, txtfldSector);
		
		StackPane.setMargin(pane, new Insets(15, 15, 50, 15));
		
		mainPane.getChildren().addAll(pane, btnConfirm, btnCancel);
		
		//cartPane.getStyleClass().add("pane");
		pane.getStyleClass().add("pane");
		
		return PharmacyProjectScene.returnScene(mainPane);
	}

}

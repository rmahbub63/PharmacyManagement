package com.diu.pharmacy.ui;

import com.diu.PharmacyModel.Cart;
import com.diu.pharmacy.PharmacyProjectScene;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PharmacyExpendature {
	
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
	private Label lblCashProvider = new Label("Cash Provider");
	private Label lblBuyerName = new Label("Buyer Name");
	private Label lblDetails = new Label("Details");
	private Label lblCashProvide = new Label("Cash Provide");
	private Label lblCashReceive = new Label("Cash Receive");
	
	// Table
//	private TableView<Cart> tbl = new TableView<Cart>();
//	private TableColumn<Cart, String> productName = new TableColumn<>("P Name");
//	private TableColumn<Cart, String> quantity = new TableColumn<>("Quantity");
//	private TableColumn<Cart, String> cancel = new TableColumn<>("Cancel");
	
	// ALL Text Field
	private TextField txtfldExpendatureNo = new TextField();
	private TextField txtfldSector = new TextField();
	private TextField txtfldCashProvider = new TextField();
	private TextField txtfldBuyerName = new TextField();
	private TextField txtfldDetails = new TextField();
	private TextField txtfldCashProvide = new TextField();
	private TextField txtfldCashReceive = new TextField();
	//private Separator separator = new Separator();
	
	private Button btnConfirm = new Button("Confirm");
	private Button btnCancel = new Button("Cancel");
	
	public PharmacyExpendature(Stage stage) {
		
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
		txtfldCashProvider.setMaxWidth(textFieldWidth);
		txtfldBuyerName.setMaxWidth(textFieldWidth);
		txtfldDetails.setMaxWidth(textFieldWidth);
		txtfldCashProvide.setMaxWidth(textFieldWidth);
		txtfldCashReceive.setMaxWidth(textFieldWidth);
		
		
		btnCancel.setMaxWidth(80);
		btnConfirm.setMaxWidth(80);
		//separator.setMaxWidth(700);
		//separator.setOrientation(Orientation.HORIZONTAL);
		
		StackPane.setMargin(lblExpendatureNo,new Insets(top + 5, left, bottom, right));
		StackPane.setMargin(txtfldExpendatureNo, new Insets(top, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblSector, new Insets(top + 45, left, bottom, right));
		StackPane.setMargin(txtfldSector, new Insets(top + 40, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblCashProvider, new Insets(top + 85, left, bottom, right));
		StackPane.setMargin(txtfldCashProvider, new Insets(top + 80, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblBuyerName, new Insets(top + 125, left, bottom, right));
		StackPane.setMargin(txtfldBuyerName, new Insets(top + 120, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblDetails, new Insets(top + 160, left, bottom, right));
		StackPane.setMargin(txtfldDetails, new Insets(top + 155, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblCashProvide, new Insets(top + 200, left, bottom, right));
		StackPane.setMargin(txtfldCashProvide, new Insets(top + 195, left, bottom, right + rightTxtField));
		StackPane.setMargin(lblCashReceive, new Insets(top + 240, left, bottom, right));
		StackPane.setMargin(txtfldCashReceive, new Insets(top + 235, left, bottom, right + rightTxtField));
		
		//StackPane.setMargin(separator, new Insets(top + 205, left, bottom, 0));
		
		StackPane.setMargin(btnConfirm, new Insets(537, 15, 0, 425));
		StackPane.setMargin(btnCancel, new Insets(537, 15, 0, 515));
		
		pane.getChildren().addAll(lblExpendatureNo, lblSector, lblCashProvider, lblBuyerName, lblDetails, lblCashProvide, lblCashReceive,  
				txtfldExpendatureNo, txtfldSector, txtfldCashProvider, txtfldBuyerName, txtfldDetails, txtfldCashProvide, 
				txtfldCashReceive);
		
		StackPane.setMargin(pane, new Insets(15, 15, 50, 15));
		
		mainPane.getChildren().addAll(pane, btnConfirm, btnCancel);
		
		//cartPane.getStyleClass().add("pane");
		pane.getStyleClass().add("pane");
		
		return PharmacyProjectScene.returnScene(mainPane);
	}

}

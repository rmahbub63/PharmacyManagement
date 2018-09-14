package com.diu.pharmacy.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.diu.PharmacyModel.Cart;
import com.diu.PharmacyModel.Customer;
import com.diu.PharmacyModel.Employee;
import com.diu.PharmacyModel.Medicine;
import com.diu.PharmacyModel.Transiction;
import com.diu.pharmacy.PharmacyProjectScene;
import com.diu.pharmacyController.CustomerController;
import com.diu.pharmacyController.EmployeeController;
import com.diu.pharmacyController.MedicineController;
import com.diu.pharmacyController.TransactionController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Callback;

public class NewTransictionForm {

	Stage primaryStage;
	int top = 25;
	int left = 20;
	int bottom = 0;
	int right = 0;
	int panelTop = 20;
	int panelLeft = 15;
	int panelBottom = 0;
	int panelRight = 0;
	int seceondColumnGap = 380;
	int panelGap = 45;
	int leftTxtField = 120;
	int textFieldWidth = 220;
	int textFieldHeight = 30;

	// ALL Label
	private Label lblTransictionNo = new Label("Transiction No");
	private Label lblDateAndTime = new Label("Date & Time");
	private Label lblMedicineCode = new Label("Medicine Code");
	private Label lblMedicineName = new Label("Medicine Name");
	private Label lblQuantity = new Label("Quantity");
	private Label lblUnitPrice = new Label("Price(Unit)");
	private Label lblTotalPrice = new Label("Total Price");
	private Label lblCustomerName = new Label("Customer Name");
	private Label lblMobileNo = new Label("Mobile No");
	private Label lblServiceProvider = new Label("Service Provider");
	private Label lblPayableAmount = new Label("Payable Amount");
	private Label lblReceivedAmount = new Label("Received Amount");
	private Label lblReturnAmount = new Label("Return Amount");

	private ArrayList<Cart> cartList = new ArrayList<>();
	private ObservableList<Cart> carts;
	private ArrayList<Medicine> medicineList = new ArrayList<>();
	private ObservableList<Medicine> medicines;
	private ArrayList<Employee> employeeList = new ArrayList<>();
	private ObservableList<Employee> employees;
	private ArrayList<Customer> customerList = new ArrayList<>();
	private ObservableList<Customer> customers;
	
	ObservableList<String> mobileNoOptions = FXCollections.observableArrayList("Dhaka", "Chittagong", "Khulna",
			"Rajshahi");

	// Table
	private TableView<Cart> tbl = new TableView<Cart>();
	private TableColumn<Cart, String> tblClmMedicineName = new TableColumn<>("Medicine Name");
	private TableColumn<Cart, String> tblClmQuantity = new TableColumn<>("Quantity");
	private TableColumn<Cart, String> tblClmUnitPrice = new TableColumn<>("Unit Price");
	private TableColumn<Cart, String> tblClmTotalPrice = new TableColumn<>("Total Price");
	private TableColumn<Cart, String> tblClmCancel = new TableColumn<>("Cancel");

	// ALL Text Field
	private TextField txtfldTransictionNo = new TextField();
	private TextField txtfldDateAndTime = new TextField();
	private TextField txtFldMedicineCode = new TextField();
	private ComboBox<String> cmbMedicineName = new ComboBox<String>();
	private TextField txtfldQuantity = new TextField();
	private TextField txtfldUnitPrice = new TextField();
	private TextField txtfldTotalPrice = new TextField();
	private TextField txtfldCustomerName = new TextField();
	private ComboBox<String> cmbMobileNo = new ComboBox<String>();
	private ComboBox<String> cmbServiceProvider = new ComboBox<String>();
	private TextField txtfldPayableAmount = new TextField();
	private TextField txtfldReceivedAmount = new TextField();
	private TextField txtfldReturnAmount = new TextField();

	private Line line = new Line();

	private Button btnAddCart = new Button("Add to Cart");
	private Button btnClear = new Button("Clear");
	private Button btnRemoveAll = new Button("Remove All");
	private Button btnConfirm = new Button("Confirm");
	private Button btnSell = new Button("Sell");
	private Button btnCancel = new Button("Cancel");

	Medicine medicine = new Medicine();
	MedicineController medicineController = new MedicineController();
	EmployeeController employeeController = new EmployeeController();
	CustomerController customerController = new CustomerController();
	private StringBuilder sb;
	private ObservableList<Medicine> data;
	private boolean moveCaretToPos = false;
	private int caretPos;
	Transiction transiction = new Transiction();
	TransactionController transactionController = new TransactionController();

	public NewTransictionForm(Stage stage) {
		this.primaryStage = stage;
		primaryStage.setScene(transictionScene());
		loadData();
		txtfldTransictionNoValue();
	}

	public void txtfldTransictionNoValue() {
		String newTransactionValue = transactionController.getNewTransactionNo();
		if (newTransactionValue != null && !newTransactionValue.isEmpty()) {
			int value = Integer.parseInt(newTransactionValue) + 1;
			txtfldTransictionNo.setText(String.valueOf(value));
		} else {
			txtfldTransictionNo.setText("1001");
		}
	}

	public void loadData() {

		medicineList = medicineController.getAllMedicine();
		for (int i = 0; i < medicineList.size(); i++) {
			cmbMedicineName.getItems().add(medicineList.get(i).getMedicineName());
		}
		employeeList = employeeController.getAllEmployee();
		for (int i = 0; i < employeeList.size(); i++) {
			cmbServiceProvider.getItems().add(employeeList.get(i).getEmployeeName());
		}
//		customerList = customerController.g
	}

	public Scene transictionScene() {

		StackPane mainPane = new StackPane();
		mainPane.setAlignment(Pos.TOP_LEFT);

		StackPane pane = new StackPane();
		pane.setAlignment(Pos.TOP_LEFT);

		txtfldTransictionNo.setMaxWidth(textFieldWidth);
		txtfldDateAndTime.setMaxWidth(textFieldWidth);
		txtFldMedicineCode.setMaxWidth(textFieldWidth);
		cmbMedicineName.setMaxWidth(textFieldWidth);
		txtfldQuantity.setMaxWidth(textFieldWidth);
		txtfldUnitPrice.setMaxWidth(textFieldWidth);
		txtfldTotalPrice.setMaxWidth(textFieldWidth);
		txtfldCustomerName.setMaxWidth(textFieldWidth + 80);
		cmbMobileNo.setMaxWidth(textFieldWidth + 80);
		cmbServiceProvider.setMaxWidth(textFieldWidth + 80);
		txtfldPayableAmount.setMaxWidth(textFieldWidth);
		txtfldReceivedAmount.setMaxWidth(textFieldWidth);
		txtfldReturnAmount.setMaxWidth(textFieldWidth);

		txtfldTransictionNo.setMaxHeight(textFieldHeight);
		txtfldDateAndTime.setMaxHeight(textFieldHeight);
		txtFldMedicineCode.setMaxHeight(textFieldHeight);
		cmbMedicineName.setMaxHeight(textFieldHeight);
		txtfldQuantity.setMaxHeight(textFieldHeight);
		txtfldUnitPrice.setMaxHeight(textFieldHeight);
		txtfldTotalPrice.setMaxHeight(textFieldHeight);
		txtfldCustomerName.setMaxHeight(textFieldHeight);
		cmbMobileNo.setMaxHeight(textFieldHeight);
		cmbServiceProvider.setMaxHeight(textFieldHeight);
		txtfldPayableAmount.setMaxHeight(textFieldHeight);
		txtfldReceivedAmount.setMaxHeight(textFieldHeight);
		txtfldReturnAmount.setMaxHeight(textFieldHeight);

		txtfldTransictionNo.setEditable(false);
		txtfldDateAndTime.setEditable(false);
		txtfldUnitPrice.setEditable(false);
		txtfldPayableAmount.setEditable(false);
		cmbServiceProvider.setEditable(false);
		txtFldMedicineCode.setEditable(false);
		cmbMedicineName.setEditable(true);
		cmbMobileNo.setEditable(true);

		cmbMobileNo.setPromptText("Enter Customer Mobile No");
		cmbServiceProvider.setPromptText("Enter Service provider Name");
		// txtFldMedicineCode.setPromptText("Enter Medicine Code");
		cmbMedicineName.setPromptText("Enter Medicine Name");

		tbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		// txtfldTransictionNo.setEditable(false);
		Date date = new Date();
		txtfldDateAndTime.setText(date.toString());
		btnSell.setMaxWidth(80);
		btnCancel.setMaxWidth(80);
		btnConfirm.setMaxWidth(80);
		btnClear.setMaxWidth(80);
		btnRemoveAll.setMaxWidth(90);

		line.setStartX(837.0f);
		line.setStartY(0.0f);
		line.setEndX(0.0f);
		line.setEndY(0.0f);

		StackPane.setMargin(lblTransictionNo, new Insets(top, right, bottom, left));
		StackPane.setMargin(txtfldTransictionNo, new Insets(top - 5, right, bottom, left + leftTxtField));
		StackPane.setMargin(lblDateAndTime, new Insets(top, left, bottom, right + 490));
		StackPane.setMargin(txtfldDateAndTime, new Insets(top - 5, right, bottom, right + leftTxtField + 490));

		StackPane.setMargin(lblMedicineCode, new Insets(panelTop, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtFldMedicineCode,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblMedicineName, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(cmbMedicineName,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblQuantity, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtfldQuantity,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblUnitPrice, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtfldUnitPrice,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblTotalPrice, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtfldTotalPrice,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));

		StackPane.setMargin(btnClear, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft + 140));
		StackPane.setMargin(btnAddCart, new Insets(panelTop, panelRight, panelBottom, panelLeft + 240));
		StackPane.setMargin(btnRemoveAll, new Insets(panelTop, panelRight, panelBottom, panelLeft + 520));
		StackPane.setMargin(btnConfirm, new Insets(panelTop, panelRight, panelBottom, panelLeft + 630));

		StackPane.setMargin(lblPayableAmount,
				new Insets((panelTop += (panelGap + 25)), panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtfldPayableAmount,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblCustomerName,
				new Insets(panelTop, panelRight, panelBottom, (panelLeft + seceondColumnGap)));
		StackPane.setMargin(txtfldCustomerName,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField + seceondColumnGap));
		StackPane.setMargin(lblReceivedAmount, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtfldReceivedAmount,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblMobileNo, new Insets(panelTop, panelRight, panelBottom, (panelLeft + seceondColumnGap)));
		StackPane.setMargin(cmbMobileNo,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField + seceondColumnGap));
		StackPane.setMargin(lblReturnAmount, new Insets(panelTop += panelGap, panelRight, panelBottom, panelLeft));
		StackPane.setMargin(txtfldReturnAmount,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField));
		StackPane.setMargin(lblServiceProvider,
				new Insets(panelTop, panelRight, panelBottom, (panelLeft + seceondColumnGap)));
		StackPane.setMargin(cmbServiceProvider,
				new Insets(panelTop - 5, panelRight, panelBottom, panelLeft + leftTxtField + seceondColumnGap));

		StackPane.setMargin(btnSell, new Insets(530, 15, 0, 750));
		StackPane.setMargin(btnCancel, new Insets(530, 15, 0, 650));

		StackPane.setMargin(tbl, new Insets(18, 5, 225, 380));
		tbl.getColumns().addAll(tblClmMedicineName, tblClmUnitPrice, tblClmQuantity, tblClmTotalPrice, tblClmCancel);

		StackPane.setMargin(line, new Insets(290, 0, 0, 0));
		StackPane.setMargin(pane, new Insets(60, 5, 65, 5));

		pane.getChildren().addAll(line, tbl, lblMedicineCode, txtFldMedicineCode, lblMedicineName, cmbMedicineName,
				lblQuantity, txtfldQuantity, lblUnitPrice, txtfldUnitPrice, lblTotalPrice, txtfldTotalPrice,
				lblCustomerName, txtfldCustomerName, lblMobileNo, cmbMobileNo, lblServiceProvider, cmbServiceProvider,
				lblPayableAmount, txtfldPayableAmount, lblReceivedAmount, txtfldReceivedAmount, lblReturnAmount,
				txtfldReturnAmount, btnAddCart, btnClear, btnConfirm, btnRemoveAll);

		mainPane.getChildren().addAll(lblTransictionNo, txtfldTransictionNo, lblDateAndTime, txtfldDateAndTime, pane,
				btnSell, btnCancel);

		line.getStyleClass().add("line");
		pane.getStyleClass().add("pane");

		// Combo MedicineName Selected Value Show
		cmbMedicineName.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String medicineName = cmbMedicineName.getValue();
				if (medicineName != null && !medicineName.isEmpty()) {
					Medicine currentMedicine = new Medicine();
					currentMedicine = medicineController.getMedicineByProductName(medicineName);
					txtFldMedicineCode.setText(currentMedicine.getMedicineCode());
					String unitPrice = String.valueOf(currentMedicine.getMedicineIndividualPrice());
					txtfldUnitPrice.setText(unitPrice);
				}
			}
		});

		// cmbMedicineName.getEditor().setOnKeyPressed(new
		// EventHandler<KeyEvent>() {
		// @Override
		// public void handle(KeyEvent event) {
		// ArrayList<Medicine> currentMedicineList = new ArrayList<>();
		// String medicineName = cmbMedicineName.getEditor().getText();
		// System.out.println(medicineName);
		// if (medicineName != null && !medicineName.isEmpty()) {
		// currentMedicineList =
		// medicineController.getAllMedicineByProductNameSearch(medicineName);
		// cmbMedicineName.getItems().clear();
		// for (int i = 0; i < currentMedicineList.size(); i++) {
		// cmbMedicineName.getItems().add(currentMedicineList.get(i).getMedicineName());
		// }
		// } else {
		// System.out.println("Here");
		// currentMedicineList = medicineController.getAllMedicine();
		// cmbMedicineName.getItems().clear();
		// for (int i = 0; i < currentMedicineList.size(); i++) {
		// cmbMedicineName.getItems().add(currentMedicineList.get(i).getMedicineName());
		// }
		// }
		// cmbMedicineName.show();
		// // TextFields.bindAutoCompletion(comboBox.getEditor(),
		// // comboBox.getItems());
		// }
		// });
		txtfldQuantity.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (txtfldQuantity.getText() != null && !txtfldQuantity.getText().isEmpty()) {
					double quantity = Double.parseDouble(txtfldQuantity.getText());
					double unitPrice = Double.parseDouble(txtfldUnitPrice.getText());
					if (quantity > 0.0 || unitPrice > 0.0) {
						txtfldTotalPrice.setText(String.valueOf(quantity * unitPrice));
					}
				} else {
					txtfldTotalPrice.setText("");
				}
			}
		});

		cmbMedicineName.getEditor().setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					caretPos = -1;
					moveCaret(cmbMedicineName.getEditor().getText().length());
					return;
				} else if (event.getCode() == KeyCode.DOWN) {
					if (!cmbMedicineName.isShowing()) {
						cmbMedicineName.show();
					}
					caretPos = -1;
					moveCaret(cmbMedicineName.getEditor().getText().length());
					return;
				} else if (event.getCode() == KeyCode.BACK_SPACE) {
					moveCaretToPos = true;
					caretPos = cmbMedicineName.getEditor().getCaretPosition();
				} else if (event.getCode() == KeyCode.DELETE) {
					moveCaretToPos = true;
					caretPos = cmbMedicineName.getEditor().getCaretPosition();
				}

				if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT || event.isControlDown()
						|| event.getCode() == KeyCode.HOME || event.getCode() == KeyCode.END
						|| event.getCode() == KeyCode.TAB) {
					return;
				}

				ArrayList<Medicine> currentMedicineList = new ArrayList<>();
				String medicineName = cmbMedicineName.getEditor().getText();
				System.out.println(medicineName);
				currentMedicineList = medicineController.getAllMedicineByProductNameSearch(medicineName);
				cmbMedicineName.getItems().clear();
				for (int i = 0; i < currentMedicineList.size(); i++) {
					cmbMedicineName.getItems().add(currentMedicineList.get(i).getMedicineName());
				}
				cmbMedicineName.show();
				cmbMedicineName.getEditor().setText(medicineName);
				if (!moveCaretToPos) {
					caretPos = -1;
				}
				moveCaret(medicineName.length());
				if (!currentMedicineList.isEmpty()) {
					cmbMedicineName.show();
				} else {
					// Refresh Form
				}
			}

		});


		btnAddCart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (addToCartValidation()) {
					addTocartValue();
					refreashCart();
				}
			}
		});
		btnClear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				refreashCart();
			}
		});
		btnRemoveAll.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				cartList.clear();
				carts.clear();
				tbl.getItems().clear();
			}
		});
		btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double totalPayableAmount = 0.0;
				for (int i = 0; i < cartList.size(); i++) {
					totalPayableAmount += cartList.get(i).getTotalPrice();
				}
				txtfldPayableAmount.setText(String.valueOf(totalPayableAmount));
			}
		});
		btnSell.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (sellValidation()) {
					addToTransaction();
					transactionController.updateNewTransactionNo(txtfldTransictionNo.getText());
					TransactionList transactionList = new TransactionList(PharmacyProjectScene.primarySatge);
				}
			}
		});
		txtfldReceivedAmount.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (txtfldReceivedAmount.getText() != null && !txtfldReceivedAmount.getText().isEmpty()) {
					double payableAmount = Double.parseDouble(txtfldPayableAmount.getText());
					double receivedAmount = Double.parseDouble(txtfldReceivedAmount.getText());
					if ((payableAmount > 0.0 || receivedAmount > 0.0) && (receivedAmount > payableAmount)) {
						txtfldReturnAmount.setText(String.valueOf(receivedAmount - payableAmount));
					}
				} else {
					txtfldReturnAmount.setText("");
				}
			}
		});
		cmbMobileNo.getEditor().setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.UP) {
					caretPos = -1;
					moveCaret(cmbMobileNo.getEditor().getText().length());
					return;
				} else if (event.getCode() == KeyCode.DOWN) {
					if (!cmbMobileNo.isShowing()) {
						cmbMobileNo.show();
					}
					caretPos = -1;
					moveCaret(cmbMobileNo.getEditor().getText().length());
					return;
				} else if (event.getCode() == KeyCode.BACK_SPACE) {
					moveCaretToPos = true;
					caretPos = cmbMobileNo.getEditor().getCaretPosition();
				} else if (event.getCode() == KeyCode.DELETE) {
					moveCaretToPos = true;
					caretPos = cmbMobileNo.getEditor().getCaretPosition();
				}

				if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT || event.isControlDown()
						|| event.getCode() == KeyCode.HOME || event.getCode() == KeyCode.END
						|| event.getCode() == KeyCode.TAB) {
					return;
				}

				ArrayList<Customer> currentCustomerList = new ArrayList<>();
				String cutomerMobileNO = cmbMobileNo.getEditor().getText();
				System.out.println(cutomerMobileNO);
				currentCustomerList = customerController.getAllCustomerBySearchKey(cutomerMobileNO);
				cmbMobileNo.getItems().clear();
				for (int i = 0; i < currentCustomerList.size(); i++) {
					cmbMobileNo.getItems().add(currentCustomerList.get(i).getCustomerContact());
				}
				cmbMobileNo.show();
				cmbMobileNo.getEditor().setText(cutomerMobileNO);
				if (!moveCaretToPos) {
					caretPos = -1;
				}
				moveCaret(cutomerMobileNO.length());
				if (!currentCustomerList.isEmpty()) {
					cmbMobileNo.show();
				} else {
					// Refresh Form
				}
			}

		});
		cmbMobileNo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String mobileNo = cmbMobileNo.getValue();
				if (mobileNo != null && !mobileNo.isEmpty()) {
					Customer currentCutomer = new Customer();
					currentCutomer = customerController.getCustomerByCustomerMobileNo(mobileNo);
					txtfldCustomerName.setText(currentCutomer.getCustomername());
				}
			}
		});
		
		return PharmacyProjectScene.returnScene(mainPane);
	}

	private void moveCaret(int textLength) {
		if (caretPos == -1) {
			cmbMobileNo.getEditor().positionCaret(textLength);
		} else {
			cmbMobileNo.getEditor().positionCaret(caretPos);
		}
		moveCaretToPos = false;
	}

	public void addTocartValue() {
		String transictionNO = txtfldTransictionNo.getText();
		String medicineCode = txtFldMedicineCode.getText();
		String medicineName = cmbMedicineName.getEditor().getText();
		int Quantity = Integer.parseInt(txtfldQuantity.getText());
		double unitPrice = Double.parseDouble(txtfldUnitPrice.getText());
		double totalPrice = Double.parseDouble(txtfldTotalPrice.getText());
		cartList.add(new Cart(transictionNO, medicineCode, medicineName, Quantity, unitPrice, totalPrice));
		carts = FXCollections.observableArrayList(cartList);
		tblClmMedicineName.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
		tblClmQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		tblClmUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
		tblClmTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
		tblClmCancel.setCellValueFactory(new PropertyValueFactory<>("delete"));
		// tbl.getItems().clear();
		tbl.refresh();
		tbl.setItems(carts);

		Callback<TableColumn<Cart, String>, TableCell<Cart, String>> delete = new Callback<TableColumn<Cart, String>, TableCell<Cart, String>>() {

			@Override
			public TableCell<Cart, String> call(TableColumn<Cart, String> param) {
				TableCell<Cart, String> cell = new TableCell<Cart, String>() {

					final Button btn = new Button("Cancel");

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							btn.setOnMouseClicked((MouseEvent) -> {
								System.out.println("Deleted");
								Cart deletedCart = tbl.getItems().get(getIndex());
								cartList.remove(deletedCart);
								carts.remove(deletedCart);
								tbl.getItems().remove(deletedCart);
								tbl.refresh();
								tbl.setItems(carts);
							});
							setGraphic(btn);
							btn.getStyleClass().add("tblbutton");
							setText(null);
							setAlignment(Pos.CENTER);
							setCursor(Cursor.HAND);
							setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						}
					}
				};
				return cell;
			}
		};
		tblClmCancel.setCellFactory(delete);
	}

	private void addToTransaction() {
		String transictionNo = txtfldTransictionNo.getText();
		// Date date = new Date();
		// SimpleDateFormat dtf = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
		// String transictionDate = dtf.format(date);
		String transictionDate = txtfldDateAndTime.getText();
		String customerName = txtfldCustomerName.getText();
		String mobileNo = cmbMobileNo.getValue().toString();
		String serviceProviderName = cmbServiceProvider.getValue().toString();
		double payableAmount = Double.parseDouble(txtfldPayableAmount.getText());
		double recievedAmount = Double.parseDouble(txtfldReceivedAmount.getText());
		double returnAmount = Double.parseDouble(txtfldReturnAmount.getText());

		transiction.setTransictionNo(transictionNo);
		transiction.setTransictionDate(transictionDate);
		transiction.setCustomerName(customerName);
		transiction.setMobileNo(mobileNo);
		transiction.setServiceProviderName(serviceProviderName);
		transiction.setPayableAmount(payableAmount);
		transiction.setRecievedAmount(recievedAmount);
		transiction.setReturnAmount(returnAmount);
		transactionController.saveTransiction(transiction);
	}

	private boolean addToCartValidation() {

		boolean formValidated = true;

		if (!textFieldValidation(txtFldMedicineCode, true)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Field Empty");
			alert.setHeaderText("");
			alert.setContentText("Please Select a Medicine Name");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtfldQuantity, false)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Field Empty");
			alert.setHeaderText("");
			alert.setContentText("Please Insert Quantity");
			alert.showAndWait();

			return formValidated;
		}

		if (!textFieldValidation(txtfldTotalPrice, false)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Field Empty");
			alert.setHeaderText("");
			alert.setContentText("Please Insert Total Price");
			alert.showAndWait();
			return formValidated;
		}
		return formValidated;
	}

	private boolean sellValidation() {

		boolean formValidated = true;

		if (!textFieldValidation(txtfldReceivedAmount, true)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Field Empty");
			alert.setContentText("Please Insert Received Amount");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtfldReturnAmount, true)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Field Empty");
			alert.setContentText("Please Insert Return Amount");
			alert.showAndWait();
			return formValidated;
		}

		if (!textFieldValidation(txtfldCustomerName, true)) {
			formValidated = false;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Field Empty");
			alert.setContentText("Please Insert Customer Name");
			alert.showAndWait();
			return formValidated;
		}
		return formValidated;
	}

	private boolean textFieldValidation(TextField textField, boolean txtName) {
		boolean textFieldValidated;

		if (txtName) {

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

	private void refreashCart() {
		txtFldMedicineCode.setText("");
		cmbMedicineName.setValue(null);
		txtfldQuantity.setText("");
		txtfldUnitPrice.setText("");
		txtfldTotalPrice.setText("");
	}

}

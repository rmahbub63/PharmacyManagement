package com.diu.pharmacy.ui;

import com.diu.PharmacyModel.Medicine;
import java.util.ArrayList;

import com.diu.PharmacyModel.Transiction;
import com.diu.pharmacy.PharmacyProjectScene;
import com.diu.pharmacyController.TransactionController;

//import com.softbin.library.Common;
//import com.softbin.library.controller.EmployeController;
//import com.softbin.library.model.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CustomerList {

	private Stage stage;

	private TableView<Medicine> tbl = new TableView<Medicine>();
	private TableColumn<Medicine, String> transactionNo = new TableColumn<>("Transaction No");
	private TableColumn<Medicine, String> transactionDate = new TableColumn<>("Date");
	private TableColumn<Medicine, String> transactionCustomer = new TableColumn<>("Customer");
	private TableColumn<Medicine, String> transactionServiceProvider = new TableColumn<>("Service Provider");
	private TableColumn<Medicine, String> transactionPayableAmount = new TableColumn<>("Payable Amount");
	private TableColumn<Medicine, String> transactionEdit = new TableColumn<>("Edit");
	private TableColumn<Medicine, String> transactionDelete = new TableColumn<>("Delete");

	private Label lblSearch = new Label("Search");
	private TextField txtfldSearch = new TextField();

	private Transiction transiction = new Transiction();
	private ArrayList<Transiction> list = new ArrayList<>();
	private TransactionController transactionController = new TransactionController();
	private ObservableList<Transiction> transictions;

	public CustomerList(Stage stage) {
		this.stage = stage;
		this.stage.setScene(addList());
		this.stage.show();
	}

	@SuppressWarnings("unchecked")
	public Scene addList() {

		StackPane mainPane = new StackPane();
		mainPane.setAlignment(Pos.TOP_LEFT);

		StackPane pane = new StackPane();
		pane.setAlignment(Pos.TOP_LEFT);

		txtfldSearch.setMaxWidth(220);

		// empName.prefWidthProperty().bind(tbl.widthProperty().multiply(10));

		list = transactionController.getAllTransiction();
		transictions = FXCollections.observableArrayList(list);

		transactionNo.setCellValueFactory(new PropertyValueFactory<>("transictionNo"));
		transactionDate.setCellValueFactory(new PropertyValueFactory<>("transictionDate"));
		transactionCustomer.setCellValueFactory(new PropertyValueFactory<>("customerName"));
		transactionServiceProvider.setCellValueFactory(new PropertyValueFactory<>("serviceProviderName"));
		transactionPayableAmount.setCellValueFactory(new PropertyValueFactory<>("payableAmount"));
		transactionEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));
		transactionDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
//		tbl.setItems(transictions);

		tbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		Callback<TableColumn<Transiction, String>, TableCell<Transiction, String>> view = new Callback<TableColumn<Transiction, String>, TableCell<Transiction, String>>() {

			@Override
			public TableCell<Transiction, String> call(TableColumn<Transiction, String> param) {
				TableCell<Transiction, String> cell = new TableCell<Transiction, String>() {

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {

							ImageView editImage = new ImageView();
							editImage.setImage(new Image(CustomerList.class.getResource("/images/view.png").toString()));
							editImage.setOnMouseClicked((MouseEvent) -> {

							});
							setGraphic(editImage);
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

		Callback<TableColumn<Transiction, String>, TableCell<Transiction, String>> edit = new Callback<TableColumn<Transiction, String>, TableCell<Transiction, String>>() {

			@Override
			public TableCell<Transiction, String> call(TableColumn<Transiction, String> param) {
				TableCell<Transiction, String> cell = new TableCell<Transiction, String>() {

					Label label = new Label();

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {

							ImageView editImage = new ImageView();
							editImage.setImage(new Image(CustomerList.class.getResource("/images/edit.png").toString()));

							label.setGraphic(editImage);

							label.setOnMouseClicked((MouseEvent) -> {

								// Book employee =
								// tbl.getSelectionModel().getSelectedItem();
								// EditEmployee editEmployee = new
								// EditEmployee(employee);
								// stage.setScene(editEmployee.addEmployeeScene());
								// stage.show();
							});
							setGraphic(label);
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

//		transactionEdit.setCellFactory(edit);

		Callback<TableColumn<Transiction, String>, TableCell<Transiction, String>> delete = new Callback<TableColumn<Transiction, String>, TableCell<Transiction, String>>() {

			@Override
			public TableCell<Transiction, String> call(TableColumn<Transiction, String> param) {
				TableCell<Transiction, String> cell = new TableCell<Transiction, String>() {

					Label deleteLabel = new Label();

					@Override
					public void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
							setText(null);
						} else {
							ImageView deleteImage = new ImageView();
							deleteImage.setImage(new Image(CustomerList.class.getResource("/images/delete.png").toString()));

							deleteLabel.setGraphic(deleteImage);

							deleteLabel.setOnMouseClicked((MouseEvent) -> {
//								Transiction transiction = tbl.getSelectionModel().getSelectedItem();
								TransactionController transactionController = new TransactionController();
								transactionController.deleteTransiction(transiction);
								transictions.remove(transiction);
								tbl.getItems().remove(transiction);
								tbl.refresh();
//								tbl.setItems(transictions);
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Message");
								alert.setHeaderText("");
								alert.setContentText("Deleted");
								alert.showAndWait();

							});

							setGraphic(deleteLabel);
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

//		transactionDelete.setCellFactory(delete);

		StackPane.setMargin(lblSearch, new Insets(18, 0, 0, 25));
		StackPane.setMargin(txtfldSearch, new Insets(15, 0, 0, 100));
		StackPane.setMargin(tbl, new Insets(55, 15, 15, 15));

		tbl.getColumns().addAll(transactionNo, transactionDate, transactionCustomer, transactionServiceProvider,
				transactionPayableAmount, transactionEdit, transactionDelete);
		pane.getChildren().addAll(lblSearch, txtfldSearch, tbl);

		// StackPane.setMargin(pane, new Insets(15, 15, 15, 15));
		pane.getStyleClass().add("pane");

		mainPane.getChildren().addAll(pane);
		return PharmacyProjectScene.returnScene(mainPane);
	}
}

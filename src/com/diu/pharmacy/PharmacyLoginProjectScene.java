package com.diu.pharmacy;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PharmacyLoginProjectScene {
	public static Scene returnScene(Parent parent) {
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(PharmacyLoginProjectMenu.getMneuBar());
		borderPane.setCenter(parent);
		Scene scene = new Scene(borderPane, 850, 600);
		scene.getStylesheets().add(PharmacyLoginProjectScene.class.getResource("/design/style.css").toExternalForm());
		return scene;
	}
	public static Stage primarySatge;

}
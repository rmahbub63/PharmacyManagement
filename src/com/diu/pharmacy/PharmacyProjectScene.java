package com.diu.pharmacy;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PharmacyProjectScene {
	public static Scene returnScene(Parent parent) {
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(PharmacyProjectMenu.getMneuBar());
		borderPane.setCenter(parent);
		Scene scene = new Scene(borderPane, 850, 600);
		scene.getStylesheets().add(PharmacyProjectScene.class.getResource("/design/style.css").toExternalForm());
		return scene;
	}
	public static Stage primarySatge;

}
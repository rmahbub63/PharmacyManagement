package com.diu.pharmacy.ui;



import com.diu.pharmacy.PharmacyProjectScene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PharmacyHome {
	
	Stage primaryStage;
	
	ImageView view = new ImageView();
	
	public PharmacyHome(Stage stage) {
		this.primaryStage = stage;
		primaryStage.setScene(settingScene());
	}
	
	private Scene settingScene(){
		StackPane mainPane = new StackPane();
		mainPane.setAlignment(Pos.TOP_LEFT);
		 
		StackPane pane = new StackPane();
		pane.setAlignment(Pos.TOP_LEFT);
		
		//main ui
		view.setImage(new Image(PharmacyHome.class.getResource("/images/home.jpg").toString()));
		//main ui
		
		pane.getChildren().addAll(view);
		pane.getStyleClass().add("pane");
		
		mainPane.getChildren().addAll(pane);
		
		return PharmacyProjectScene.returnScene(mainPane);
	}

}
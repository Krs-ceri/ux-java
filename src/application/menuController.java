package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import com.sun.javafx.scene.EnteredExitedHandler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.omg.PortableInterceptor.SUCCESSFUL;

import com.sun.prism.shader.Texture_Color_AlphaTest_Loader;

import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.WindowEvent;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;


public class menuController implements Initializable{

	Main main = Main.getInstance();

    @FXML
    private AnchorPane fenetre;
	
    @FXML
	void showSolo(ActionEvent event) throws IOException{
    	Main main = Main.getInstance();
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
		main.setRoot(loader.load());

		Scene scene = new Scene(main.getRoot());
    	main.getWindow().setScene(scene);
    	main.getWindow().show();
	}
    @FXML
	void showDuo(ActionEvent event) throws IOException{
    	Main main = Main.getInstance();
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
		main.setRoot(loader.load());

		Scene scene = new Scene(main.getRoot());
    	main.getWindow().setScene(scene);
    	main.getWindow().show();
	}
	
    @FXML
    void handleQuit(ActionEvent event)
    {
    	System.exit(0);
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{


	}
	
	@FXML
	void options(ActionEvent event) throws IOException{
    	Main main = Main.getInstance();
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("GameView.fxml"));
		main.setRoot(loader.load());

		Scene scene = new Scene(main.getRoot());
    	main.getWindow().setScene(scene);
    	main.getWindow().show();
	}
}

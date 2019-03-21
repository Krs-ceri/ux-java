package application;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
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

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;

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
    private Button eSolo;
    @FXML
    private Button mSolo;
    @FXML
    private Button hSolo;
	
    @FXML
	void showSolo(ActionEvent event) throws IOException{
    	if(eSolo.isVisible()) {
        	eSolo.setVisible(false);
        	mSolo.setVisible(false);
        	hSolo.setVisible(false);
        	TranslateTransition ts1 = new TranslateTransition();
        	ts1.setNode(eSolo);
        	ts1.setCycleCount(1); 
            ts1.setToX(180);
            ts1.play(); 
        	TranslateTransition ts2 = new TranslateTransition();
        	ts2.setNode(mSolo);
        	ts2.setCycleCount(1); 
            ts2.setToX(180);
            ts2.play(); 
        	TranslateTransition ts3 = new TranslateTransition();
        	ts3.setNode(hSolo);
        	ts3.setCycleCount(1); 
            ts3.setToX(180);
            ts3.play(); 
    	}
    	else {
        	eSolo.setVisible(true);
        	mSolo.setVisible(true);
        	hSolo.setVisible(true);
        	TranslateTransition ts1 = new TranslateTransition();
        	ts1.setNode(eSolo);
        	ts1.setCycleCount(1); 
            ts1.setToX(-180);
            ts1.play(); 
        	TranslateTransition ts2 = new TranslateTransition();
        	ts2.setNode(mSolo);
        	ts2.setCycleCount(1); 
            ts2.setToX(-180);
            ts2.play(); 
        	TranslateTransition ts3 = new TranslateTransition();
        	ts3.setNode(hSolo);
        	ts3.setCycleCount(1); 
            ts3.setToX(-180);
            ts3.play(); 
    	}

	}
    
    @FXML
	void showESolo(ActionEvent event) throws IOException{
    	try
		{
        	Main main = Main.getInstance();
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
    		main.setRoot(loader.load());

    		Scene scene = new Scene(main.getRoot());
        	main.getWindow().setScene(scene);
        	main.getWindow().show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.err.println("Impossible d'afficher le menu");
		}

	}
    
    @FXML
	void showMSolo(ActionEvent event) throws IOException{
    	  	
    	try
		{
        	Main main = Main.getInstance();
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
    		main.setRoot(loader.load());

    		Scene scene = new Scene(main.getRoot());
        	main.getWindow().setScene(scene);
        	main.getWindow().show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.err.println("Impossible d'afficher le menu");
		}
	}
    
    @FXML
	void showHSolo(ActionEvent event) throws IOException{
    	  	
    	try
		{
        	Main main = Main.getInstance();
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
    		main.setRoot(loader.load());

    		Scene scene = new Scene(main.getRoot());
        	main.getWindow().setScene(scene);
        	main.getWindow().show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.err.println("Impossible d'afficher le menu");
		}
	}
    
    @FXML
	void showDuo(ActionEvent event) throws IOException{
    	try
		{
        	Main main = Main.getInstance();
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
    		main.setRoot(loader.load());

    		Scene scene = new Scene(main.getRoot());
        	main.getWindow().setScene(scene);
        	main.getWindow().show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.err.println("Impossible d'afficher le menu");
		}
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
    	try
		{
        	Main main = Main.getInstance();
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("../View/GameView.fxml"));
    		main.setRoot(loader.load());

    		Scene scene = new Scene(main.getRoot());
        	main.getWindow().setScene(scene);
        	main.getWindow().show();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.err.println("Impossible d'afficher le menu");
		}
	}
}

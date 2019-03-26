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
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.WindowEvent;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import application.Morpion;

public class GameController implements Initializable{

	@FXML
	private Label current;
	
	@FXML
	private GridPane grid;
	@FXML
	private TableView table;
	@FXML
	private AnchorPane f;
	
	@FXML
	private Button a0;
	
	@FXML
	private Button a1;
	@FXML
	private Button a2;
	@FXML
	private Button b0;
	@FXML
	private Button b1;
	@FXML
	private Button b2;
	@FXML
	private Button c0;
	@FXML
	private Button c1;
	@FXML
	private Button c2;

	
	
	Main main = Main.getInstance();
	
    @FXML
    void goBack(ActionEvent event) throws IOException
    {
    	Main main = Main.getInstance();
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../View/APIView.fxml"));
    	main.setRoot(loader.load());

    	Scene scene = new Scene(main.getRoot());
    	main.getWindow().setScene(scene);
    	main.getWindow().show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Morpion game = new Morpion();
		Main.getInstance().getWindow().setOnCloseRequest( event ->
		{
			Platform.exit();
			System.exit(0);
		});
	}
	
	@FXML
	void a0(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 0, 0)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	a0.setFont(new Font(20));
                    a0.setText(g.Current().toString());
                }
            });
		}
	}
	
	@FXML
	void a1(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 0, 1)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	a1.setFont(new Font(20));
                    a1.setText(g.Current().toString());
                }
            });
		}
	}
	@FXML
	void a2(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 0, 2)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	a2.setFont(new Font(20));
                    a2.setText(g.Current().toString());
                }
            });
		}
	}
	@FXML
	void b0(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 1, 0)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	b0.setFont(new Font(20));
                    b0.setText(g.Current().toString());
                }
            });
		}
	}
	
	@FXML
	void b1(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 1, 1)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	b1.setFont(new Font(20));
                    b1.setText(g.Current().toString());
                }
            });
		}
	}
	
	@FXML
	void b2(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 1, 2)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	b2.setFont(new Font(20));
                    b2.setText(g.Current().toString());
                }
            });
		}	
	}
	@FXML
	void c0(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 2, 0)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	c0.setFont(new Font(20));
                    c0.setText(g.Current().toString());
                }
            });
		}
	}
	
	@FXML
	void c1(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 2, 1)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	c1.setFont(new Font(20));
                    c1.setText(g.Current().toString());
                }
            });
		}
	}
	
	@FXML
	void c2(ActionEvent event) {
		Morpion g = Morpion.getInstance();
		if(g.addTac(g.Current(), 2, 2)) {
            Platform.runLater(new Runnable(){

                @Override
                public void run() {
                	c2.setFont(new Font(20));
                    c2.setText(g.Current().toString());
                }
            });
		}
	}
}

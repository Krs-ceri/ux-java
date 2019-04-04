package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/**
 * 
 * @author uapv1502995
 *
 */
public class optionControler implements Initializable{
	Main main = Main.getInstance();

    @FXML
    private AnchorPane fenetre;
    @FXML
    private Button train;
    @FXML
    private Button back;
    @FXML
    private Button save;
    @FXML
    private RadioButton easy;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton hard;

    
    @FXML
    void handleBack(ActionEvent event) throws IOException
    {
    	Main main = Main.getInstance();
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../View/APIView.fxml"));
    	main.setRoot(loader.load());

    	Scene scene = new Scene(main.getRoot());
    	main.getWindow().setScene(scene);
    	main.getWindow().show();
    }
    
    @FXML
    void trainAI() {
    	
    }
    
    @FXML
    void saveConf() {
    	
    }
    
    @FXML
    void verifyRadio() {
    	
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
	    ToggleGroup radioGroup = new ToggleGroup();

	    easy.setToggleGroup(radioGroup);
	    medium.setToggleGroup(radioGroup);
	    hard.setToggleGroup(radioGroup);
		Main.getInstance().getWindow().setOnCloseRequest( event ->
		{
			Platform.exit();
			System.exit(0);
		});
	}
}

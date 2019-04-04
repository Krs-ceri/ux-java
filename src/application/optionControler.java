package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ai.AI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
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
    private ProgressBar prog;
    @FXML
    ToggleGroup radioGroup = new ToggleGroup();
    
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
    	String ma = radioGroup.getSelectedToggle().toString();
    	System.out.println(ma);
    	if(ma.equals("easy")) {
    		this.progBarAble();
    		 prog.setProgress(0);
             AI ai = new AI("1");
             File file = new File("data/data");
             ai.trainFromDataWithProgressBar(file, 1000, prog);
             this.progBarUnable();
    	}
    	else if(ma.equals("medium")) {
    		this.progBarAble();
   		 prog.setProgress(0);
         AI ai = new AI("2");
         File file = new File("data/data");
         ai.trainFromDataWithProgressBar(file, 10000, prog);
         this.progBarUnable();
    	}
    	else if(ma.equals("medium")) {
    		this.progBarAble();
            prog.setProgress(0);
            AI ai = new AI("Hard");
            File file = new File("data/data");
            ai.trainFromDataWithProgressBar(file, 100000, prog);
            this.progBarUnable();
    	}
    	 
    }
    
    public void progBarAble() {
    	easy.setVisible(false);
    	medium.setVisible(false);
    	hard.setVisible(false);
    	prog.setVisible(true);
    	save.setVisible(false);
    	train.setVisible(false);
    }
    
    public void progBarUnable() {
    	easy.setVisible(true);
    	medium.setVisible(true);
    	hard.setVisible(true);
    	prog.setVisible(false);
    	save.setVisible(true);
    	train.setVisible(true);
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

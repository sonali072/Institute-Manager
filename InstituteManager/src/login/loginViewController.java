package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPwd;

    @FXML
    void doLogin(ActionEvent event) {
    	if(txtId.getText().equals("admin") && txtPwd.getText().equals("12345")) {
    		try{
        		Parent root=FXMLLoader.load(getClass().getResource("/dashboard/dashView.fxml")); 
    			Scene scene = new Scene(root);
    			Stage stage=new Stage();
    			stage.setScene(scene);
    			stage.show();
        		//to hide the opened window
    			   /*Scene scene1=(Scene)btnComboApp.getScene();
    			   scene1.getWindow().hide();
    			 */
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void initialize() {
        
    	
    }

}

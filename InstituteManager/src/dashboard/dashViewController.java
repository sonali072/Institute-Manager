package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class dashViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void doAllBatches(MouseEvent event) {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/allBatchesTableView/batchTableView.fxml")); 
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

    @FXML
    void doBatchMaster(MouseEvent event) {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/batches/batchMasterView.fxml")); 
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

    @FXML
    void doFeeCollector(MouseEvent event) {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/feeCollection/feeCollectorView.fxml")); 
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

    @FXML
    void doFeeStatus(MouseEvent event) {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/feeStatusTableView/feeTableView.fxml")); 
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

    @FXML
    void doNewAdmission(MouseEvent event) {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/admissions/newAdmissionView.fxml")); 
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

    @FXML
    void doStudentGoogler(MouseEvent event) {
    	try{
    		//Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("chkradio/ChkRadView.fxml")); 
    		Parent root=FXMLLoader.load(getClass().getResource("/allStudentsTableView/studentTableView.fxml")); 
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

    @FXML
    void initialize() {

    }

}

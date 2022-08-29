package admissions;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class newAdmissionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anchor;

    @FXML
    private ComboBox<String> comboBranch;

    @FXML
    private ComboBox<String> comboCollege;

    @FXML
    private ComboBox<String> comboSem;

    @FXML
    private ComboBox<String> comboTech;
    
    @FXML
    private ImageView pic;

    @FXML
    private TextField txtAdvFee;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSdate;

    @FXML
    private TextField txtStime;
    
    @FXML
    private TextField txtTid;
    
    File show;

    PreparedStatement pst;
    
    @FXML
    void doClear(ActionEvent event) {
    	txtTid.setText("");
    	txtName.setText("");
    	txtMobile.setText("");
    	comboCollege.getEditor().setText("");
    	comboSem.getEditor().setText("");
    	comboBranch.getEditor().setText("");
    	comboTech.setValue("");;
    	txtSdate.setText("");
    	txtStime.setText("");
    	txtFee.setText("");
    	txtAdvFee.setText("");
    	pic.setImage(null);
    	
    }

    @FXML
    void doDelete(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from trainees tid=?");
			pst.setString(1, txtTid.getText());
			pst.executeUpdate();
			
			System.out.println("Record deleted Successfully!!");
			doFillCollege();
			doFillBranch();
			doFillSemester();
		}
		catch(Exception exp){
			exp.printStackTrace();
		}
    }

    @FXML
    void doSave(ActionEvent event) {
    	try {
    		pst=con.prepareStatement("insert into trainees values(?,?,?,?,?,?,?,?,?,?,?,?,?,current_date())");
    		
    		int rdm = getRandom();
    		int n = txtMobile.getText().length();
    		String s = String.valueOf(rdm).concat(txtName.getText().substring(0, 3).concat(txtMobile.getText().substring(n-3,n)));
    		txtTid.setText(s);
    		pst.setString(1, s);
    		pst.setString(2, txtName.getText());
    		pst.setString(3, txtMobile.getText());
			pst.setString(4, comboCollege.getEditor().getText());
			pst.setString(5, comboSem.getEditor().getText());
			pst.setString(6, comboBranch.getEditor().getText());
			pst.setString(7, comboTech.getSelectionModel().getSelectedItem());
			pst.setString(8, txtSdate.getText());
			pst.setString(9, txtStime.getText());
			pst.setString(10, txtFee.getText());
			pst.setInt(11, Integer.parseInt(txtAdvFee.getText()));
			pst.setInt(12, Integer.parseInt(txtFee.getText())-Integer.parseInt(txtAdvFee.getText()));
			pst.setString(13, show.getAbsolutePath());
			
			pst.executeUpdate();
			System.out.println("Data Saved Successfullyyyyy");
			showMsg("Your Trainee Id = "+s);
			doFillCollege();
			doFillBranch();
			doFillSemester();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void doSearch(ActionEvent event) {
try {
			
			pst=con.prepareStatement("select * from  trainees where tid=?");
			pst.setString(1, txtTid.getText());
			ResultSet tableInMem= pst.executeQuery();
			
			boolean jasoos=false;
			while(tableInMem.next()) {
				jasoos=true;
				String tid = tableInMem.getString("tid");
	    		String name = tableInMem.getString("name");
	    		String mobile = tableInMem.getString("mobile");
	    		String college = tableInMem.getString("college");
	    		String sem = tableInMem.getString("sem");
	    		String branch = tableInMem.getString("branch");
	    		String tech = tableInMem.getString("technology");
	    		String date = tableInMem.getString("sdate");
	    		String time = tableInMem.getString("stime");
	    		int totalFee = tableInMem.getInt("tfee");
	    		int advFee = tableInMem.getInt("advfee");
	    		    		
	    		txtTid.setText(tid);
	    		txtName.setText(name);
	        	txtMobile.setText(mobile);
	        	comboCollege.getEditor().setText(college);
	        	comboSem.getEditor().setText(sem);
	        	comboBranch.getEditor().setText(branch);
	        	comboTech.setValue(tech);
	        	txtSdate.setText(date);
	        	txtStime.setText(time);
	        	txtFee.setText(String.valueOf(totalFee));
	        	txtAdvFee.setText(String.valueOf(advFee));
				
			}
			if(jasoos==false) {
				showMsg("INVALID TRAINEE ID");
			}
			

		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    void showMsg(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Important Information");
    	alert.setContentText(msg);
    	alert.show();
    }
    
    @FXML
    void doGetInfo(ActionEvent event) {
    	
    	try {
			pst = con.prepareStatement("select * from batches where Batch=?");
			pst.setString(1, comboTech.getSelectionModel().getSelectedItem());
			ResultSet info = pst.executeQuery();
			//
			while(info.next())
			{
				txtSdate.setText(info.getDate("sdate").toString());
				txtStime.setText(info.getString("stime"));
				txtFee.setText(info.getString("fee"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
     int getRandom() {
		// TODO Auto-generated method stub
    	 Random rnd = new Random();
    	 int r=0;
    	 for(int i=0;i<1000;i++) {
    		 r = rnd.nextInt(1000);
    	 }
		return r;
	}

	@FXML
    void doUploadImage(ActionEvent event) {
		
	    	FileChooser file = new FileChooser();
	    	file.setTitle("Choose the required file ");
	        Stage stg = (Stage)anchor.getScene().getWindow();
	        show = file.showOpenDialog(stg); 
	         if(show!=null){
	        	 Image img = new Image(show.toURI().toString());
	        	 pic.setImage(img);
	         }
	         
    }
	
	void doFillBranch() {
		comboBranch.getItems().clear();
		try {
	    	pst=con.prepareStatement("select distinct branch from  trainees");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String branches=tableInMem.getString("branch");
				comboBranch.getItems().add(branches);
			}
	    }
	    catch(Exception exp)
	    {
	    	exp.printStackTrace();
	    }
	}
	
	void doFillCollege() {
		comboCollege.getItems().clear();
		try {
	    	pst=con.prepareStatement("select distinct college from  trainees");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String col=tableInMem.getString("college");
				comboCollege.getItems().add(col);
			}
	    }
	    catch(Exception exp)
	    {
	    	exp.printStackTrace();
	    }
	}
	
	void doFillSemester() {
		comboSem.getItems().clear();
		try {
	    	pst=con.prepareStatement("select distinct sem from  trainees");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String semes=tableInMem.getString("sem");
				comboSem.getItems().add(semes);
			}
	    }
	    catch(Exception exp)
	    {
	    	exp.printStackTrace();
	    }
	}
	
	void getBatches () {
    	
		try {
			pst = con.prepareStatement("select distinct Batch from batches ");
			ResultSet batch = pst.executeQuery();
			while(batch.next())
			{
				String batches=batch.getString("Batch");
				comboTech.getItems().add(batches);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    Connection con;
    
    @FXML
    void initialize() {
        con = connectToMySql.doConnect();
        getBatches();
        doFillCollege();
        doFillBranch();
        doFillSemester();
    }

}

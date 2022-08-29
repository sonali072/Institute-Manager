package batches;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class batchMasterViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBatch;

    @FXML
    private ComboBox<String> comboStime;

    @FXML
    private DatePicker sdate;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtSeat;

    @FXML
    private ImageView logo;
    
    PreparedStatement pst;
    
    @FXML
    void doClear(ActionEvent event) {
    	comboBatch.getEditor().setText("");
    	sdate.getEditor().clear(); 
    	comboStime.getEditor().setText("");
    	txtSeat.setText("");
    	txtFee.setText("");
    	doFillBatches();
    }

    void doFillBatches() {
    	comboBatch.getItems().clear();
		try {
	    	pst=con.prepareStatement("select distinct Batch from  batches");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String batch=tableInMem.getString("Batch");
				comboBatch.getItems().add(batch);
			}
	    }
	    catch(Exception exp)
	    {
	    	exp.printStackTrace();
	    }
	}
    
    void doFillTime() {
    	comboStime.getItems().clear();
		try {
	    	pst=con.prepareStatement("select distinct stime from  batches");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String batch=tableInMem.getString("stime");
				comboStime.getItems().add(batch);
			}
	    }
	    catch(Exception exp)
	    {
	    	exp.printStackTrace();
	    }
	}

	@FXML
    void doDelete(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from batches where Batch=?");
			pst.setString(1, comboBatch.getEditor().getText());
			pst.executeUpdate();
			
			System.out.println("Record deleted Successfully!!");
			doFillBatches();
		}
		catch(Exception exp){
			exp.printStackTrace();
		}
    }

    @FXML
    void doSave(ActionEvent event) {
    	try {
    		pst=con.prepareStatement("insert into batches values(?,?,?,?,?,?)");
			pst.setString(1, comboBatch.getEditor().getText());
			LocalDate local= sdate.getValue();
			pst.setDate(2, java.sql.Date.valueOf(local));
			pst.setString(3, comboStime.getEditor().getText());
			pst.setInt(4, Integer.parseInt(txtSeat.getText()));
			pst.setInt(5, 0);
			pst.setInt(6, Integer.parseInt(txtFee.getText()));
			
			//booked seats ??
			pst.executeUpdate();
			System.out.println("Data Saved Successfullyyyyy");
			
			doFillBatches();
			doFillTime();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSearch(ActionEvent event) {
    	try {
			
			pst=con.prepareStatement("select * from  batches where Batch=?");
			pst.setString(1, comboBatch.getEditor().getText());
			ResultSet tableInMem= pst.executeQuery();
			
			boolean jasoos=false;
			while(tableInMem.next()) {
				jasoos=true;
				String batch = tableInMem.getString("Batch");
				Date dos=tableInMem.getDate("sdate");
				String sTime=tableInMem.getString("stime");
				int seats = tableInMem.getInt("tseats");
				int fee = tableInMem.getInt("fee");
				
				comboBatch.getEditor().setText(batch);
				sdate.setValue(dos.toLocalDate());
				comboStime.getEditor().setText(sTime);
				txtSeat.setText(String.valueOf(seats));
				txtFee.setText(String.valueOf(fee));
				
			}
			if(jasoos==false) {
				showMsg("Invalid Batch");
			}
			

		} 
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    void showMsg(String msg) {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Sel. Data");
    	alert.setContentText(msg);
    	alert.show();
    }

	@FXML
    void doUpdate(ActionEvent event) {
		try {
    		pst=con.prepareStatement("update batches set sdate = ?, stime = ?, tseats = ?, booked = ?, Fee = ? where Batch = ?");
			
			LocalDate local= sdate.getValue();
			pst.setDate(1, java.sql.Date.valueOf(local));
			pst.setString(2, comboStime.getEditor().getText());
			pst.setInt(3, Integer.parseInt(txtSeat.getText()));
			pst.setInt(4, 0);
			pst.setInt(5, Integer.parseInt(txtFee.getText()));
			pst.setString(6, comboBatch.getEditor().getText());
			//booked seats ??
			pst.executeUpdate();
			System.out.println("Data Updated Successfullyyyyy");
			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	Connection con;
	
    @FXML
    void initialize() {
    	con = connectToMySQL.doConnect();
    	doFillBatches();
    	doFillTime();
    }

}

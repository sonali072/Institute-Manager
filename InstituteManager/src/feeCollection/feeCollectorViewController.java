package feeCollection;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import admissions.connectToMySql;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class feeCollectorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtBal;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtPaid;

    @FXML
    private TextField txtRecieved;

    @FXML
    private TextField txtTech;

    @FXML
    private TextField txtTid;

    @FXML
    private TextField txtTime;

    PreparedStatement pst; 
    
    @FXML
    void doFillInfo(ActionEvent event) {
    	try {
    		pst = con.prepareStatement("select * from trainees where tid=?");
    		pst.setString(1, txtTid.getText());
    		ResultSet info = pst.executeQuery();
    		//
    		while(info.next()) {
    			txtTech.setText(info.getString("technology"));
    			txtTime.setText(info.getString("stime"));
    			txtFee.setText(info.getString("tfee"));
    			txtPaid.setText(info.getString("advfee"));
    			txtBal.setText(info.getString("bal"));
    			
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    			 e.printStackTrace();
    		}
    }

    @FXML
    void doUpdate(ActionEvent event) {
    	try {
			pst = con.prepareStatement("update trainees set advfee=advfee+?,bal=bal-? where tid = ?");
			pst.setInt(1, Integer.parseInt(txtRecieved.getText()));
			pst.setInt(2, Integer.parseInt(txtRecieved.getText()));
			pst.setString(3, txtTid.getText());
			System.out.println("Updated Successfully");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    Connection con;
    
    @FXML
    void initialize() {
    	con = connectToMySql.doConnect();
        
    }

}

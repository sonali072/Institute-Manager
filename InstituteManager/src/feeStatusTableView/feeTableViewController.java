package feeStatusTableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import admissions.connectToMySql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class feeTableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private CheckBox chkBal;

    @FXML
    private CheckBox chkFullyPaid;

    @FXML
    private ComboBox<String> comboTech;

    @FXML
    private TableView<feeBean> tblView;

    PreparedStatement pst;
    
    ObservableList<feeBean> ary;
    
    @FXML
    void doDeselectBal(ActionEvent event) {
    	chkBal.setSelected(false);
    }

    @FXML
    void doDeselectPaid(ActionEvent event) {
    	chkFullyPaid.setSelected(false) ;
    }

    
    @FXML
    void Doshow(ActionEvent event) {
    	if(chkBal.isSelected()==true) {
    		
    		tblView.setItems(getRecordsBal());
    	}
    	else if(chkFullyPaid.isSelected()==true) {
    		
    		tblView.setItems(getRecordsFullyPaid());
    	}
    }
    
    

    private ObservableList<feeBean> getRecordsBal() {
		// TODO Auto-generated method stub
    	ary = FXCollections.observableArrayList();
     	try {
 			pst = con.prepareStatement("select * from trainees where technology=? and bal>0");
 			pst.setString(1, comboTech.getSelectionModel().getSelectedItem());
 			
 			ResultSet tableInMem = pst.executeQuery();
 	    	while(tableInMem.next()) {
 	    		String tid = tableInMem.getString("tid");
 	    		String tech = tableInMem.getString("technology");
 	    		String time = tableInMem.getString("stime");
 	    		int totalFee = tableInMem.getInt("tfee");
 	    		int recieved = tableInMem.getInt("advfee");
 	    		feeBean obj = new feeBean(tid, tech, time, totalFee, recieved);
 	    		ary.add(obj);
 	    		System.out.println("studentBean [tid=" + tid + ", tech=" + tech + ", time=" + time + ", totalFee="
 				+ totalFee +  ", recieved =" + recieved + "]");
 	    	}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	
		return ary;
	}



	private ObservableList<feeBean> getRecordsFullyPaid() {
		// TODO Auto-generated method stub
		 ary = FXCollections.observableArrayList();
     	try {
 			pst = con.prepareStatement("select * from trainees where technology=? and bal=?");
 			pst.setString(1, comboTech.getSelectionModel().getSelectedItem());
 			pst.setInt(2, 0);
 			ResultSet tableInMem = pst.executeQuery();
 	    	while(tableInMem.next()) {
 	    		String tid = tableInMem.getString("tid");
 	    		String tech = tableInMem.getString("technology");
 	    		String time = tableInMem.getString("stime");
 	    		int totalFee = tableInMem.getInt("tfee");
 	    		int recieved = tableInMem.getInt("advfee");
 	    		feeBean obj = new feeBean(tid, tech, time, totalFee, recieved);
 	    		ary.add(obj);
 	    		System.out.println("studentBean [tid=" + tid + ", tech=" + tech + ", time=" + time + ", totalFee="
 				+ totalFee +  ", recieved =" + recieved + "]");
 	    	} 
     	}catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
		return ary;
	}



	private void doFillTech() {
		comboTech.getItems().clear();
		try {
	    	pst=con.prepareStatement("select distinct technology from  trainees");
			ResultSet tableInMem= pst.executeQuery();
			
			while(tableInMem.next())
			{
				String tech=tableInMem.getString("technology");
				comboTech.getItems().add(tech);
			}
	    }
	    catch(Exception exp)
	    {
	    	exp.printStackTrace();
	    }
	}
    
	private void addColumns() {
		// TODO Auto-generated method stub
		TableColumn<feeBean,String> tidCol = new TableColumn<feeBean,String>("Stedent Id");
		tidCol.setCellValueFactory(new PropertyValueFactory<>("tid"));
		tidCol.setMinWidth(100);
		
		TableColumn<feeBean,String> techCol = new TableColumn<feeBean,String>("Technology");
		techCol.setCellValueFactory(new PropertyValueFactory<>("tech"));
		techCol.setMinWidth(100);
		
		TableColumn<feeBean,String> timeCol = new TableColumn<feeBean,String>("Timings");
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		timeCol.setMinWidth(100);
		
		TableColumn<feeBean,Integer> feeCol = new TableColumn<feeBean,Integer>("Total Fee");
		feeCol.setCellValueFactory(new PropertyValueFactory<>("total"));
		feeCol.setMinWidth(100);
		
		TableColumn<feeBean,Integer> balCol = new TableColumn<feeBean,Integer>("Remaining Balance");
		balCol.setCellValueFactory(new PropertyValueFactory<>("recieved"));
		balCol.setMinWidth(150);
		
		tblView.getColumns().addAll(tidCol,techCol,timeCol,feeCol,balCol);
		
	}
	
    Connection con;
    
    @FXML
    void initialize() {
    	
       con = connectToMySql.doConnect();
       addColumns();
       doFillTech();
    
    }
}

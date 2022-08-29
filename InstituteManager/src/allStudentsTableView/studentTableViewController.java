package allStudentsTableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import batches.connectToMySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class studentTableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBatch;
    
    @FXML
    private ComboBox<String> comboCollege;

    @FXML
    private TableView<studentBean> tblView;

    PreparedStatement pst;
    
    void doAddColumns() {
		// TODO Auto-generated method stub
		TableColumn<studentBean,String> tidCol = new TableColumn<studentBean,String>("Stedent Id");
		tidCol.setCellValueFactory(new PropertyValueFactory<>("tid"));
		tidCol.setMinWidth(100);
		
		TableColumn<studentBean,String> nameCol = new TableColumn<studentBean,String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameCol.setMinWidth(100);
		
		TableColumn<studentBean,String> mobileCol = new TableColumn<studentBean,String>("Mobile");
		mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		mobileCol.setMinWidth(100);
		
		TableColumn<studentBean,String> CollegeCol = new TableColumn<studentBean,String>("College");
		CollegeCol.setCellValueFactory(new PropertyValueFactory<>("college"));
		CollegeCol.setMinWidth(100);
		
		TableColumn<studentBean,String> semCol = new TableColumn<studentBean,String>("Semester");
		semCol.setCellValueFactory(new PropertyValueFactory<>("sem"));
		semCol.setMinWidth(100);
		
		TableColumn<studentBean,String> branchCol = new TableColumn<studentBean,String>("Branch");
		branchCol.setCellValueFactory(new PropertyValueFactory<>("branch"));
		branchCol.setMinWidth(100);
		
		TableColumn<studentBean,String> techCol = new TableColumn<studentBean,String>("Technology");
		techCol.setCellValueFactory(new PropertyValueFactory<>("tech"));
		techCol.setMinWidth(100);
		
		TableColumn<studentBean,String> dateCol = new TableColumn<studentBean,String>("Start Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		dateCol.setMinWidth(100);
		
		TableColumn<studentBean,String> timeCol = new TableColumn<studentBean,String>("Timings");
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		timeCol.setMinWidth(100);
		
		TableColumn<studentBean,Integer> feeCol = new TableColumn<studentBean,Integer>("Total Fee");
		feeCol.setCellValueFactory(new PropertyValueFactory<>("totalFee"));
		feeCol.setMinWidth(100);
		
		TableColumn<studentBean,Integer> advCol = new TableColumn<studentBean,Integer>("Advance Fee");
		advCol.setCellValueFactory(new PropertyValueFactory<>("advFee"));
		advCol.setMinWidth(100);
		
		TableColumn<studentBean,Integer> balCol = new TableColumn<studentBean,Integer>("Remaining Balance");
		balCol.setCellValueFactory(new PropertyValueFactory<>("bal"));
		balCol.setMinWidth(100);
		
		TableColumn<studentBean,String> admnCol = new TableColumn<studentBean,String>("Date of Admission");
		admnCol.setCellValueFactory(new PropertyValueFactory<>("admn"));
		admnCol.setMinWidth(100);
		
		TableColumn<studentBean,String> picCol = new TableColumn<studentBean,String>("PicPath");
		picCol.setCellValueFactory(new PropertyValueFactory<>("picpath"));
		picCol.setMinWidth(100);
		
		tblView.getColumns().addAll(tidCol,nameCol,mobileCol,CollegeCol,semCol,branchCol,techCol,dateCol,timeCol,feeCol,advCol,balCol,picCol);
	}

    
    @FXML
    void doShowBatch(ActionEvent event) {
    	tblView.setItems(getRecordsBatch());
    }
    
    @FXML
    void doShowCollege(ActionEvent event) {
    	tblView.setItems(getRecordsCollege());
    }


     ObservableList<studentBean> getRecordsCollege() {
    	 ObservableList<studentBean> ary = FXCollections.observableArrayList();
     	try {
 			pst = con.prepareStatement("select * from trainees where college=?");
 			pst.setString(1, comboCollege.getSelectionModel().getSelectedItem());
 			ResultSet tableInMem = pst.executeQuery();
 	    	while(tableInMem.next()) {
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
 	    		int bal = tableInMem.getInt("bal");
 	    		String admn = tableInMem.getString("dofadmn");
 	    		String picpath = tableInMem.getString("picpath");
 	    		studentBean obj = new studentBean(tid, name, mobile, college, sem, branch, tech, date, time, totalFee, advFee, bal, admn, picpath);
 	    		ary.add(obj);
 	    		System.out.println("studentBean [tid=" + tid + ", name=" + name + ", mobile=" + mobile + ", college=" + college + ", sem="
 				+ sem + ", branch=" + branch + ", tech=" + tech + ", date=" + date + ", time=" + time + ", totalFee="
 				+ totalFee + ", advFee=" + advFee + ", bal=" + bal + ", date of admission=" + admn + ", picpath=" + picpath + "]");
 	    	}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     	
 		return ary;
	}


	ObservableList<studentBean> getRecordsBatch() {
		// TODO Auto-generated method stub
    	ObservableList<studentBean> ary = FXCollections.observableArrayList();
    	try {
			pst = con.prepareStatement("select * from trainees where technology=?");
			pst.setString(1, comboBatch.getSelectionModel().getSelectedItem());
			ResultSet tableInMem = pst.executeQuery();
	    	while(tableInMem.next()) {
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
	    		int bal = tableInMem.getInt("bal");
	    		String admn = tableInMem.getString("dofadmn");
	    		String picpath = tableInMem.getString("picpath");
	    		studentBean obj = new studentBean(tid, name, mobile, college, sem, branch, tech, date, time, totalFee, advFee, bal, admn, picpath);
	    		ary.add(obj);
	    		System.out.println("studentBean [tid=" + tid + ", name=" + name + ", mobile=" + mobile + ", college=" + college + ", sem="
				+ sem + ", branch=" + branch + ", tech=" + tech + ", date=" + date + ", time=" + time + ", totalFee="
				+ totalFee + ", advFee=" + advFee + ", bal=" + bal + ", date of admission=" + admn + ", picpath=" + picpath + "]");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return ary;
	}


	@FXML
    void doShowAll(ActionEvent event) {
		tblView.setItems(getAllRecords());
    }

    ObservableList<studentBean> getAllRecords() {
		// TODO Auto-generated method stub
    	ObservableList<studentBean> ary = FXCollections.observableArrayList();
    	try {
			pst = con.prepareStatement("select * from trainees");
			ResultSet tableInMem = pst.executeQuery();
	    	while(tableInMem.next()) {
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
	    		int bal = tableInMem.getInt("bal");
	    		String admn = tableInMem.getString("dofadmn");
	    		String picpath = tableInMem.getString("picpath");
	    		studentBean obj = new studentBean(tid, name, mobile, college, sem, branch, tech, date, time, totalFee, advFee, bal, admn, picpath);
	    		ary.add(obj);
	    		System.out.println("studentBean [tid=" + tid + ", name=" + name + ", mobile=" + mobile + ", college=" + college + ", sem="
				+ sem + ", branch=" + branch + ", tech=" + tech + ", date=" + date + ", time=" + time + ", totalFee="
				+ totalFee + ", advFee=" + advFee + ", bal=" + bal + ", date of admission=" + admn + ", picpath=" + picpath + "]");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return ary;
	}

    private void doFillBatches() {
		// TODO Auto-generated method stub
    	try {
			pst = con.prepareStatement("select distinct technology from trainees ");
			ResultSet batch = pst.executeQuery();
			while(batch.next())
			{
				String batches=batch.getString("technology");
				comboBatch.getItems().add(batches);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    private void doFillCollege() {
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
    
	Connection con;
    
    @FXML
    void initialize() {
        con = connectToMySQL.doConnect();
        doAddColumns();
        doFillBatches();
        doFillCollege();
    }
}

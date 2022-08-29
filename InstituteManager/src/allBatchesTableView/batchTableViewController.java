package allBatchesTableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import batches.connectToMySQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class batchTableViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<batchBean> tblView;

    @FXML
    void doShow(ActionEvent event) {
    	tblView.setItems(getAllRecords());
    }

    private void doAddCol() {
		// TODO Auto-generated method stub
		TableColumn<batchBean,String> batchCol = new TableColumn<batchBean,String>("Batch");
		batchCol.setCellValueFactory(new PropertyValueFactory<>("batch"));
		batchCol.setMinWidth(100);
		
		TableColumn<batchBean,String> dateCol = new TableColumn<batchBean,String>("Start Date");
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		dateCol.setMinWidth(100);
		
		TableColumn<batchBean,String> timeCol = new TableColumn<batchBean,String>("Timings");
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		timeCol.setMinWidth(70);
		
		TableColumn<batchBean,Integer> seatCol = new TableColumn<batchBean,Integer>("Seats");
		seatCol.setCellValueFactory(new PropertyValueFactory<>("seats"));
		seatCol.setMinWidth(60);
		
		TableColumn<batchBean,Integer> bookCol = new TableColumn<batchBean,Integer>("Booked Seats");
		bookCol.setCellValueFactory(new PropertyValueFactory<>("book"));
		bookCol.setMinWidth(100);
		
		TableColumn<batchBean,String> feeCol = new TableColumn<batchBean,String>("Fee");
		feeCol.setCellValueFactory(new PropertyValueFactory<>("fee"));
		feeCol.setMinWidth(100);
		
		tblView.getColumns().addAll(batchCol,dateCol,timeCol,seatCol,bookCol,feeCol);
		
	}
    
    ObservableList<batchBean> getAllRecords() {
    	ObservableList<batchBean> ary = FXCollections.observableArrayList();
    	try {
			PreparedStatement pst = con.prepareStatement("select * from batches");
			ResultSet tableInMem = pst.executeQuery();
			
			while(tableInMem.next()) {
				String batche = tableInMem.getString("Batch");
				Date stdate = tableInMem.getDate("sdate");
				String sttime = tableInMem.getString("stime");
				int totalseat = tableInMem.getInt("tseats");
				int booked = tableInMem.getInt("booked");
				int totalfee = tableInMem.getInt("fee");
				batchBean obj = new batchBean(batche,stdate.toString(),sttime,totalseat,booked,totalfee);
				ary.add(obj);
				System.out.println(batche+" "+stdate+" "+sttime+" "+totalseat+" "+booked+" "+totalfee);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ary;
    }
    Connection con;
    @FXML
    void initialize() {
        con = connectToMySQL.doConnect();
        doAddCol();
    }
	
}

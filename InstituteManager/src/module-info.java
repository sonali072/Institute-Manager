module InstituteManager {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens batches to javafx.graphics, javafx.fxml;
	opens admissions to javafx.graphics, javafx.fxml;
	opens allBatchesTableView to javafx.graphics, javafx.fxml,javafx.base;
	opens allStudentsTableView to javafx.graphics, javafx.fxml,javafx.base;
	opens feeCollection to javafx.graphics, javafx.fxml;
	opens feeStatusTableView to javafx.graphics, javafx.fxml,javafx.base;
	opens dashboard to javafx.graphics, javafx.fxml;
	opens login to javafx.graphics, javafx.fxml;
}

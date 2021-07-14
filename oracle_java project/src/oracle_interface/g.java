package oracle_interface;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class g implements Initializable {
	
	private Connection cone;
	
	private ObservableList<String> dbtypelist = FXCollections.observableArrayList("MongoDB","OracleDB","Mysql");
	
	public ComboBox<String> cbx;
	
	public TextField txt;
	
	public Button btn;
	
	public TabPane tp;

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		// TODO Auto-generated method stub
		
		cbx.setItems(dbtypelist);
		cbx.setValue(dbtypelist.get(1));
		
		txt.setText("Hello There...");
		
	}
	
	public void connectOnClick() { connect(); }
	public void connectOnReturn(javafx.scene.input.KeyEvent e) {
		if(e.getCode().equals(java.awt.event.KeyEvent.VK_ENTER)) {
			connect();
		}
	}
	
	private void connect() {
		String url;
		if(txt.getText().isEmpty()) {
			new Alert(Alert.AlertType.ERROR, "Type something...").showAndWait();
		}
	}

}

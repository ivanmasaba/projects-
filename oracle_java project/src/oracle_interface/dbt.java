package oracle_interface;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class dbt extends Application {
	
	TableView<Person> table = new TableView<Person>();
	
	ObservableList<Person> data = FXCollections.observableArrayList(
			new Person(1, "jacob", "12345"),
			new Person(2, "henry", "213")
			);
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	public void start(Stage stage) {
		Label l = new Label("Address Book");
		l.setFont(new Font("Arial", 20));
		
		
		TableColumn<Person, Integer> iedd = new TableColumn("USER ID");
		iedd.setMaxWidth(100);
		iedd.setCellValueFactory(
				new PropertyValueFactory<Person, Integer>("iid")
				);
		
		TableColumn<Person, String> nem = new TableColumn("USER NAME");
		nem.setMaxWidth(100);
		nem.setCellValueFactory(
				new PropertyValueFactory<Person, String>("name")
				);
		
		
		TableColumn<Person, String> pa = new TableColumn("PASSWORD");
		pa.setMaxWidth(100);
		pa.setCellValueFactory(
				new PropertyValueFactory<Person, String>("pass")
				);
		
		
		table.setItems(data);
		table.getColumns().addAll(iedd, nem, pa);
		
		VBox box = new VBox();
		box.setSpacing(5);
		box.setPadding(new Insets(10, 0, 0, 10));
		box.getChildren().addAll(l, table);
		
		Scene s = new Scene(new Group());
		((Group) s.getRoot()).getChildren().addAll(box);
		
		stage.setTitle("Table view sample");
		stage.setWidth(300);
		stage.setHeight(500);
		stage.setScene(s);
		stage.show();
		
		
		
		
	}
	
	
	
	
	
	
	public class Person{
	
		SimpleStringProperty name;
		SimpleStringProperty pass;
		SimpleIntegerProperty iid;
		
	public Person(int ied, String nam, String pas) {
		this.iid = new SimpleIntegerProperty(ied);
		this.name = new SimpleStringProperty(nam);
		this.pass = new SimpleStringProperty(pas);
	}
	
	public Integer getIid() {
		return iid.get();
	}
	
	public void setIid(int nnn) {
		iid.set(nnn);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String nn) {
		name.set(nn);
	}
	
	public String getPass() {
		return pass.get();
	}
	
	public void setPass(String pp) {
		pass.set(pp);
	}
	}

}

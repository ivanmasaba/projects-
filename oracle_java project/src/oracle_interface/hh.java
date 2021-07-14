package oracle_interface;


import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import oracle_interface.dbt.Person;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class hh extends Application {
	
	TableView<Person> table = new TableView<Person>();
	ObservableList<Person> data = FXCollections.observableArrayList();
	
	Connection con = null;
	GridPane gp = new GridPane();
	GridPane gp2 = new GridPane();
	GridPane gp3 = new GridPane();
	GridPane gp4 = new GridPane();
	
	int i = 3;	
	Scene s, s2, s3, s4;
	
	public static void main(String[] args) {
		launch(args);
	} 
      
	
	public void start(Stage primarystage) throws Exception {
		
		// connect to database
		
		con = connect.getConnection();
		
   	primarystage.setTitle("DATABASE RECORDS");
		
		// scene 1 DISPLAY RECORDS
		
		Button  b = new Button("DISPLAY RECORDS");
		b.setTranslateX(10);
	    b.setOnAction(e -> 
	        primarystage.setScene(s2));
		
	  Button  b1 = new Button("ADD RECORDS");
	  b1.setTranslateX(10);
      b1.setOnAction(e -> 
        primarystage.setScene(s2));
      
      Button  b2 = new Button("UPDATE RECORDS");
      b2.setTranslateX(10);
      b2.setOnAction(e -> 
        primarystage.setScene(s3));
      
      Button  b3 = new Button("DELETE RECORDS");
      b3.setTranslateX(10);
      b3.setOnAction(e -> 
        primarystage.setScene(s4));		
		
      Label l1 = new Label("USER ID");
      l1.setTranslateX(10);
      Label l2 = new Label("NAME");
      l2.setTranslateX(10);
      Label l3 = new Label("PASSWORD");
      l2.setTranslateX(10);
  	Button bb = new Button("SHOW RECORDS");
  	//if text to be on button is very long use .setWrapText()	
  		bb.setWrapText(true);
  		bb.setTranslateX(10);
  		bb.setTranslateY(10);
  		//make button do something		
		
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
		

		table.getColumns().addAll(iedd, nem, pa);					

		table.setMaxWidth(300);
		table.refresh();
  		bb.setOnAction(new EventHandler<ActionEvent>() {
  			public void handle(ActionEvent arg0) {
				try {
					
				
					
					Statement st = con.createStatement();			
					ResultSet rs = st.executeQuery("SELECT name, pass, user_id FROM users");

					while(rs.next()) {
					
					String n = rs.getString("name");
					String n1 = rs.getString("pass");
					int u = rs.getInt("user_id");				
					
					data.add(new Person(u, n, n1));
					
					}
										
					table.setItems(data);					

					rs.close();
				
				//	bb.setDisable(true);;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
  				
  				
  				
  			}
  		});
  		
  		
       //  gp.setGridLinesVisible(true);//display the grid lines
  				gp.setHgap(10);//horizontal gap between nodes
  				gp.setVgap(10);//vertical gap between nodes
  				
  				gp.addRow(0, b, b1, b2, b3);
  				gp.addRow(1, bb);
  				gp.addRow(2, table);
  				gp.setPadding(new javafx.geometry.Insets(50, 0, 0, 10));
  				 s = new Scene(gp, 700, 400);
  				primarystage.setScene(s);
  				

  				// scene 2  ADD RECORDS
    			  Button  c1 = new Button("DISPLAY RECORDS");
    			  c1.setTranslateX(10);
    		      c1.setOnAction(e -> 
    		        primarystage.setScene(s));	
    		      
    		      Button  c2 = new Button("ADD RECORDS");
    			  c2.setTranslateX(10);
    		      c2.setOnAction(e -> 
    		        primarystage.setScene(s2));
    		      
    		      Button  c3 = new Button("UPDATE RECORDS");
    		      c3.setTranslateX(10);
    		      c3.setOnAction(e -> 
    		        primarystage.setScene(s3));
    		      
    		      Button  c4 = new Button("DELETE RECORDS");
    		      c4.setTranslateX(10);
    		      c4.setOnAction(e -> 
    		      primarystage.setScene(s4));
    		      
    		      Label a = new Label("USER ID");
    		      a.setTranslateX(20);
    		      a.setTranslateY(30);
    		      Label z = new Label("NAME");
    		      z.setTranslateX(20);
    		      z.setTranslateY(30);
    		      Label c = new Label("PASSWORD");
    		      c.setTranslateX(20);
    		      c.setTranslateY(30);
    		      
    		      Label ax = new Label("WAITING TO ADD USER...");
    		      ax.setTranslateX(20);
    		      ax.setTranslateY(30);
    		      
    		      TextField t1 = new TextField();
    		      t1.setMaxWidth(30);
    		      t1.setTranslateY(30);
    		      TextField t2 = new TextField();
    		      t2.setTranslateY(30);
    		      PasswordField p = new PasswordField();
    		      p.setTranslateY(30);
    		      
    		      Button bt = new Button("ADD USER");
    		      bt.setTranslateX(40);
    		      bt.setTranslateY(30);
    		      
    		      bt.setOnAction(new EventHandler<ActionEvent>() {
    		  			public void handle(ActionEvent arg0) {
    		  				
    		  				if(t1.getText().isEmpty()) {
    		  					new Alert(Alert.AlertType.ERROR, " Enter USER ID ").showAndWait();
    		  				}else if(t2.getText().isEmpty()) {
    		  					new Alert(Alert.AlertType.ERROR, " Enter NAME ").showAndWait();
    		  				}else if(p.getText().isEmpty()) {
    		  					new Alert(Alert.AlertType.ERROR, " Enter PASSWORD ").showAndWait();
    		  				}else {
    		  			
    						try {
    							
    							int iid = Integer.parseInt(t1.getText());
    							String nn = t2.getText();
    							String pp = p.getText();
    							
    							PreparedStatement ppt = con.prepareStatement("INSERT INTO users VALUES(?, ?, ?)");
    							ppt.setString(1, nn);
    							ppt.setString(2, pp);
    							ppt.setInt(3, iid);
    							
    						    ppt.execute();
    							
    							ppt.close();
    							
    							ax.setText(" USER " + nn + " HAS BEEN ADDED.. ");
    							t1.setText("");
    							t2.setText("");
    							p.setText("");
    							
    						} catch (SQLException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    		  				
    		  			}
    		  				
    		  			}
    		  		});
    		      
    		      //  gp.setGridLinesVisible(true);//display the grid lines
    				gp2.setHgap(10);//horizontal gap between nodes
    				gp2.setVgap(10);//vertical gap between nodes
    				
    		    gp2.addRow(0,c1, c2, c3, c4);
    		    gp2.addRow(1, a, t1);
    		    gp2.addRow(2, z, t2);
    		    gp2.addRow(3, c, p);
    		    gp2.addRow(4, bt);
    		    gp2.addRow(5, ax);
  			
  			s2 = new Scene(gp2, 600, 230);
  			primarystage.setScene(s2);
  			
  				
  			// scene 3  UPDATE RECORDS
  			  Button  a1 = new Button("DISPLAY RECORDS");
  			  a1.setTranslateX(10);
  			  a1.setOnAction(e -> 
  		      primarystage.setScene(s));	
  				
  			  Button  a2 = new Button("ADD RECORDS");
  			  a2.setTranslateX(10);
  			  a2.setOnAction(e -> 
  		      primarystage.setScene(s2));
  		      
  		      Button  a3 = new Button("UPDATE RECORDS");
		      a3.setTranslateX(10);
		      a3.setOnAction(e -> 
		      primarystage.setScene(s3));
  		      
  		      Button  a4 = new Button("DELETE RECORDS");
  		      a4.setTranslateX(10);
  		      a4.setOnAction(e -> 
  		      primarystage.setScene(s4));
  		      
  		      Label a11 = new Label("OLD USER ID");
		      a11.setTranslateX(20);
		      a11.setTranslateY(30);
		      Label z1 = new Label("OLD NAME");
		      z1.setTranslateX(20);
		      z1.setTranslateY(30);
		      Label c11 = new Label("OLD PASSWORD");
		      c11.setTranslateX(20);
		      c11.setTranslateY(30);
		      
		     
		      Label z11 = new Label("NEW NAME");
		      z11.setTranslateX(20);
		      z11.setTranslateY(30);
		      Label c111 = new Label("NEW PASSWORD");
		      c111.setTranslateX(20);
		      c111.setTranslateY(30);
		      
		      Label ax1 = new Label("WAITING TO UPDATE USER...");
		      ax1.setMaxWidth(150);
		      ax1.setTranslateX(20);
		      ax1.setTranslateY(30);
		      
		      TextField t11 = new TextField();
		      t11.setMaxWidth(30);
		      t11.setTranslateY(30);
		      TextField t22 = new TextField();
		      t22.setTranslateY(30);
		      PasswordField p1 = new PasswordField();
		      p1.setTranslateY(30);
		      
		     
		      TextField t222 = new TextField();
		      t222.setTranslateY(30);
		      PasswordField p11 = new PasswordField();
		      p11.setTranslateY(30);
		      
		      Button bt1 = new Button("UPDATE USER");
		      bt1.setTranslateX(80);
		      bt1.setTranslateY(30);
		      
		      bt1.setOnAction(new EventHandler<ActionEvent>() {
		  			public void handle(ActionEvent arg0) {
		  			
						try {
							
							int iid11 = Integer.parseInt(t11.getText());
							String nn1 = t222.getText();
							String pp1 = p11.getText();
							
							PreparedStatement ppt1 = con.prepareStatement("UPDATE users SET name=?, pass=? WHERE user_id=?");
							ppt1.setString(1, nn1);
							ppt1.setString(2, pp1);
							ppt1.setInt(3, iid11);
							
						    ppt1.executeUpdate();
							
							ppt1.close();
							
							ax1.setText(" USER " + nn1 + " UPDATED.. ");
							t11.setText("");
							t22.setText("");
							p1.setText("");
							
							t222.setText("");
							p11.setText("");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		  				
		  				
		  				
		  			}
		  		});
  		      
  		    //  gp.setGridLinesVisible(true);//display the grid lines
			  gp3.setHgap(10);//horizontal gap between nodes
			  gp3.setVgap(10);//vertical gap between nodes
				
  		      gp3.addRow(0, a1, a2, a3, a4);
  		      gp3.addRow(1, a11, t11);
  		      gp3.addRow(2, z1, t22, z11, t222);
  		      gp3.addRow(3, c11, p1, c111, p11);
  		      gp3.addRow(4, bt1);
  	          gp3.addRow(5,ax1);
			
			  s3 = new Scene(gp3, 600, 280);
			  primarystage.setScene(s3);
			
  		      
  		 // scene 4  DISPLAY RECORDS
  		      Button  d1 = new Button("DISPLAY RECORDS");
			  d1.setTranslateX(10);
		      d1.setOnAction(e -> 
		      primarystage.setScene(s));
  			
  			  Button  d2 = new Button("ADD RECORDS");
  			  d2.setTranslateX(10);
  		      d2.setOnAction(e -> 
  		        primarystage.setScene(s2));
  		      
  		      Button  d3 = new Button("UPDATE RECORDS");
  		      d3.setTranslateX(10);
  		      d3.setOnAction(e -> 
  		        primarystage.setScene(s3));
  		      
  		      Button  d4 = new Button("DELETE RECORDS");
		      d4.setTranslateX(10);
		      d4.setOnAction(e -> 
		      primarystage.setScene(s4));
  		      
  		      
		      Label az = new Label("USERS ID TO BE DELETED");
		      az.setTranslateX(20);
		      az.setTranslateY(30);
		      
		      Label aax = new Label("WAITING TO DELETE USER...");
		      aax.setTranslateX(20);
		      aax.setTranslateY(30);
		      
		      TextField ta1 = new TextField();
		      ta1.setMaxWidth(30);
		      ta1.setTranslateY(30);
		      
		      Button bat = new Button("DELETE USER");
		      bat.setTranslateX(40);
		      bat.setTranslateY(30);
		      
		      bat.setOnAction(new EventHandler<ActionEvent>() {
		  			public void handle(ActionEvent arg0) {
		  			
						try {
							
							int iid1 = Integer.parseInt(ta1.getText());
							
							Statement stt = con.createStatement();
							ResultSet r = stt.executeQuery("SELECT name FROM users WHERE user_id=" + iid1);
							while(r.next()) {
							String na = r.getString("name");
							aax.setText(" USER " + na + " HAS BEEN DELETED.. ");
							}
							PreparedStatement pptx = con.prepareStatement("DELETE FROM users WHERE user_id=?");
							pptx.setInt(1, iid1);
							
						    pptx.executeUpdate();
							
							pptx.close();
							
							
							ta1.setText("");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		  				
		  				
		  				
		  			}
		  		});
		      
		      
  		    //  gp.setGridLinesVisible(true);//display the grid lines
				gp4.setHgap(10);//horizontal gap between nodes
				gp4.setVgap(10);//vertical gap between nodes
				
  		       gp4.addRow(0,d1, d2, d3, d4);
  		       gp4.addRow(1, az, ta1);
  		       gp4.addRow(2, bat);
  		       gp4.addRow(3, aax);
				
				s4 = new Scene(gp4, 600, 240);
				primarystage.setScene(s4);
				primarystage.show();
				
				
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

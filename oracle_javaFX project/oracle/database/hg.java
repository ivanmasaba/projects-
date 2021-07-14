package database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class hg extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	} 
      
		
	Scene s1, s2;
	
	public void start(Stage primarystage) {
    
		
		primarystage.setTitle("Scene switching");
		
		// scene 1
		Label l1 = new Label("  This is first scene");
		
		
		
	  Button  b1 = new Button("Go to scene 2");
      b1.setOnAction(e -> 
        primarystage.setScene(s2));
      
      
  	Button bb = new Button("display database record");
  	//if text to be on button is very long use .setWrapText()	
  		bb.setWrapText(true);
  		//make button do something
  		bb.setOnAction(new EventHandler<ActionEvent>() {
  			public void handle(ActionEvent arg0) {
  				
  				try {
  					
  					Connection conn = connect.getConnection();
  					

					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT name FROM users WHERE user_id=1 ");
															
					while(rs.next()) {
					String name = rs.getString("name");
	  				l1.setText(name);
					}
					st.close();
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
  				
  			}
  		});
      
      
      HBox hb = new HBox();
      hb.setSpacing(20);
      hb.getChildren().addAll(l1, b1, bb);
      s1 = new Scene(hb, 400, 100);
      
   // scene 2
   		Label l2 = new Label("  This is second scene");
   		
   		
   	  Button  b2 = new Button("Go to scene 1");
         b2.setOnAction(e -> 
           primarystage.setScene(s1));
         
         HBox hb1 = new HBox();
         hb1.setSpacing(20);         
         hb1.getChildren().addAll(l2, b2);
         
         s2 = new Scene(hb1, 300, 100);
      
      
         primarystage.setScene(s1);
         primarystage.show();
         
	}

}


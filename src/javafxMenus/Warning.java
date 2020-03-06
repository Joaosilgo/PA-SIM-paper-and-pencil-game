/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxMenus;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import user.Players;
import user.TypePlayer;
import user.User;

/**
 *
 * @author João
 */
public class Warning extends StackPane {
    
      private ImageView background;

 


    public Warning(String txt) {
        window(txt);
    }
    
    private void window(String txt)
    {
        Image image = new Image(getClass().getResourceAsStream("warning.png"));
        background = new ImageView(image);
        background.setFitHeight(150);
        background.setFitWidth(300);
        
        
       StackPane root = new StackPane();
        VBox inf = new VBox();
        inf.setAlignment(Pos.CENTER);
        inf.getChildren().add( new Text(txt) );
        
        root.getChildren().addAll(background,inf);
        
        inf.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        
        //stylesheet and css selectors
        root.getStylesheets().addAll(this.getClass().getResource("/javafxgraphs/ui/resources/style.css").toExternalForm());
        root.setId("Warning");
      
        Scene scene = new Scene(root, 290, 140);
        Stage primaryStage = new Stage();
        
         primaryStage.setTitle("AVISO!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
   
    
    
    
}

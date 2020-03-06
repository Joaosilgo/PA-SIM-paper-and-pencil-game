/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxMenus;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import user.Players;
import user.User;

/**
 *
 * @author João
 */
public class DifficultyMenuPC extends StackPane  {
    
      private ImageView background;

    private Label labelTitle;
   
    private Button btn1;
    private Button btn2;
    
      private Button exit;

    public DifficultyMenuPC(Players players, User user1, User user2) {
         window(players, user1, user2);
    }

    private void window(Players players,User user1, User user2) {
        
         Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);
      this.labelTitle = new Label("DIFFICULTY");
        labelTitle.setFont(new Font("SanSerif", 30));
                
                
         btn1 = new Button("NORMAL");
         
          btn1.setOnAction(
                (ActionEvent event) -> {

                    btn1.getScene().setRoot(new  GamePlayPcNormal( players , user1,  user2));
               }
        );
         
        
         
         
         
         btn2 = new Button("HARD");
           btn2.setOnAction(
                (ActionEvent event) -> {

                    btn2.getScene().setRoot(new  GamePlayPcNormal( players , user1,  user2));
               }
        );
         
     Image imageExit = new Image(getClass().getResourceAsStream("exit2.png"));
       ImageView exitBtn = new ImageView(imageExit);
       exitBtn.setFitHeight(40);
        exitBtn.setFitWidth(40);
        exit = new Button("",exitBtn);
       exit.setShape(new Circle(2));
        exit.setOnAction(
                (ActionEvent event) -> {

                    exit.getScene().setRoot(new MenuTypeOfGame( players));
               }
        );

        
        VBox all = new VBox();
        
        all.getChildren().addAll(labelTitle,btn1,btn2,exit);
        all.setSpacing(30);
        all.setAlignment(Pos.CENTER);
        
        this.getChildren().addAll(background,all);
        
    }
    
    
}

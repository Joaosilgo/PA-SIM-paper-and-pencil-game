/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxMenus;

import DAOPattern.AutenticationDAOFile;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import user.Players;
import user.TypePlayer;
import user.User;

/**
 *
 * @author João
 */
public class MenuAddPlayer extends StackPane {

    private ImageView background;
    
   private  AutenticationDAOFile registo;

    private Label labelTitle;
    private Label label1;
    private Label label2;

    private HBox hbox1;
    private HBox hbox2;
    private HBox hbox3;

    private VBox all;

    private TextField textField1;
    private PasswordField textField2;

    private Button retroceder;
    private Button add;

    public MenuAddPlayer(Players player) {
        registo = new AutenticationDAOFile();
        window(player);
    }

    private void window(Players player) {

        this.labelTitle = new Label("ADD PLAYER");
        labelTitle.setFont(new Font("SanSerif", 30));

        Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);

        this.label1 = new Label("Username: ");
        textField1 = new TextField();
        hbox1 = new HBox();
        hbox1.getChildren().addAll(label1, textField1);

        this.label2 = new Label("Password: ");
        textField2 = new PasswordField();
        //textField2.setPrefColumnCount(8);
        textField2.setAccessibleHelp("8 characters");
        
        hbox2 = new HBox();
        hbox2.getChildren().addAll(label2, textField2);

        Image ImageRetroceder = new Image(getClass().getResourceAsStream("retroceder.png"));
        ImageView retroc = new ImageView(ImageRetroceder);
        retroc.setFitHeight(40);
        retroc.setFitWidth(40);
        retroceder = new Button("", retroc);

        retroceder.setOnAction(
                (ActionEvent event) -> {

                    retroceder.getScene().setRoot(new MenuTypeOfGame(player));

                }
        );
        
        
        Image ImageAdd = new Image(getClass().getResourceAsStream("confirm.png"));
       ImageView addUser = new ImageView(ImageAdd);
         addUser.setFitHeight(40);
        addUser.setFitWidth(40);
        add = new Button("",addUser);
        
        
         add.setOnAction(
                (ActionEvent event) -> {
                    
                    
                    if(textField1.getText()!=null && textField2.getText()!=null )
                    {
                        User userAdd = new User(textField1.getText(),textField2.getText(),TypePlayer.HUMAN);
                        player.addPlayer(userAdd);
                        registo.saveUser(userAdd);
                        
                        add.getScene().setRoot(new choosePlayerHuman(player));
                    }
                    else
                    {
                         Warning aviso = new Warning("ERRO AO INSERIR JOGADOR ");
                        System.out.println("");
                    }

                    

                }
        );
        
        
        
        
        
        
        hbox3= new HBox();
        hbox3.getChildren().addAll(retroceder,add);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.setSpacing(15);
        all = new VBox();
        all.setSpacing(15);
        all.getChildren().addAll(labelTitle, hbox1, hbox2, hbox3);
        all.setAlignment(Pos.CENTER);
        
        this.getChildren().addAll(background, all);

        //String username, String password, TypePlayer typePlayer
    }

}

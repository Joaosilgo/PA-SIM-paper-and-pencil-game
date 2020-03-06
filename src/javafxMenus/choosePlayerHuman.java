/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxMenus;

import Game.SimGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.ui.GraphDraw;
import user.Players;
import user.TypePlayer;
import user.User;

/**
 *
 * @author João
 */
public class choosePlayerHuman extends StackPane {

    private ImageView background;

    private Label label1;
    private Label label2;
    private Label label3;

    private ComboBox comboBox1;
    private ComboBox comboBox2;

    private PasswordField textField1;
    private PasswordField textField2;

    private HBox hbox1;
    private HBox hbox2;

    private Button start;
    private Button retroceder;

    private Players players;
    private SimGame game;

    public choosePlayerHuman(Players players) {

        Window(players);
    }

    public void Window(Players players) {
        this.label1 = new Label("HUMAN  VS  HUMAN");
        label1.setFont(new Font("SanSerif", 30));

        Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);

        // players = new Players();// criar no main e ir passando por argumentos
        // ObservableList<User> listaPessoas = FXCollections.observableArrayList(players.getPlayersList());
        label2 = new Label("Player 1");
        comboBox1 = new ComboBox();
        comboBox1.setPromptText("Player 1");
        players.getPlayersList().forEach((item) -> {
            comboBox1.getItems().add(item.getUsername());
        }); // comboBox1.getItems().addAll(players.getPlayersListName());
        textField1 = new PasswordField();
        Label pass1 = new Label("Password");

        hbox1 = new HBox();
        hbox1.getChildren().addAll(comboBox1, pass1, textField1);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);

        label3 = new Label("Player 2");
        comboBox2 = new ComboBox();
        comboBox2.setPromptText("Player 2");
        players.getPlayersList().forEach((item) -> {
            comboBox2.getItems().add(item.getUsername());
        });
        hbox2 = new HBox();
        textField2 = new PasswordField();
        Label pass2 = new Label("Password");
        hbox2.getChildren().addAll(comboBox2, pass2, textField2);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setSpacing(10);

        Image Imageconfirm = new Image(getClass().getResourceAsStream("OK.png"));
        ImageView confirm = new ImageView(Imageconfirm);
        confirm.setFitHeight(20);
        confirm.setFitWidth(20);
        start = new Button(" ", confirm);

        start.setOnAction(
                (ActionEvent event) -> {

                    if (comboBox1.getValue().equals(comboBox2.getValue())) {
                        System.out.println("Escolher difrentes players");
                        Warning aviso = new Warning("Escolher difrentes players");
                        //lançar uma box com erro
                    } else {

                        User user1 = players.getPlayer(comboBox1.getValue().toString());
                        User user2 = players.getPlayer(comboBox2.getValue().toString());
                        System.out.println("Player 1 : " + comboBox1.getValue().toString());
                        System.out.println("Player 2 : " + comboBox2.getValue().toString());
                        if (user1.getPassword().equals(textField1.getText())) {
                            if (user2.getPassword().equals(textField2.getText())) {
                                start.getScene().setRoot(new GamePlay(players, user1, user2));
                            } else {
                                System.out.println("Password Player 2 Incorreta");
                                Warning aviso = new Warning("Password Player 1 Incorreta");
                            }
                        } else {
                            System.out.println("Password Player 1 Incorreta");
                            Warning aviso = new Warning("Password Player 1 Incorreta");
                        }
                        //begin 
                        //  BorderPane root = new BorderPane();

                        //  start.getScene().setRoot(new AutenticationMenu( players));
                        //AutenticationMenu(Players player)
                        /* // inicio     
                          this.game= new SimGame(user1,user2);
                    //start.getScene().setRoot();
                             Stage primaryStage = new Stage();
                      BorderPane root = new BorderPane();
       //game.draw();
                     GraphDraw<Vertice, Aresta> draw = game.draw();
        
        HBox empty = new HBox();
        empty.setAlignment(Pos.CENTER);
        ComboBox comboBox= new ComboBox() ;
       // comboBox.setAccessibleText("ComboBox");
         //players = new Players();
        Label labelPlayerAtual = new Label("Player :"+ game.getActualPlayer());
       comboBox.setPromptText("MOVES");
       players.getPlayersList().forEach((item) -> {
           comboBox.getItems().add(item.getUsername());
                        }); // System.out.println( comboBox.getValue());
                        //comboBox.getItems().remove();
        
       
       
        empty.getChildren().addAll( comboBox );
        
        root.setCenter(draw);
        root.setTop(empty);
        
        //stylesheet and css selectors
        root.getStylesheets().addAll(this.getClass().getResource("/javafxgraphs/ui/resources/style.css").toExternalForm());
        root.setId("pane");
      
        Scene scene = new Scene(root, 600, 600);
          
        primaryStage.setTitle("Graph!");
        primaryStage.setScene(scene);
        primaryStage.show();
                         *///fimm
// start.getScene().setRoot(new GamePlay( players, user1,  user2));
                    }

                });

        Image ImageRetroceder = new Image(getClass().getResourceAsStream("retroceder.png"));
        ImageView retroc = new ImageView(ImageRetroceder);
        retroc.setFitHeight(20);
        retroc.setFitWidth(20);
        retroceder = new Button("", retroc);

        retroceder.setOnAction(
                (ActionEvent event) -> {

                    retroceder.getScene().setRoot(new MenuTypeOfGame(players));

                }
        );

        VBox all = new VBox();
        all.setAlignment(Pos.CENTER);
        all.setSpacing(15);
        HBox buttons = new HBox();
        buttons.getChildren().addAll(retroceder, start);
        buttons.setSpacing(25);
        buttons.setAlignment(Pos.CENTER);

        all.getChildren().addAll(label1, label2, hbox1, label3, hbox2, buttons);

        this.getChildren().addAll(background, all);

    }
}

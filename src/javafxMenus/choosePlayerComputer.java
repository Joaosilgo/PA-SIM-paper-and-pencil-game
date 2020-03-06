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
public class choosePlayerComputer extends StackPane {

    private ImageView background;

    private Label label1;
    private Label label2;
    private Label label3;

    private ComboBox comboBox1;
    private ComboBox comboBox2;

    private Button start;
    private Button retroceder;

    private Players players;
    private SimGame game;

    public choosePlayerComputer(Players players) {

        Window(players);
    }

    public void Window(Players players) {
        this.label1 = new Label("HUMAN  VS  COMPUTER");
        label1.setFont(new Font("SanSerif", 30));

        Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);

        // players = new Players();// criar no main e ir passando por argumentos
        // ObservableList<User> listaPessoas = FXCollections.observableArrayList(players.getPlayersList());
        label2 = new Label("Player 1");
        comboBox1 = new ComboBox();
        comboBox1.setPromptText("Player 1");
        players.getPlayersListPC().forEach((item) -> {
            comboBox1.getItems().add(item.getUsername());
        }); // comboBox1.getItems().addAll(players.getPlayersListName());

        label3 = new Label("Player 2");
        comboBox2 = new ComboBox();
        comboBox2.setPromptText("Player 2");
        players.getPlayersListPC().forEach((item) -> {
            comboBox2.getItems().add(item.getUsername());
        });

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
                        if (comboBox1.getValue().equals("Computer") || comboBox2.getValue().equals("Computer") ) {
                            User user1 = players.getPlayerPC(comboBox1.getValue().toString());
                            User user2 = players.getPlayerPC(comboBox2.getValue().toString());
                            System.out.println("Player 1 : " + comboBox1.getValue().toString());
                            System.out.println("Player 2 : " + comboBox2.getValue().toString());
                         /*INICIO
                            this.game = new SimGame(user1, user2);
                            //start.getScene().setRoot();
                            Stage primaryStage = new Stage();
                            BorderPane root = new BorderPane();
                            //game.draw();
                            GraphDraw<Vertice, Aresta> draw = game.draw();

                            VBox empty = new VBox();
                            empty.setAlignment(Pos.CENTER);
                            ComboBox comboBox = new ComboBox();
                            // comboBox.setAccessibleText("ComboBox");
                            //players = new Players();
                            comboBox.setPromptText("cOMBOBox");
                            players.getPlayersList().forEach((item) -> {
                                comboBox.getItems().add(item.getUsername());
                            }); // System.out.println( comboBox.getValue());
                            //comboBox.getItems().remove();

                            empty.getChildren().addAll(new Text("Graph Drawing with JavaFX"), comboBox);

                            root.setCenter(draw);
                            root.setTop(empty);

                            //stylesheet and css selectors
                            root.getStylesheets().addAll(this.getClass().getResource("/javafxgraphs/ui/resources/style.css").toExternalForm());
                            root.setId("pane");

                            Scene scene = new Scene(root, 600, 600);

                            primaryStage.setTitle("Graph!");
                            primaryStage.setScene(scene);
                            primaryStage.show();
  *///fim
  
  start.getScene().setRoot(new  DifficultyMenuPC(players,user1,user2));
 
  
                        } else {
                            System.out.println("Escolher um dos player PC");
                             Warning aviso = new Warning("Escolher um dos player PC");
                            //lançar uma box com erro
                        }

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

        all.getChildren().addAll(label1, label2, comboBox1, label3, comboBox2, buttons);

        this.getChildren().addAll(background, all);

    }
}

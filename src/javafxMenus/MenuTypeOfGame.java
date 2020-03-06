/*
 * Menu de escolha 
 */
package javafxMenus;

import Game.DisplayGame;
import Game.SimGame;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
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
 * author João Gomes e Daniel Marques
 */
public class MenuTypeOfGame extends StackPane {

    private Label label1;
    private Label label2;
    private Label label3;
    private ImageView background;

    private ComboBox comboBoxStats;

    private Button humanoVsHumano;
    private Button humanoVsComputer;

    private Button addPlayer;

    private Button statistic;

    public MenuTypeOfGame(Players players) {
        //Window();
        Window(players);

        //game.move(game.getGraph().edges().iterator().next());
        // game.getGraph().edges().iterator().next().element().isSelected2();
        // game.selectArestaPlayer2(game.getGraph().edges().iterator().next().element());
    }

    public void Window(Players players) {
        this.label1 = new Label("MODO DE JOGO");
        label1.setFont(new Font("SanSerif", 30));
        Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);
        VBox vbox = new VBox();
        humanoVsHumano = new Button("HUMANO VS HUMANO");
        humanoVsComputer = new Button("HUMANO VS COMPUTADOR");
        // humanoVsHumano.setContentDisplay(ContentDisplay.CENTER);

        ///humanoVsHumano.setTranslateX(255);
        //humanoVsHumano.setTranslateY(371);
        humanoVsHumano.setVisible(true);

        humanoVsHumano.setOnAction(
                (ActionEvent event) -> {

                    humanoVsHumano.getScene().setRoot(new choosePlayerHuman(players));
               }
        );
        
          humanoVsComputer.setOnAction(
                (ActionEvent event) -> {

                    humanoVsComputer.getScene().setRoot(new choosePlayerComputer(players));
               }
        );

        //choosePlayerComputer(Players players)
        vbox.getChildren().addAll(label1, humanoVsHumano, humanoVsComputer);

        VBox vbox1 = new VBox();
        //add player
        //statistics
        this.label2 = new Label("PLAYERS");
        label2.setFont(new Font("SanSerif", 30));
        Image ImageUser = new Image(getClass().getResourceAsStream("user.jpg"));
        ImageView iconUser = new ImageView(ImageUser);
        iconUser.setFitHeight(40);
        iconUser.setFitWidth(40);
        addPlayer = new Button("ADD PLAYER", iconUser);

        addPlayer.setOnAction(
                (ActionEvent event) -> {

                    addPlayer.getScene().setRoot(new MenuAddPlayer(players));

                }
        );
        vbox1.getChildren().addAll(label2, addPlayer);

        Image ImageStats = new Image(getClass().getResourceAsStream("stats.png"));
        ImageView stats = new ImageView(ImageStats);
        stats.setFitHeight(40);
        stats.setFitWidth(40);

        VBox vbox2 = new VBox();
        this.label3 = new Label("STATS");
        label3.setFont(new Font("SanSerif", 30));
        comboBoxStats = new ComboBox();
        comboBoxStats.setPromptText("Player Stats");
        for (User item : players.getPlayersList()) {
            comboBoxStats.getItems().add(item.getUsername());
        }

        statistic = new Button("STATISTIC", stats);
        // StatPlayer(Players player)
        statistic.setOnAction(
                (ActionEvent event) -> {

                    if (players.getPlayersList().contains(players.getPlayer(comboBoxStats.getValue().toString()))) {
                        User u = players.getPlayer(comboBoxStats.getValue().toString());
                        statistic.getScene().setRoot(new StatPlayer(players, u));
                    } else {
                        System.out.println("Selecione um player");
                        Warning aviso = new Warning("Selecione um player");
                        
                    }

                }
        );

        vbox2.getChildren().addAll(label3, comboBoxStats, statistic);
        //add player
        //statistics

        vbox.setAlignment(Pos.TOP_CENTER);
        vbox1.setAlignment(Pos.CENTER);
        vbox2.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setSpacing(5);
        vbox1.setSpacing(5);
        vbox2.setSpacing(5);
        VBox all = new VBox();
        all.getChildren().addAll(vbox, vbox1, vbox2);
        all.setAlignment(Pos.CENTER);
        all.setSpacing(75);
        //vbox.autosize();
        this.getChildren().addAll(background, all);

        // this.autosize();
        // this.autosize();
    }

}

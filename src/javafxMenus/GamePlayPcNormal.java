/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxMenus;

import Game.SimGame;
import Observer.Observador;
import Observer.Subject;
import static java.lang.Thread.sleep;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.tad.Edge;
import javafxgraphs.ui.GraphDraw;
import user.Players;
import user.TypePlayer;
import user.User;

/**
 *
 * @author João
 */
public final class GamePlayPcNormal extends StackPane implements Observador {

    private Label playerAtualLabel;
    private Label label1;
    private SimGame game;
    private GraphDraw<Vertice, Aresta> draw;
    private ComboBox moves;

    private Button makeMove;
    private Button undo;
    private Button changeTurn;
    private Button leave;
    private Button PcmakeMove;

    private ImageView background;

    public GamePlayPcNormal(Players players, User user1, User user2) {

        window(players, user1, user2);

    }

    private void window(Players players, User user1, User user2) {
        this.game = new SimGame(user1, user2);
        // this.game.addObservador(this);

        //game 
        this.game.whoPlaysFirst();
        this.game.configTurn();
        //game
        this.draw = game.draw();

        this.playerAtualLabel = new Label("Player Atual:" + game.getActualPlayer().getUsername());
        this.label1 = new Label("Undos Disponiveis:" + game.getActualPlayer().getUndos());

        moves = new ComboBox();
        moves.setPromptText("MOVES");
        game.getRemainEdges().forEach((item) -> {//tem de ser com observer
            moves.getItems().add(item.element().getIdAresta());

        });
        moves.setMinSize(20, 40);

        Image image = new Image(getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);

        Image imagemakemove = new Image(getClass().getResourceAsStream("uptade.png"));
        ImageView makemove = new ImageView(imagemakemove);
        makemove.setFitHeight(40);
        makemove.setFitWidth(40);
        PcmakeMove = new Button("PC MAKE MOVE", makemove);
       PcmakeMove.setOnAction(
                (ActionEvent event) -> {

                    if (this.game.getActualPlayer().getTypePlayer().equals(TypePlayer.COMPUTER))
                    {
                         this.game.pcMove();
                        
                        // this.game.removeEdge(this.game.getArestaByID((int) moves.getValue()));//remove depois do
                         draw.redraw();  
                    }                     
                    else
                    {
                        System.out.println("É a vez do Humano");
                         Warning aviso = new Warning("É a vez do Humano");
                    }
                });
    

    

        makeMove = new Button("MAKE MOVE", makemove);

        makeMove.setOnAction(
                (ActionEvent event) -> {
                    
        
                    if(this.game.getActualPlayer().getTypePlayer()==TypePlayer.HUMAN)
                {
                     //selectArestaPlayer1(edge1.element())
                // this.game.selectArestaPlayer1(this.game.getGraph().edges().iterator().next().element());
                   this.game.move(this.game.getArestaByID((int) moves.getValue()));
                 //  caretaker.saveState(this.game);
                   
                //   this.game.removeEdge(this.game.getArestaByID((int) moves.getValue()));//remove depois do
                 
                   
                   //draw.redraw();
                   
                     playerAtualLabel.setText("Player Atual:"+ game.getActualPlayer().getUsername());
                   this.label1.setText("Undos Disponiveis:"+game.getActualPlayer(). getUndos());
                       draw.redraw();
                   //this.game.changeTurn();
                }
                    else
                {
                     Warning aviso = new Warning("É A VEZ DO PC");
                }
                    
                });
                
                    //////////////////////////////////////////////////////PC A PENSAR//////////////////////////////////////
//                     try {
//                  TimeUnit.SECONDS.sleep(5);
//              } catch (InterruptedException ex) {
//                  Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
//              }
                    //////////////////////////////////////////////PC A PENSAR//////////////////////////////////////////////////////
//                   this.game.pcMove();
//                   draw.redraw();
                

        //makeMove.
        Image imageLeave = new Image(getClass().getResourceAsStream("leave.png"));
        ImageView leaveBtn = new ImageView(imageLeave);
        leaveBtn.setFitHeight(40);
        leaveBtn.setFitWidth(40);
        leave = new Button("LEAVE", leaveBtn);
        leave.setOnAction(
                (ActionEvent event) -> {
                    
                    this.game.getActualPlayer().incrementLoses();
              try {
                  TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException ex) {
                  Logger.getLogger(GamePlay.class.getName()).log(Level.SEVERE, null, ex);
              }
                    leave.getScene().setRoot(new MenuTypeOfGame( players));
                }
        
         );
        Image imageUndo = new Image(getClass().getResourceAsStream("undo1.png"));
        ImageView undobtn = new ImageView(imageUndo);
        undobtn.setFitHeight(40);
        undobtn.setFitWidth(40);

        undo = new Button("UNDO MOVE", undobtn);

        undo.setOnAction(
                (ActionEvent event) -> {
                    this.game.undo();
                    this.label1.setText("Undos Disponiveis:"+game.getActualPlayer(). getUndos());

                    
                 draw.redraw();
                  //  caretaker.restoreState(this.game);
                    
                   // undo.getScene().setRoot(new MenuTu( user1,  user2));
                    
                });

        VBox inf = new VBox();
        inf.getChildren().addAll(playerAtualLabel, label1);
        VBox botoes = new VBox();
        botoes.getChildren().addAll(PcmakeMove,makeMove, undo, moves);
        botoes.setSpacing(15);

        VBox all = new VBox();
        all.getChildren().addAll(botoes, leave);//removi o inf
        all.setSpacing(10);
        this.getChildren().addAll(background, draw, all);

        this.getStylesheets().addAll(this.getClass().getResource("/javafxgraphs/ui/resources/style.css").toExternalForm());
        this.setId("pane");

    }

    /* 
    private void selectMove(int id)
    {
        if()
        {
            
        }
        else
        {
            
        }
            
    }
     */
    @Override
    public void update(Subject s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgraphs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafxgraphs.ui.GraphDraw;
import javafxgraphs.tad.GraphLinked;
import javafxgraphs.tad.Vertex;
import javafxgraphs.*;
import  Game.DisplayGame;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafxMenus.MenuTypeOfGame;
import user.Players;
import user.TypePlayer;
import user.User;

/**
 *
 * @author brunomnsilva
 */
public class Main extends Application {
     
      
    @Override
    public void start(Stage primaryStage) {
       /**
        GraphLinked<Vertice, Aresta> myG = new GraphLinked<>();

        Vertex<Vertice> VerticeA = myG.insertVertex(new Vertice("Alfa"));
        Vertex<Vertice> VerticeB = myG.insertVertex(new Vertice("Bravo"));//
        Vertex<Vertice> VerticeC = myG.insertVertex(new Vertice("Charlie"));
        Vertex<Vertice> VerticeD = myG.insertVertex(new Vertice("Delta"));//
        Vertex<Vertice> VerticeE = myG.insertVertex(new Vertice("Echo"));
        Vertex<Vertice> VerticeF = myG.insertVertex(new Vertice("Foxtrot"));
        Vertex<Vertice> VerticeG = myG.insertVertex(new Vertice("Gamma"));

        myG.insertEdge(VerticeA, VerticeB, new Aresta("ArestaA", 20));
        Aresta ArestaD = new Aresta("ArestaD", 1);
        myG.insertEdge(VerticeC, VerticeA, ArestaD);

        myG.insertEdge(VerticeA, VerticeD, new Aresta("ArestaE", 20));
        myG.insertEdge(VerticeD, VerticeB, new Aresta("ArestaG", 1000));
        myG.insertEdge(VerticeD, VerticeC, new Aresta("ArestaF", 100));
        myG.insertEdge(VerticeE, VerticeA, new Aresta("ArestaI", 60));
        myG.insertEdge(VerticeF, VerticeG, new Aresta("ArestaJ", 70));
        myG.insertEdge(VerticeA, VerticeF, new Aresta("ArestaK", 30));
        
        //selecionar uma Aresta
        myG.edges().iterator().next().element().toogleSelect();  
        //myG.edges().
        
        BorderPane root = new BorderPane();
      */
        //GraphDraw<Vertice, Aresta> draw = new GraphDraw(myG); 
       /*
        DisplayGame game = new DisplayGame();
         BorderPane root = new BorderPane();
       //game.draw();
       GraphDraw<Vertice, Aresta> draw = game.draw();
        
        VBox empty = new VBox();
        empty.setAlignment(Pos.CENTER);
        empty.getChildren().add( new Text("Graph Drawing with JavaFX") );
        
        root.setCenter(draw);
        root.setTop(empty);
        
        //stylesheet and css selectors
        root.getStylesheets().addAll(this.getClass().getResource("/javafxgraphs/ui/resources/style.css").toExternalForm());
        root.setId("pane");
      
        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Graph!");
        primaryStage.setScene(scene);
        primaryStage.show();
        */
      
      User user1 = new User("Joao","gomes",TypePlayer.HUMAN);
      User user2 = new User("daniel","jhgh",TypePlayer.HUMAN);
      
         Players players = new Players();
     
        MenuTypeOfGame root = new MenuTypeOfGame(players);
        
       // root.Window();
        root.getChildren();
        Scene scene = new Scene( root, 1280, 720);
        
        
        
        primaryStage.setTitle("Menu Escolha");
        primaryStage.setScene(scene);
        primaryStage.show();
     
     
     
     
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}

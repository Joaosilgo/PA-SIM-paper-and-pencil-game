/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxMenus;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import user.Players;
import user.User;

/**
 *
 * @author João
 */
public class StatPlayer extends StackPane {
    
    private Label label1;
     private Label label2;
      private Label label3;
    
    private ImageView background;

   private ComboBox comboBox1;

    public StatPlayer(Players player,User user) {
        window(player,user);
    }
    
    
    
    
    private void window(Players player,User user)
    {
        
        Image image = new Image(this.getClass().getResourceAsStream("background.jpg"));
        background = new ImageView(image);
        
        label1 = new Label("Player: "+user.getUsername());
        label1.setFont(new Font("SanSerif", 20));
        
         label2 = new Label("Games: "+ user.getNumberOfGames());
        label2.setFont(new Font("SanSerif", 20));
        
         label3 = new Label("Time Played: "+ user.getTimePlayed());
        label3.setFont(new Font("SanSerif", 20));
                
                
              
     //   player.getPlayer("Joao").incrementWins();
       graficoStats  joao = new graficoStats(user.getWins(),user.getLoses());
       VBox grafJoao = new VBox();
        grafJoao.getChildren().add(joao.getVBox());
        grafJoao.setAlignment(Pos.CENTER);
        Button sair = new Button("SAIR");
         sair.setOnAction(
                (ActionEvent event) -> {
                   
              sair.getScene().setRoot(new MenuTypeOfGame( player));
             
              
                      
                }
        );
         VBox vbox1 = new VBox();
         vbox1.getChildren().addAll(label1,label2,label3);
         vbox1.setAlignment(Pos.TOP_CENTER);
         
         
         VBox vbox2 = new VBox();
         vbox2.getChildren().addAll(grafJoao,sair);
         vbox2.setAlignment(Pos.BOTTOM_CENTER);
        
        this.getChildren().addAll(background,vbox1,vbox2);
        this.setAlignment(Pos.CENTER);
    }
    
    
    
     
         
        
    
    
    
    
    
    
    private class graficoStats extends Pane {

    private int wins;
    private int loses;

    public graficoStats(int vitoria, int derrota) {
        this.wins = vitoria;
        this.loses = derrota;

        PieChart chart = new PieChart();

        PieChart.Data win = new PieChart.Data("WINS", wins);
        PieChart.Data lose = new PieChart.Data("LOSES", loses);
        
       
                
        chart.getData().add(win);
        chart.getData().add(lose);
        

        chart.setScaleX(0.75);
        chart.setScaleY(0.75);
        chart.setLegendVisible(true);
        chart.setLayoutX(50);
        chart.setLayoutY(50);
        
        
        chart.setLabelsVisible(true);

        VBox vbox = new VBox();
        vbox.getChildren().add(chart);

        this.getChildren().addAll(vbox);
    }

    public Pane getVBox() {
        return this;
    }
}
    

    
}

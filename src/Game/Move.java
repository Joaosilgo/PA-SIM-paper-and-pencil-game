/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.tad.Edge;
import user.User;

/**
 *
 * @author João
 */
public class Move {
    private static  int count=1;
    private int id;

    public Move(User player) {
        this.id=Move.count;
        Move.count++;
        
        
        
    }
    
    
    public void move(Edge<Aresta, Vertice> arestaEscolhida)
    {
        
    }
    
    
    /*
    
    
    }
    */
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MementoPattern;

import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.tad.Edge;

/**
 *Memento: Define os dados a guardar sobre o objeto. 
 * @author João
 */

    
    public class Memento {
     private  Edge<Aresta, Vertice>  moveEdge;

    public Memento( Edge<Aresta, Vertice>  moveEdge) {
        this.moveEdge=moveEdge;
    }

    public Edge<Aresta, Vertice> getMove() {
        return moveEdge;
    }   
     
}
    

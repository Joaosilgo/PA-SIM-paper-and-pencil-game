/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.tad.Edge;
import javafxgraphs.tad.GraphLinked;
import javafxgraphs.tad.Vertex;
import javafxgraphs.ui.GraphDraw;
import user.Players;
import user.User;

/**
 *
 * @author João
 */
public class DisplayGame {

    private GraphLinked<Vertice, Aresta> myG;
    private SimGame jogoSim;
    private User player1;
    private User player2;

    private List<Aresta> arestas;
    private List<Edge<Aresta, Vertice>> arestasLivres;

    private List<Edge<Aresta, Vertice>> jogador1Arestas;
    private List<Vertex<Vertice>> jogador1Vertices;
    
    private HashMap<Integer, Edge<Aresta, Vertice>> mapEdges;

    public DisplayGame() {
          this.player1=player1;
          this.player2=player2;
        initiateVariables();
        this.arestas = new ArrayList<>();
        display();

    }

    private void initiateVariables() {
        mapEdges = new HashMap<>();
        arestasLivres= new ArrayList<>();
       // jogoSim = new JogoSim();
        jogador1Arestas = new ArrayList<>();
        Collections.sort(jogador1Arestas, Collections.reverseOrder());

        //jogador1Arestas.sort();
        //Collections.sort(list, Collections.reverseOrder());. 
    }

    public void move(int desigAresta) {

        switch (desigAresta) {
            case 1:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        
                    } 
                }   break;
            case 2:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        
                    } 
                }   break;
            case 3:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        
                    }
                }   break;
            case 4:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        
                    
                }}   break;
            case 5:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        
                    } 
                }   break;
            case 6:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 7:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 8:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        
                        break;
                    } 
                }   break;
            case 9:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 10:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 11:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 12:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 13:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 14:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            case 15:
                jogador1Arestas.add(mapEdges.get(desigAresta));
                for (Edge<Aresta, Vertice> item : jogador1Arestas) {
                    if (item.element().getIdAresta() == desigAresta) {
                        selecionarArestaPlayer1(item.element());
                        break;
                    } 
                }   break;
            default:
                break;
        }

        /*  
        jogador1Arestas.add(aresta);
        Vertex<Vertice>[] vertices = aresta.vertices();
        jogador1Vertices.add(vertices[0]);
        jogador1Vertices.add(vertices[1]);
        boolean triangulo = jogoSim.verificarTriangulo(jogador1Arestas);
        
        if(triangulo == true){
            System.out.println("Jogador Perdeu");
            
        }
         */
 
    
        
         
    }

    private GraphLinked<Vertice, Aresta> CreateGraph() {
        myG = new GraphLinked<>();
        return myG;
    }

    private void selecionarArestaPlayer1(Aresta aresta) {

        aresta.toogleSelect1();

    }

    private void selecionarArestaPlayer2(Aresta aresta) {

        aresta.toogleSelect2();

    }

    private void addAresta() {
        /*
        Aresta aresta1 = new Aresta("ARESTA1", 1);
        Aresta aresta2 = new Aresta("ARESTA2", 2);
        Aresta aresta3 = new Aresta("ARESTA3", 3);
        Aresta aresta4 = new Aresta("ARESTA4", 4);
        Aresta aresta5 = new Aresta("ARESTA5", 5);
        Aresta aresta6 = new Aresta("ARESTA6", 6);
        Aresta aresta7 = new Aresta("ARESTA7", 7);
        Aresta aresta8 = new Aresta("ARESTA8", 8);
        Aresta aresta9 = new Aresta("ARESTA9", 9);
        Aresta aresta10 = new Aresta("ARESTA10", 10);
        Aresta aresta11 = new Aresta("ARESTA11", 11);
        Aresta aresta12 = new Aresta("ARESTA12", 12);
        Aresta aresta13 = new Aresta("ARESTA13", 13);
        Aresta aresta14 = new Aresta("ARESTA14", 14);
        Aresta aresta15 = new Aresta("ARESTA15", 15);
         */
        for (int i = 1; i <= 15; i++) {
            Aresta aresta = new Aresta("ARESTA" + i, i);
            this.arestas.add(aresta);
        }
    }

    public Aresta getAresta(int id) {

        for (Aresta aresta : arestas) {
            if (id == aresta.getIdAresta()) {
                return aresta;
            }
        }
        return null;

    }

    private void display() {
        //GraphLinked<Vertice, Aresta> myG = new GraphLinked<>();

        addAresta();
        GraphLinked<Vertice, Aresta> myG = CreateGraph();

        Vertex<Vertice> VerticeA = myG.insertVertex(new Vertice("Alfa"));
        Vertex<Vertice> VerticeB = myG.insertVertex(new Vertice("Bravo"));//
        Vertex<Vertice> VerticeC = myG.insertVertex(new Vertice("Charlie"));
        Vertex<Vertice> VerticeD = myG.insertVertex(new Vertice("Delta"));//
        Vertex<Vertice> VerticeE = myG.insertVertex(new Vertice("Echo"));
        Vertex<Vertice> VerticeF = myG.insertVertex(new Vertice("Foxtrot"));
        Aresta aresta1 = new Aresta("ARESTA1", 1);
        Aresta aresta2 = new Aresta("ARESTA2", 2);

        Edge<Aresta, Vertice> edge1 = myG.insertEdge(VerticeA, VerticeB, aresta1);
        Edge<Aresta, Vertice> edge2 = myG.insertEdge(VerticeA, VerticeC, aresta2);
        Edge<Aresta, Vertice> edge3 = myG.insertEdge(VerticeA, VerticeD, getAresta(3));
        Edge<Aresta, Vertice> edge4 = myG.insertEdge(VerticeA, VerticeE, getAresta(4));
        Edge<Aresta, Vertice> edge5 = myG.insertEdge(VerticeA, VerticeF, getAresta(5));
        Edge<Aresta, Vertice> edge6 = myG.insertEdge(VerticeB, VerticeC, getAresta(6));
        Edge<Aresta, Vertice> edge7 = myG.insertEdge(VerticeB, VerticeD, new Aresta("ARESTA7", 7));
        Edge<Aresta, Vertice> edge8 = myG.insertEdge(VerticeB, VerticeE, new Aresta("ARESTA8", 8));
        Edge<Aresta, Vertice> edge9 = myG.insertEdge(VerticeB, VerticeF, new Aresta("ARESTA9", 9));
        Edge<Aresta, Vertice> edge10 = myG.insertEdge(VerticeC, VerticeD, new Aresta("ARESTA10", 10));
        Edge<Aresta, Vertice> edge11 = myG.insertEdge(VerticeC, VerticeE, new Aresta("ARESTA11", 11));
        Edge<Aresta, Vertice> edge12 = myG.insertEdge(VerticeC, VerticeF, new Aresta("ARESTA12", 12));
        Edge<Aresta, Vertice> edge13 = myG.insertEdge(VerticeD, VerticeE, new Aresta("ARESTA13", 13));
        Edge<Aresta, Vertice> edge14 = myG.insertEdge(VerticeD, VerticeF, new Aresta("ARESTA14", 14));
        Edge<Aresta, Vertice> edge15 = myG.insertEdge(VerticeE, VerticeF, new Aresta("ARESTA15", 15));

        mapEdges.put(1, edge1);//KEY 1
        mapEdges.put(2, edge2);//KEY 2
        mapEdges.put(3, edge3);
        mapEdges.put(4, edge4);
        mapEdges.put(5, edge5);
        mapEdges.put(6, edge6);
        mapEdges.put(7, edge7);
        mapEdges.put(8, edge8);
        mapEdges.put(9, edge9);
        mapEdges.put(10, edge10);
        mapEdges.put(11, edge11);
        mapEdges.put(12, edge12);
        mapEdges.put(13, edge13);
        mapEdges.put(14, edge14);
        mapEdges.put(15, edge15);
        
        
        
         arestasLivres.add(edge1);
        arestasLivres.add(edge2);
        arestasLivres.add(edge3);
        arestasLivres.add(edge4);
        arestasLivres.add(edge5);
        arestasLivres.add(edge6);
        arestasLivres.add(edge7);
        arestasLivres.add(edge8);
        arestasLivres.add(edge9);
        arestasLivres.add(edge10);
        arestasLivres.add(edge11);
        arestasLivres.add(edge12);
        arestasLivres.add(edge13);
        arestasLivres.add(edge14);
        arestasLivres.add(edge15);

        // myG.edges().iterator().equals(aresta1)
        // aresta1.toogleSelect();
        //aresta1.getId();
        //selecionarArestaPlayer1(aresta1);
        // selecionarArestaPlayer2(aresta2);
        //System.out.println(getAresta(1).getId());
        move(1);
        move(2);
        move(3);
        //move(4);
        //move(8);
          //System.out.println(verificarTriangulo(jogador1Arestas));  
       
        // jogador1Arestas.add(edge1);
       //  jogador1Arestas.add(edge5);
       //  jogador1Arestas.add(edge9);
      //  move(1);
      // move(5);
       //move(9);
       
       // move(9);
               
         
        //if(triangulo == true){
        //    System.out.println("Jogador Perdeu");
        // }
        // move(2);
        //move(3);
        /**
         * Aresta ArestaD = new Aresta("ArestaD", 1); myG.insertEdge(VerticeC,
         * VerticeA, ArestaD); myG.insertEdge(VerticeA, VerticeB, new
         * Aresta("ArestaA", 20)); myG.insertEdge(VerticeA, VerticeD, new
         * Aresta("ArestaE", 20)); myG.insertEdge(VerticeD, VerticeB, new
         * Aresta("ArestaG", 1000)); myG.insertEdge(VerticeD, VerticeC, new
         * Aresta("ArestaF", 100)); myG.insertEdge(VerticeE, VerticeA, new
         * Aresta("ArestaI", 60)); myG.insertEdge(VerticeF, VerticeG, new
         * Aresta("ArestaJ", 70)); myG.insertEdge(VerticeA, VerticeF, new
         * Aresta("ArestaK", 30));
         *
         * //selecionar uma Aresta
         * myG.edges().iterator().next().element().toogleSelect();
         * //myG.edges().
         *
         */
    }
 

    public GraphDraw<Vertice, Aresta> draw() {
        GraphDraw<Vertice, Aresta> draw = new GraphDraw(myG);
        
        return draw;
    }

    
    public List<Edge<Aresta, Vertice>> getJogador1Arestas() {
        return jogador1Arestas;
    }
    

}

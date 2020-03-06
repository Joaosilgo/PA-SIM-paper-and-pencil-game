/*
 * @class SimGame vai ser a class responsavel por a dinamica e o mecanismo do jogo
 */
package Game;

import MementoPattern.Memento;
import Observer.Subject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import static javafx.util.Duration.millis;
import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.tad.Edge;
import javafxgraphs.tad.Graph;
import javafxgraphs.tad.GraphLinked;
import javafxgraphs.tad.Vertex;
import javafxgraphs.ui.GraphDraw;
import user.TypePlayer;
import user.User;

/**
 *
 * @author João Gomes e Daniel Marques
 */
public class SimGame extends Subject {

    private GraphLinked<Vertice, Aresta> graph;

    private User player1;
    private User player2;
    private User actualPlayer;// teve-se de atribuir um player actual paa trocar de turnos melhor
    //as listas passao automaticamente ao player actual

    private List<Edge<Aresta, Vertice>> Edges;
    private List<Edge<Aresta, Vertice>> edgeTest;

    private ArrayList<Edge<Aresta, Vertice>> player1Edges;
    private ArrayList<Edge<Aresta, Vertice>> player2Edges;
    private ArrayList<Edge<Aresta, Vertice>> actualPlayerEdges;
    private ArrayList<Edge<Aresta, Vertice>> RemainEdges;
    private ArrayList<Edge<Aresta, Vertice>> player1RemainEdges;
    private ArrayList<Edge<Aresta, Vertice>> player2RemainEdges;

    private long startTime;
    private long endTime;
    private int turnPlayer;//1 || 2
    private boolean undo;
    private static SimGame singleton;
    private int countJogadas;
    private Edge<Aresta, Vertice> currentValue;

    /**
     * Constructor.
     *
     * @param player1 (required) um object de jogador que seja humano
     * @param player2 (required) pum object de jogador que seja humano
     *
     */
    public SimGame(User player1, User player2) {

        this.player1 = validateUser(player1);

        this.player2 = validateUser(player2);

        this.player1.incrementNumberOfGames();//incremenrta o numero de jogos
        this.player2.incrementNumberOfGames();

        startTime = System.currentTimeMillis();
        //   this.turnPlayer = 1;//Starts player 1;
        //initiateVariables();
        player1Edges = new ArrayList<>();
        player2Edges = new ArrayList<>();
        actualPlayerEdges = new ArrayList<>();
        RemainEdges = new ArrayList<>();
        //player1RemainEdges = new ArrayList<>();
        // player2RemainEdges = new ArrayList<>();
        displayGraph();
        Collections.sort(player1Edges, Collections.reverseOrder());
        Collections.sort(player2Edges, Collections.reverseOrder());
        Collections.sort(actualPlayerEdges, Collections.reverseOrder());
        countJogadas=0;
        this.currentValue=null;

    }

    public static SimGame getInstance() {
        // if(singleton == null) {
        //   singleton = new SimGame( player1 , player2);
        //}

        return singleton;
    }

    /**
     * Inicia as variaveis player1Edges e player2Edges
     */
    private void initiateVariables() {

        player1Edges = new ArrayList<>();
        player2Edges = new ArrayList<>();
        actualPlayerEdges = new ArrayList<>();

        //Collections.sort(jogador1Arestas, Collections.reverseOrder());
        //jogador1Arestas.sort();
        //Collections.sort(list, Collections.reverseOrder());. 
    }

    public ArrayList<Edge<Aresta, Vertice>> getRemainEdges() {
        return RemainEdges;
    }

    public int whoPlaysFirst() {
        Random r = new Random();

        int randomInt = r.nextInt(2) + 1;
        this.turnPlayer = randomInt;

        System.out.println("Starts Player: " + randomInt);
        return randomInt;

    }

    /**
     *
     * @param user
     * @return um usuario que não seja null
     */
    private User validateUser(User user) {
        if (user == null) {
            throw new InvalidGameException("Player está a null");
        } else {
            return user;
        }
    }

    /**
     * Conta o tempo do jogo em exec~çao até que se invoque e aí acaba o jogo e
     * o tempo pára
     *
     * @param starTime
     * @return
     */
    private long getTimePlayedPlayed(long starTime) {
        //long startTime = System.currentTimeMillis();
//.....your program....
        this.endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        int min;
        min = (int) (totalTime / 1000) / 60;
        System.out.println(min);
        return totalTime;
        //  long second = (millis / 1000) % 60;
        // long minute = (millis / (1000 * 60)) % 60;
        // long hour = (millis / (1000 * 60 * 60)) % 24;

        //String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
    }

    /**
     * Troca o turn depois de se ter feito o move tem de se invovar
     * changeTurn(), para passar a vez ao outro jogador
     */
    public void changeTurn() {
        switch (this.turnPlayer) {
            case 1:
                this.turnPlayer = 2;
                break;
            case 2:
                this.turnPlayer = 1;
                break;
            default:
                throw new InvalidGameException("jogo invalido ´so existem 2 jogadores check Value turns");
        }
    }

    public User getActualPlayer() {

        return actualPlayer;
    }

    /**
     * Troca o turn depois de se ter feito o move tem de se invovar
     * changeTurn(), para passar a vez ao outro jogador
     */
    public void configTurn() {
        if (turnPlayer == 1) {
            this.actualPlayer = player1;
            this.actualPlayerEdges = player1Edges;

            System.out.println("Player1 a jogar");
        } else if (turnPlayer == 2) {
            this.actualPlayer = player2;
            this.actualPlayerEdges = player2Edges;

            System.out.println("Player2 a jogar");
        } else {
            throw new InvalidGameException("jogo invalido ´so existem 2 jogadores check Value turns");
        }

    }

    //  public void move(Edge<Aresta, Vertice> edge) {
//
//        if (this.turnPlayer == 1) {
//            //configTurn();
//            boolean entrou = this.player1Edges.add(edge);
//            //System.out.println(entrou);
//            System.out.println("Jogada Efectuada" + edge.element().getId());
//            //  System.out.println(checkTriangle(player1Edges));
//            /*
//            boolean triangulo = checkTriangle(player1Edges);
//
//            if (triangulo == true) {
//                getActualPlayer().incrementLoses();
//                getActualPlayer().IncrementTimePlayed(getTimePlayedPlayed(this.startTime));
//                // win(getActualPlayer());
//                System.out.println(win(player1));
//            } else {
//                System.out.println("Deseja passar de vez");
//            }
//             */
//        } else {
//            //configTurn();
//            this.player2Edges.add(edge);
//            System.out.println("Jogada Efectuada" + edge.element().getId());
//            // System.out.println(checkTriangle(player1Edges));
//            /*
//            boolean triangulo = checkTriangle(player2Edges);
//            if (triangulo == true) {
//                getActualPlayer().incrementLoses();
//                getActualPlayer().IncrementTimePlayed(getTimePlayedPlayed(this.startTime));
//                System.out.println(win(player2));
//            } else {
//                System.out.println("Deseja passar de vez");
//            }
//             */
//        }
    /**
     * Metodo que irá
     *
     * @param edge
     */
    public void move(Edge<Aresta, Vertice> edge) {
        //  boolean valor = undoMove();
        //if (valor == true) {
        //   undo = false;
        //  System.out.println("Undo Realiado Deseja mudar de vez?");
        //} else {
        configTurn();
        // }
        this.actualPlayerEdges.add(edge);
        countJogadas++;
        currentValue=edge;

        if (this.turnPlayer == 1) {
            selectArestaPlayer1(edge.element());
        } else {
            selectArestaPlayer2(edge.element());
        }
        if (checkTriangle(actualPlayerEdges) == true) {
            getActualPlayer().incrementLoses();
            getActualPlayer().IncrementTimePlayed(getTimePlayedPlayed(this.startTime));
            // win(getActualPlayer());
            System.out.println(win(getActualPlayer()));

        } else {
            //System.out.println("Deseja passar de vez");
            changeTurn();
        }
    }

    public void removeEdge(Edge<Aresta, Vertice> s) {
        if (!RemainEdges.contains(s)) {
            RemainEdges.remove(s);
            notifyAllObservers();
        }
    }

    public GraphDraw<Vertice, Aresta> draw() {
        GraphDraw<Vertice, Aresta> draw = new GraphDraw(graph);

        return draw;
        //FOI AQUI PARA APAGAR
    }
    
    
    public void undo()
            
    {
        this.currentValue.element().setSelected1(false);
        this.currentValue.element().setSelected2(false);
       // this.actualPlayerEdges.remove(actualPlayerEdges.size());
        changeTurn();
    }

    /**
     * undoMove tem como finalidade remover a ultima jogada efectuada pelo
     * jogador actual tendo como condiçoes o utilizadr tem de ser humano e que o
     * user ainda pode fazer undo()
     *
     * @return boolean
     */
    public boolean undoMove() {
//

        if (getActualPlayer().getTypePlayer() == TypePlayer.HUMAN) {
//            if (getActualPlayer().decrementUndos() == true) {
                //
                undo = true;
                this.actualPlayerEdges.remove(actualPlayerEdges.size());
                this.currentValue.element().setSelected1(false);
                this.currentValue.element().setSelected2(false);
                return true;

//            } else {
//                this.undo = false;
//                return false;
//
//            }
        } else {
            System.out.println("Tem de ser Jogador Humano");
            this.undo = false;
            return false;

        }

    }
     public Memento createMemento() {
        return new Memento(this.currentValue);
    }

    public void setMemento(Memento momente) {
        this.currentValue = momente.getMove();
    }


    /**
     *
     * @param user
     * @return returna a frase de vencedor
     */
    public String win(User user) {
        String inf = "";
        inf += "\n----WINNER----\n";
        inf += "--------------\n";
        inf += "NAME: " + user.getUsername() + "\n";
        inf += "--------------\n";
        return inf;
    }

    public ArrayList<Edge<Aresta, Vertice>> getEdges() {
        return (ArrayList<Edge<Aresta, Vertice>>) Edges;
    }

    /**
     * este metodo irá selecionar de cor diversa ao adversário a aresta
     * selecionada neste caso player1
     *
     * @param aresta
     */
    public void selectArestaPlayer1(Aresta aresta) {

        aresta.toogleSelect1();

    }

    /**
     * este metodo irá selecionar de cor diversa ao adversário a aresta
     * selecionada neste caso player2
     *
     * @param aresta
     */
    public void selectArestaPlayer2(Aresta aresta) {

        aresta.toogleSelect2();

    }

    public Edge<Aresta, Vertice> getArestaByID(int id) {
        Edge<Aresta, Vertice> b = null;
        for (Edge<Aresta, Vertice> a : this.graph.edges()) {
            if (a.element().getIdAresta() == id) {
                b = a;
                return b;
            }

        }
        return null;

    }

    /*
        Set<Object> set = new HashSet<Object>();
// add some items to the set

Iterator<Object> setIterator = set.iterator();
while(setIterator.hasNext()){
     Object o = setIterator.next();
     if(o meets some condition){
          setIterator.remove();
     }
}
     */
 /*
    public Edge<Aresta, Vertice> getEdgeNumber(int i) {
      //    (ArrayList<Edge<Aresta, Vertice>>) graph.edges().iterator();
        //Iterator<Edge<Aresta, Vertice>> setIterator = set.iterator();
        while (graph.edges().iterator().hasNext()) {
              Edge<Aresta, Vertice> o = graph.edges().iterator().next();
              if(o.element().getIdAresta()==i){
          return o;
     }
        }
        return graph.edges().iterator().next();
        
    }
     */
 /*
    
       public boolean verificarTriangulo(List<Edge<Aresta, Vertice>> listaArestas) {

        MyGraph<Vertice, Aresta> grafoLocal = new MyGraph<>();
        Set<Vertex<Vertice>> verticesTodos = new HashSet<>();

        for (Edge<Aresta, Vertice> aresta : listaArestas) {
            Vertex<Vertice>[] vertices = aresta.vertices();
            grafoLocal.insertEdge(vertices[0], vertices[1], aresta.element());
            verticesTodos.add(vertices[0]);
            verticesTodos.add(vertices[1]);
        }

        for (Edge<Aresta, Vertice> aresta : listaArestas) {
            Vertex<Vertice>[] vertices = aresta.vertices();
            Vertex<Vertice> verticeUm = vertices[0];
            Vertex<Vertice> verticeDois = vertices[1];

            for (Vertex<Vertice> verticeComparar : verticesTodos) {
                if (grafoLocal.areAdjacent(verticeUm, verticeComparar) == true
                        && grafoLocal.areAdjacent(verticeDois, verticeComparar) == true) {
                    return true;
                }
            }
        }
        return false;
    }
     */
    public boolean checkTriangle(List<Edge<Aresta, Vertice>> listaArestas) {

        GraphLinked<Vertice, Aresta> grafoLocal = createLocalEmptyGraph();
        Set<Vertex<Vertice>> verticesTodos = new HashSet<>();

        for (Edge<Aresta, Vertice> aresta : listaArestas) {
            Vertex<Vertice>[] vertices = aresta.vertices();
            grafoLocal.insertEdge(vertices[0], vertices[1], aresta.element());
            verticesTodos.add(vertices[0]);
            verticesTodos.add(vertices[1]);
        }

        for (Edge<Aresta, Vertice> aresta : listaArestas) {
            Vertex<Vertice>[] vertices = aresta.vertices();
            Vertex<Vertice> verticeUm = vertices[0];
            Vertex<Vertice> verticeDois = vertices[1];

            for (Vertex<Vertice> verticeComparar : verticesTodos) {
                if (grafoLocal.areAdjacent(verticeUm, verticeComparar) == true
                        && grafoLocal.areAdjacent(verticeDois, verticeComparar) == true) {
                    return true;

                } else {
                    return false;
                }
            }
        }
        return false;

    }

    // for (Edge<Aresta, Vertice> aresta : listaArestas) {
    //   if (listaArestas.isEmpty()) {
    //    return false;
    //} else {
    /*
                Vertex<Vertice>[] vertices = aresta.vertices();
                 grafoLocal.insertEdge(vertices[0], vertices[1], aresta.element());
                if (vertices[0].element() != null && vertices[1].element() != null) {
                    //System.out.println(vertices[0].toString());
                    Vertex<Vertice> v = vertices[0];
                    Vertex<Vertice> u = vertices[1];
                    grafoLocal.insertEdge(v, u, aresta.element());

                    verticesTodos.add(vertices[0]);
                    verticesTodos.add(vertices[1]);
                } else {
                    return false;
                }
            }
     */
    public ArrayList<Edge<Aresta, Vertice>> getActualPlayerEdges() {
        return actualPlayerEdges;
    }

    /*
    for (Edge<Aresta, Vertice> aresta : listaArestas) {
    Vertex<Vertice>[] vertices = aresta.vertices();
    Vertex<Vertice> verticeUm = vertices[0];
    Vertex<Vertice> verticeDois = vertices[1];
    for (Vertex<Vertice> verticeComparar : verticesTodos) {
    if (grafoLocal.areAdjacent(verticeUm, verticeComparar) == true
    && grafoLocal.areAdjacent(verticeDois, verticeComparar) == true) {
    return true;
    }
    }
    }
     */
    private GraphLinked<Vertice, Aresta> createLocalEmptyGraph() {
        GraphLinked<Vertice, Aresta> grafoLocal = new GraphLinked<>();
        for (Vertex<Vertice> v : this.graph.vertices()) {
            grafoLocal.insertVertex(v.element());
        }
        return grafoLocal;
    }

    public List<Edge<Aresta, Vertice>> getEdgeTest() {
        return edgeTest;
    }

    public GraphLinked<Vertice, Aresta> getGraph() {
        return graph;
    }

    /**
     * displayGraph() irá replicar o grafo com os vertices e arestas
     * predestinados e previamente enumerados
     */
    private void displayGraph() {

        graph = new GraphLinked<>();
        Edges = new ArrayList<>();
        edgeTest = new ArrayList<>();
        //arestasLivres = new ArrayList();
        //vertices = new ArrayList<>();
        //jogador1ArestasEscolhidas = new ArrayList();
        //jogador1VerticesEscolhidos = new ArrayList();
        //jogador2ArestasEscolhidas = new ArrayList();
        //jogador2VerticesEscolhidos = new ArrayList();
        //jogadorActualArestasEscolhidas = new ArrayList();
        //jogadorActualVerticesEscolhidos = new ArrayList();

        Vertice VerticeA = new Vertice("Alfa");
        Vertice VerticeB = new Vertice("Bravo");
        Vertice VerticeC = new Vertice("Charlie");
        Vertice VerticeD = new Vertice("Delta");
        Vertice VerticeE = new Vertice("Echo");
        Vertice VerticeF = new Vertice("Foxtrot");

        Vertex<Vertice> vertice1 = graph.insertVertex(VerticeA);
        Vertex<Vertice> vertice2 = graph.insertVertex(VerticeB);
        Vertex<Vertice> vertice3 = graph.insertVertex(VerticeC);
        Vertex<Vertice> vertice4 = graph.insertVertex(VerticeD);
        Vertex<Vertice> vertice5 = graph.insertVertex(VerticeE);
        Vertex<Vertice> vertice6 = graph.insertVertex(VerticeF);
        /*
        vertices.add(vertice1);
        vertices.add(vertice2);
        vertices.add(vertice3);
        vertices.add(vertice4);
        vertices.add(vertice5);
        vertices.add(vertice6);
         */
//Aresta aresta1 = new Aresta("ARESTA1", 1);
        Aresta Aresta1 = new Aresta("ARESTA1", 1);
        Aresta Aresta2 = new Aresta("ARESTA2", 2);
        Aresta Aresta3 = new Aresta("ARESTA3", 3);
        Aresta Aresta4 = new Aresta("ARESTA4", 4);
        Aresta Aresta5 = new Aresta("ARESTA5", 5);
        Aresta Aresta6 = new Aresta("ARESTA6", 6);
        Aresta Aresta7 = new Aresta("ARESTA7", 7);
        Aresta Aresta8 = new Aresta("ARESTA8", 8);
        Aresta Aresta9 = new Aresta("ARESTA9", 9);
        Aresta Aresta10 = new Aresta("ARESTA10", 10);
        Aresta Aresta11 = new Aresta("ARESTA11", 11);
        Aresta Aresta12 = new Aresta("ARESTA12", 12);
        Aresta Aresta13 = new Aresta("ARESTA13", 13);
        Aresta Aresta14 = new Aresta("ARESTA14", 14);
        Aresta Aresta15 = new Aresta("ARESTA15", 15);

        Edge<Aresta, Vertice> edge1 = graph.insertEdge(vertice1, vertice2, Aresta1);
        Edge<Aresta, Vertice> edge2 = graph.insertEdge(vertice1, vertice3, Aresta2);
        Edge<Aresta, Vertice> edge3 = graph.insertEdge(vertice1, vertice4, Aresta3);
        Edge<Aresta, Vertice> edge4 = graph.insertEdge(vertice1, vertice5, Aresta4);
        Edge<Aresta, Vertice> edge5 = graph.insertEdge(vertice1, vertice6, Aresta5);

        Edge<Aresta, Vertice> edge6 = graph.insertEdge(vertice2, vertice3, Aresta6);
        Edge<Aresta, Vertice> edge7 = graph.insertEdge(vertice2, vertice4, Aresta7);
        Edge<Aresta, Vertice> edge8 = graph.insertEdge(vertice2, vertice5, Aresta8);
        Edge<Aresta, Vertice> edge9 = graph.insertEdge(vertice2, vertice6, Aresta9);

        Edge<Aresta, Vertice> edge10 = graph.insertEdge(vertice3, vertice4, Aresta10);
        Edge<Aresta, Vertice> edge11 = graph.insertEdge(vertice3, vertice5, Aresta11);
        Edge<Aresta, Vertice> edge12 = graph.insertEdge(vertice3, vertice6, Aresta12);

        Edge<Aresta, Vertice> edge13 = graph.insertEdge(vertice4, vertice5, Aresta13);
        Edge<Aresta, Vertice> edge14 = graph.insertEdge(vertice4, vertice6, Aresta14);

        Edge<Aresta, Vertice> edge15 = graph.insertEdge(vertice5, vertice6, Aresta15);

        edgeTest.add(edge1);
        edgeTest.add(edge2);
        edgeTest.add(edge6);

        Edges.add(edge1);
        Edges.add(edge2);
        Edges.add(edge3);
        Edges.add(edge4);
        Edges.add(edge5);
        Edges.add(edge6);
        Edges.add(edge7);
        Edges.add(edge8);
        Edges.add(edge9);
        Edges.add(edge10);
        Edges.add(edge11);
        Edges.add(edge12);
        Edges.add(edge13);
        Edges.add(edge14);
        Edges.add(edge15);
        /*
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
         */
        //  selectArestaPlayer1(edge1.element());// seleciona uma aresta do ogador 1
//        actualPlayerRemainEdges.add(edge1);
//        actualPlayerRemainEdges.add(edge2);
//        actualPlayerRemainEdges.add(edge3);
//        actualPlayerRemainEdges.add(edge4);
//        actualPlayerRemainEdges.add(edge5);
//        actualPlayerRemainEdges.add(edge6);
//        actualPlayerRemainEdges.add(edge7);
//        actualPlayerRemainEdges.add(edge8);
//        actualPlayerRemainEdges.add(edge9);
//        actualPlayerRemainEdges.add(edge10);
//        actualPlayerRemainEdges.add(edge11);
//        actualPlayerRemainEdges.add(edge12);
//        actualPlayerRemainEdges.add(edge13);
//        actualPlayerRemainEdges.add(edge14);
//        actualPlayerRemainEdges.add(edge15);

        RemainEdges.add(edge1);
        RemainEdges.add(edge2);
        RemainEdges.add(edge3);
        RemainEdges.add(edge4);
        RemainEdges.add(edge5);
        RemainEdges.add(edge6);
        RemainEdges.add(edge7);
        RemainEdges.add(edge8);
        RemainEdges.add(edge9);
        RemainEdges.add(edge10);
        RemainEdges.add(edge11);
        RemainEdges.add(edge12);
        RemainEdges.add(edge13);
        RemainEdges.add(edge14);
        RemainEdges.add(edge15);

        /*
        
        player2RemainEdges.add(edge1);
        player2RemainEdges.add(edge2);
        player2RemainEdges.add(edge3);
        player2RemainEdges.add(edge4);
        player2RemainEdges.add(edge5);
        player2RemainEdges.add(edge6);
        player2RemainEdges.add(edge7);
        player2RemainEdges.add(edge8);
        player2RemainEdges.add(edge9);
        player2RemainEdges.add(edge10);
        player2RemainEdges.add(edge11);
        player2RemainEdges.add(edge12);
        player2RemainEdges.add(edge13);
        player2RemainEdges.add(edge14);
        player2RemainEdges.add(edge15);
         */
    }

    ///////////////////////////////pc move
    public void pcMove() {
      
        Random pcMove = new Random();
        int randomMove = pcMove.nextInt(15) + 1;
        Edge<Aresta, Vertice> edgePc;
        edgePc = getArestaByID(randomMove);
        //!RemainEdges.contains(edgePc));
         configTurn();
        this.actualPlayerEdges.add(edgePc);
        if (this.turnPlayer == 1 ) {
            selectArestaPlayer1(edgePc.element());
        } else {
            selectArestaPlayer2(edgePc.element());
        }
        if (checkTriangle(actualPlayerEdges) == true) {
            getActualPlayer().incrementLoses();
            getActualPlayer().IncrementTimePlayed(getTimePlayedPlayed(this.startTime));
            System.out.println(win(getActualPlayer()));
        } else {
            changeTurn();
        }
    }
    
    
    
    public boolean validatePcMove(Edge<Aresta, Vertice> x)
     {
       
         if(RemainEdges.contains(x))
         {
             return false;
         }
         else
         {
             return true;
         }
    }

}

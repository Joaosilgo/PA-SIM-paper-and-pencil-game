/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Game.SimGame;
import static javafx.scene.input.KeyCode.V;
import javafxgraphs.Aresta;
import javafxgraphs.Vertice;
import javafxgraphs.tad.Edge;
import javafxgraphs.tad.GraphLinked;
import javafxgraphs.tad.Vertex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João
 */
public class TADtest {

    private GraphLinked graphTest;
    private Vertice VerticeA;
    private Vertice VerticeB;
    private Vertice VerticeC;
    private Vertex<Vertice> vertice1;
    private Vertex<Vertice> vertice2;
    private Vertex<Vertice> vertice3;
    private Vertex<Vertice> vertice4;

    public TADtest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // GraphLinked graphTest = new GraphLinked();
        graphTest = new GraphLinked();
        VerticeA = new Vertice("Alfa");
        VerticeB = new Vertice("Bravo");
        VerticeC = new Vertice("Charlie");
        Vertice VerticeD = new Vertice("Delta");
        Vertice VerticeE = new Vertice("Echo");
        Vertice VerticeF = new Vertice("Foxtrot");

        // Vertex<Vertice> vertice1;
        // Vertex<Vertice> vertice2;
        // Vertex<Vertice> vertice3;
        // Vertex<Vertice> vertice4;
        // Vertex<Vertice> vertice5;
        Vertex<Vertice> vertice6;

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
        Edge<Aresta, Vertice> edge1;
        Edge<Aresta, Vertice> edge2;
        Edge<Aresta, Vertice> edge3;
        Edge<Aresta, Vertice> edge4;
        Edge<Aresta, Vertice> edge5;

        Edge<Aresta, Vertice> edge6;
        Edge<Aresta, Vertice> edge7;
        Edge<Aresta, Vertice> edge8;
        Edge<Aresta, Vertice> edge9;

        Edge<Aresta, Vertice> edge10;

    }

    @Test
    public void test_insertVertex() {
        Vertice VerticeD = new Vertice("test");

        Vertex<Vertice> verticeTest = graphTest.insertVertex(VerticeD);

        assertEquals("insert Vertex", "test", verticeTest.element().getId());
    }

    @Test
    public void removeVertex() {
        Vertice VerticeD = new Vertice("test");

        Vertex<Vertice> verticeTest = graphTest.insertVertex(VerticeD);
        Vertex<Vertice> vertexRemoved;
        // V elem;            
        vertexRemoved = (Vertex<Vertice>) graphTest.removeVertex(verticeTest);
        assertEquals("remove Vertex", "test", vertexRemoved.element().getId());
    }

    @Test
    public void test_numVertices() {
        Vertice VerticeA = new Vertice("test1");
        Vertice VerticeB = new Vertice("test2");
        graphTest.insertVertex(VerticeA);
        graphTest.insertVertex(VerticeB);
        int testNum = graphTest.numVertices();
        assertEquals("Numero Vertex", 2, testNum);

    }

    @Test
    public void test_InsertEdge() {
        Vertice VerticeA = new Vertice("testA");
        Vertice VerticeB = new Vertice("testB");
        Aresta Aresta1 = new Aresta("testAresta", 1);
        //graphTest.insertVertex(VerticeA);
        //graphTest.insertVertex(VerticeB);

        Edge<Aresta, Vertice> edgeTest = graphTest.insertEdge(graphTest.insertVertex(VerticeA), graphTest.insertVertex(VerticeB), Aresta1);
        assertEquals("Edge nª ", 1, edgeTest.element().getIdAresta());
        assertEquals("Aresta A  ", "testA", edgeTest.vertices()[0].element().getId());
        assertEquals("Aresta B  ", "testB", edgeTest.vertices()[1].element().getId());
    }

    @Test
    public void test_numEdges() {
        Vertice VerticeA = new Vertice("testA");
        Vertice VerticeB = new Vertice("testB");
        Aresta Aresta1 = new Aresta("testAresta", 1);
        graphTest.insertEdge(graphTest.insertVertex(VerticeA), graphTest.insertVertex(VerticeB), Aresta1);
        int numEdges = graphTest.numEdges();
        assertEquals("Numero Edges  ", 1, numEdges);
    }

    @Test
    public void test_removeEdge() {
        Vertice VerticeA = new Vertice("testA");
        Vertice VerticeB = new Vertice("testB");
        Aresta Aresta1 = new Aresta("testAresta", 1);
        Edge<Aresta, Vertice> edgeInserted = graphTest.insertEdge(graphTest.insertVertex(VerticeA), graphTest.insertVertex(VerticeB), Aresta1);
        Edge<Aresta, Vertice> edgeRemoved = graphTest.removeEdge(edgeInserted);
        assertEquals("Edge nª ", 1, edgeRemoved.element().getIdAresta());
        assertEquals("Aresta A  ", "testA", edgeRemoved.vertices()[0].element().getId());
        assertEquals("Aresta B  ", "testB", edgeRemoved.vertices()[1].element().getId());

    }

    @Test
    public void test_replaceVertex() {
        Vertice VerticeD = new Vertice("test");
        Vertice VerticeA = new Vertice("sub");

        Vertex<Vertice> verticeTest = graphTest.insertVertex(VerticeD);

        // assertEquals("insert Vertex", "test", verticeTest.element().getId());
        int hash =graphTest.replace(verticeTest, VerticeA).hashCode();
        assertEquals("substituiçao  ", VerticeD.hashCode(), hash);

    }
    
     @Test
    public void test_replaceEdge() 
    {
         Vertice VerticeA = new Vertice("testA");
        Vertice VerticeB = new Vertice("testB");
        Aresta Aresta1 = new Aresta("testAresta1", 1);
         Vertice VerticeC = new Vertice("testC");
        Vertice VerticeD = new Vertice("testD");
         Aresta Aresta2 = new Aresta("testAresta2", 2);
        Edge<Aresta, Vertice> edgeInserted = graphTest.insertEdge(graphTest.insertVertex(VerticeA), graphTest.insertVertex(VerticeB), Aresta1);
         Edge<Aresta, Vertice> edgeSub = graphTest.insertEdge(graphTest.insertVertex(VerticeC), graphTest.insertVertex(VerticeD), Aresta2);
         
                 assertEquals("substituiçao Edge ",edgeInserted.element().hashCode(), graphTest.replace(edgeInserted,edgeSub).hashCode());
    }
    
    
     @Test
    public void test_opposite() 
    {
        Vertice VerticeA = new Vertice("testA");
        Vertice VerticeB = new Vertice("testB");
        Aresta Aresta1 = new Aresta("testAresta", 1);
        Vertex<Vertice> v =graphTest.insertVertex(VerticeA);
        Vertex<Vertice> o =graphTest.insertVertex(VerticeB);
        Edge<Aresta, Vertice> edgeInserted = graphTest.insertEdge(v, o, Aresta1);
        
        assertEquals("oposto test ",o,graphTest.opposite(v, edgeInserted));
    }
    
      @Test
    public void test_areAdjacent() 
    {
         Vertice VerticeA = new Vertice("testA");
        Vertice VerticeB = new Vertice("testB");
        Aresta Aresta1 = new Aresta("testAresta", 1);
         Vertex<Vertice> v =graphTest.insertVertex(VerticeA);
        Vertex<Vertice> o =graphTest.insertVertex(VerticeB);
         Edge<Aresta, Vertice> edgeInserted = graphTest.insertEdge(v, o, Aresta1);
    
    boolean adjacentes=  graphTest.areAdjacent(v, o);
        assertEquals("adjacent ",true, adjacentes);
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

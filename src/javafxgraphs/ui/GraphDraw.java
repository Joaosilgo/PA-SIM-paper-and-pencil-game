/*
*    GraphDraw for JavaFX
*    Copyright (C) 2016  brunomnsilva@gmail.com
*
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    any later version.
*
*   This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package javafxgraphs.ui;

import com.sun.javafx.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafxgraphs.tad.Edge;
import javafxgraphs.tad.Graph;
import javafxgraphs.tad.Vertex;

/**
 * This class represents a pane that can be used to draw a Graph structure.
 * Object-types for vertices and edges must implement the DrawableGraphElement interface.
 * 
 * Used references:
 * http://fxexperience.com/2014/05/resizable-grid-using-canvas/
 * http://stackoverflow.com/questions/16670393/java-draw-arc-between-2-points
 *
 * @author brunomnsilva
 * @param <V> type for vertex
 * @param <E> type for edge
 */
public class GraphDraw<V extends DrawableGraphElement, E extends DrawableGraphElement> extends StackPane {

    //GLOBAL CONFIGURATIONS.////////////////////////////////////////////////////
    public static String CONFIG_BACKGROUND = "white"; //pixels //deprecated

    public static int CONFIG_NODE_DIAMETER = 20; //pixels
    public static int CONFIG_NODE_STROKE_WIDTH = 2; //pixels
    public static String CONFIG_NODE_DRAW = "grey"; //pixels
    public static String CONFIG_NODE_FILL = "grey"; //pixels
    public static Font CONFIG_NODE_FONT = new Font("Verdana", 12);

    public static int CONFIG_EDGE_STROKE_WIDTH = 1;
    public static boolean CONFIG_EDGE_ARCS_LINES = false; //just lines
    public static String CONFIG_EDGE_DRAW = "black";
    public static String CONFIG_EDGE_DRAW_SELECTED1 = "yellow";
    public static String CONFIG_EDGE_DRAW_SELECTED2 = "orange";
    public static Font CONFIG_EDGE_FONT = new Font("Verdana", 10);

    ////////////////////////////////////////////////////////////////////////////
    
    
    // teste apagar
    /** the canvas to draw on */
    private final Canvas canvas = new Canvas();
    /** reference to the graph to be drawn */
    private final Graph<V, E> graph;    
    
    /** list of vertices locations on the canvas */
    private final List<VertexLocation> locations;
    /** map of locations and their indices in the <i>locations</i> list */
    private final HashMap<String, Integer> locationIndices;

    private Random randGenerator = new Random();
    /**
     * Constructor.
     * @param graph the graph to be drawn 
     */
    public GraphDraw(Graph<V, E> graph) {
        this.graph = graph;

        //locations = new HashMap<>();
        locations = new ArrayList<>();
        locationIndices = new HashMap<>();
        
        ObservableList<VertexLocation> obList ;
       
        
       
      
       
       
       
       
               
        
        getChildren().addAll(canvas );
        generatePositions();
    }

    /**
     * Generates the positions of the vertices using a circular structure.
     * Vertices and place equidistant to each other.
     */
    private void generatePositions() {
        ////////////////////////////////////////////////////////////////////////
        //TODO: Improvement: generate positions based on different strategies, 
        //e.g., enclosed in a circle, in a rectangle, etc.
        ////////////////////////////////////////////////////////////////////////
        
        if (graph == null || graph.numVertices() == 0) {
            return;
        }

        //clear previous positions (they may change when canvas is resized)
        locations.clear();

        int N = graph.numVertices();

        double width = this.getWidth();
        double height = this.getHeight();

        //System.out.println(String.format("W= %f | H = %f", width, height));
        Point2D center = new Point2D(width / 2, height / 2);

        double angleIncrement = 360f / N;

        Iterable<Vertex<V>> vertices = graph.vertices();
        ArrayList<Vertex<V>> listVertices = new ArrayList<>(N);
        for (Vertex<V> v : vertices) {
            listVertices.add(v);
        }

        ////////////////////////////////////////////////////////////////////////
        //TODO: Improvement: reorder listVertices to minimize edge crossings        
        ////////////////////////////////////////////////////////////////////////
        
        //place first vertice north position, others in clockwise manner
        boolean first = true;
        Point2D p = null;
        int index = 0;
        for (Vertex<V> v : listVertices) {

            if (first) {
                //verifiy smaller width and height. Responsiveness to resize.
                if(width > height)
                    p = new Point2D(center.getX(),
                            center.getY() - height / 2 + CONFIG_NODE_DIAMETER * 2);
                else
                    p = new Point2D(center.getX(),
                            center.getY() - width / 2 + CONFIG_NODE_DIAMETER * 2);
                
                first = false;
            } else {
                p = rotate(p, center, angleIncrement);
            }

            locations.add(index, new VertexLocation(v, p) );
            locationIndices.put(v.element().getId(), index);
            //System.out.println(v.element().getId() + " --- " + index);
            index++;
        }
    }

    /**
     * Checks if two vertices are drawn side-by-side
     * @param vla first vertex location
     * @param vlb second vertex location
     * @return vertices are drawn side-by-side
     */
    private boolean sideByside(VertexLocation vla, VertexLocation vlb) {
        int indexA = locationIndices.get(vla.vertex.element().getId());
        int indexB = locationIndices.get(vlb.vertex.element().getId());
        
        //checks if indices are consecutive or first/last
        int indexDist = Math.abs( indexA - indexB) % ( locationIndices.size() - 1);
        
        return (indexDist <= 1);
    }
    
   
    
    /**
     * Method that draws the graph using 2D primitives.
     */
    public void redraw() {
       
        generatePositions();

        double width = canvas.getWidth();
        double height = canvas.getHeight();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //fill background. Deprecated. Now transparent
        //gc.setFill(Paint.valueOf(CONFIG_BACKGROUND));
        
        gc.clearRect(0, 0, width, height);

        gc.setTextAlign(TextAlignment.CENTER);

        //DRAW EDGES    
        gc.setFont(CONFIG_EDGE_FONT);
        gc.setLineWidth(CONFIG_EDGE_STROKE_WIDTH);

        Iterable<Edge<E, V>> edges = graph.edges();
        for (Edge<E, V> edge : edges) {

            Vertex<V>[] vertices = edge.vertices();

            Vertex<V> a = vertices[0];
            Vertex<V> b = vertices[1];

            VertexLocation vla = locations.get(locationIndices.get(a.element().getId()));
            VertexLocation vlb = locations.get(locationIndices.get(b.element().getId()));
//IMPORTANTE SE A EDFE TIVER SELECIONADA PINTADE OUTA COR
            if (edge.element().isSelected1()) {
                gc.setStroke(Paint.valueOf(CONFIG_EDGE_DRAW_SELECTED1));
            }
            else if(edge.element().isSelected2())
            {
                  gc.setStroke(Paint.valueOf(CONFIG_EDGE_DRAW_SELECTED2));
            }
            else {
                gc.setStroke(Paint.valueOf(CONFIG_EDGE_DRAW));
            }

            //System.out.println(String.format("SIDE-BY-SIDE %s & %s ? %s", a.element().getId(), b.element().getId(), sideByside(vla,vlb)));
            
            if(CONFIG_EDGE_ARCS_LINES) {
                //use arcs and lines
                if(sideByside(vla,vlb)) {
                    Point2D center = new Point2D(width / 2, height / 2);

                    connectArc(gc, vla.location, vlb.location, 
                            center, 
                            edge.element().toString());
                } else {                

                    connectLine(gc, vla.location, vlb.location, edge.element().toString());
                }
                
            } else {
                //Just use lines:
                connectLine(gc, vla.location, vlb.location, edge.element().toString());
                
            }
            
        }

        //DRAW NODES
        gc.setFill(Paint.valueOf(CONFIG_NODE_FILL));
        gc.setStroke(Paint.valueOf(CONFIG_NODE_DRAW));
        //gc.setEffect(new Reflection());
        gc.setFont(CONFIG_NODE_FONT);

        for( VertexLocation vl : locations ) {
            gc.setLineWidth(CONFIG_NODE_STROKE_WIDTH);

            //draw node
            gc.strokeOval(vl.location.getX() - CONFIG_NODE_DIAMETER / 2,
                    vl.location.getY() - CONFIG_NODE_DIAMETER / 2,
                    CONFIG_NODE_DIAMETER, CONFIG_NODE_DIAMETER);

            //fill node
            gc.fillOval(vl.location.getX() - CONFIG_NODE_DIAMETER / 2,
                    vl.location.getY() - CONFIG_NODE_DIAMETER / 2,
                    CONFIG_NODE_DIAMETER, CONFIG_NODE_DIAMETER);

            //draw node name
            gc.setLineWidth(1);
            gc.strokeText(vl.vertex.element().toString(),
                    vl.location.getX(),
                    vl.location.getY() + CONFIG_NODE_DIAMETER);
        }

    }

    /**
     * Draws a line between two points with a label mid-point.
     * @param gc graphics context of canvas to draw on
     * @param a origin point
     * @param b destination point
     * @param label label to write
     */
    private static void connectLine(GraphicsContext gc, Point2D a, Point2D b, String label) {
        //draw straight line
        gc.strokeLine(a.getX(), a.getY(),
                b.getX(), b.getY());

        //draw edge text midpoint
        Point2D mid = a.midpoint(b);
                
        //rotate text so that it is parallel to the line
        //gc.strokeText(label, mid.getX(), mid.getY()); 
        double angle = -angle(a,b);
        strokeRotatedText(gc, mid, angle, label);
    }
    
    private static void strokeRotatedText(GraphicsContext gc, Point2D p, double angleDegrees, String text) 
    {    
        //to avoid stroking upside down text, correct angle. We only want angleDegrees \in [-90, 90]
        int sign = angleDegrees >= 0 ? 1 : -1;
        angleDegrees = Math.abs(angleDegrees);
        while(angleDegrees > 90) {
            angleDegrees -= 180;
        }
        angleDegrees *= sign;
        //end-fix angle
        
        gc.save(); //save current transform
        
        //apply transform rotation
        Rotate r = new Rotate(angleDegrees, p.getX(), p.getY());
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        
        //stroke the text
        gc.strokeText(text, p.getX(), p.getY());
                
        gc.restore(); //restore original transform
    }  

    /**
     * Draws an arc between two points with a label at the center of the arc.
     * @param gc graphics context of canvas to draw on
     * @param a origin point
     * @param b destination point
     * @param pivot center point
     * @param label label to write
     */
    private static void connectArc(GraphicsContext gc, Point2D a, Point2D b, Point2D pivot, String label) {
      
        double radius = a.distance(pivot);
        
        double angle_a_pivot = angle( a, pivot);
        double angle_b_pivot = angle( b, pivot) ;
        
        gc.strokeArc(pivot.getX() - radius,
                pivot.getY() - radius,
                2 * radius,
                2 * radius,
                angle_a_pivot,
                angleDiff(angle_a_pivot, angle_b_pivot),
                ArcType.OPEN);
    
        Point2D mid = rotate(a, pivot, -angleDiff(angle_a_pivot, angle_b_pivot) / 2);
        
        //rotate text so that it is parallel to the line
        //gc.strokeText(label, mid.getX(), mid.getY()); 
        double angle = -angle(a,b);
        strokeRotatedText(gc, mid, angle, label);
       
        
        //System.out.println("ARC---");
        //System.out.println("X = " + (pivot.getX() - radius));
        //System.out.println("Y = " + (pivot.getY() - radius));
        //System.out.println("width = " + 2 * radius);
        //System.out.println("radius = " + radius);
        //System.out.println("angle a = " + angle_a_pivot);
        //System.out.println("angle b = " + angle_b_pivot);
        //System.out.println("angle diff = " + angleDiff(angle_a_pivot, angle_b_pivot));
        //System.out.println("------");
    }
    
    /**
     * Return polar angle of any point relative to arc center.
     * @param p point to compute angle
     * @param pivot pivot point
     * @return polar angle
     */
    private static double angle(Point2D p, Point2D pivot) {
        //return Math.toDegrees(Math.atan2(pivot.getY() - p.getY(), p.getX() - pivot.getX()));
        double angle = Math.toDegrees(Math.atan2(pivot.getY() - p.getY(), p.getX() - pivot.getX()));
        if (angle < 0) {
            angle += 360;
        }

        return angle;
    }
    
    /**
     * Return angle different between two angles in [-180, 180[
     * @param angle_a
     * @param angle_b
     * @return 
     */
    private static double angleDiff(double angle_a, double angle_b) {
        //double 360 - angle_a - 
        
        double d = angle_b - angle_a;
        while (d >= 180) { d -= 360; }
        while (d < -180) { d += 360; }
        return d;
    }

    /**
     * Rotate a point around a pivot point by a specific degrees amount
     * @param point point to rotate
     * @param pivot pivot point
     * @param angle_degrees rotation degrees
     * @return rotated point
     */
    private static Point2D rotate(final Point2D point, final Point2D pivot, double angle_degrees) {
        double angle = Math.toRadians(angle_degrees); //angle_degrees * (Math.PI/180); //to radians
        
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        //translate to origin
        Point2D result = point.subtract(pivot);
        
        // rotate point
        Point2D rotatedOrigin = new Point2D(
                result.getX() * cos - result.getY() * sin,
                result.getX() * sin + result.getY() * cos);

        // translate point back
        result = rotatedOrigin.add(pivot);

        return result;
    }

    @Override
    protected void layoutChildren() {
        final int top = (int) snappedTopInset();
        final int right = (int) snappedRightInset();
        final int bottom = (int) snappedBottomInset();
        final int left = (int) snappedLeftInset();
        final int w = (int) getWidth() - left - right;
        final int h = (int) getHeight() - top - bottom;
        canvas.setLayoutX(left);
        canvas.setLayoutY(top);
        if (w != canvas.getWidth() || h != canvas.getHeight()) {
            canvas.setWidth(w);
            canvas.setHeight(h);
            redraw();
        }
    }

    /**
     * Helper class that stores a vertex and its generated location
     */
    private class VertexLocation {

        Vertex<V> vertex;
        Point2D location;

        public VertexLocation(Vertex<V> vertex, Point2D location) {
            this.vertex = vertex;
            this.location = location;
        }

    }

}

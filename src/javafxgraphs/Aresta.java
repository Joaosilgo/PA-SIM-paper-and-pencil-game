/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgraphs;

import javafxgraphs.ui.DrawableGraphElement;

/**
 *
 * @author Utilizador
 */
public class Aresta implements DrawableGraphElement {

    private String name;
   // private int id;
    private int IdAresta;

    private boolean selected1;
    private boolean selected2;
    
    public Aresta(String name, int IdAresta) {
        this.name = name;
        this.IdAresta = IdAresta;
       //this.id=id;
        this.selected1 = false;
        this.selected2=false;
    }

    public int getIdAresta() {
        return IdAresta;
    }

   // public int getCost() {
       // return cost;
   // }

    public void toogleSelect1() {
        selected1 = !selected1;
    }
    public void toogleSelect2() {
        selected2 = !selected2;
    }

    
    public void setSelected1(boolean selected1) {
        this.selected1 = selected1;
    }

    /**  @Override
    public int getId()
    {
    return id;
    }
     * */
    public void setSelected2(boolean selected2) {
        this.selected2 = selected2;
    }

    @Override
    public String toString() {
        return String.format("{%s }", name);        
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    public boolean isSelected1() {
        return selected1;
    }
    @Override
     public boolean isSelected2() {
        return selected2;
    }

}

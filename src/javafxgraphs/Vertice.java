/*
 * 
 */
package javafxgraphs;

import javafxgraphs.ui.DrawableGraphElement;

/**
 *
 * @author Utilizador
 */
public class Vertice  implements DrawableGraphElement {
    private String nome;

    public Vertice(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + ' ';
    }

    @Override
    public String getId() {
        return nome;
    }

    @Override
    public boolean isSelected1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
   public boolean isSelected2()
   {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}

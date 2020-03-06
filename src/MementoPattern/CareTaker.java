/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MementoPattern;

import Game.SimGame;
import java.util.Stack;

/**
 *
 * @author João
 */
public class CareTaker {

    private Stack<Memento> objMementos;

    public CareTaker() {
        objMementos = new Stack<>();
    }

    public void restoreState(SimGame obj) {
        if (objMementos.isEmpty()) {
            return;
        }
        Memento mementoObj = objMementos.pop();
        obj.setMemento(mementoObj);

    }

  public  void saveState(SimGame obj) {
        Memento mementoObj = obj.createMemento();
        objMementos.push(mementoObj);

    }
}
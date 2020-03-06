/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author João
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author brunomnsilva
 */
public class Subject {
    
    List<Observador> observers;
    
    public Subject() {
        observers = new ArrayList<>();
    }
    
    public void addObservador(Observador o) {
        if(!observers.contains(o)) {
            observers.add(o);
        }
    }
    
    public void removeObservador(Observador o) {
        observers.remove(o);
    }
    
    public void notifyAllObservers() {
        
        for (Observador observer : observers) {
            observer.update(this);
        }
        
    }
    
}

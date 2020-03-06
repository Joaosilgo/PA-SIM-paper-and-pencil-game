/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author João
 */
public class InvalidGameException extends RuntimeException {

  public InvalidGameException(String message){
     super(message);
  }

}


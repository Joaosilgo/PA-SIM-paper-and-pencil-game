/*
 * Classe que extende de RuntimeException de Exceçao que é criada para controlar as validaçoes de usuario
 */
package user;

/**
 *
 * @author João Gomes e Daniel Marques
 */
public class InvalidPlayerException extends RuntimeException {

  public InvalidPlayerException(String message){
     super(message);
  }

}

/*
 * Nesta classe nós iremos criar um utilizador em que recebe um unsername uma password e 
 * um tipo de Jogador (HUMANO OU COMPUTADOR).
*ira permitir ter o tempo jogado o numero de jogos (os que ganhou e perdeu) e as tentativas de erro os undo
* @class 
 */
package user;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author João Gomes e Daniel Marques
 */
public class User implements Serializable {

    private String username;
    private String password;
    private TypePlayer typePlayer;
    private int numberOfGames;
    private int wins;
    private int loses;
    private long timePlayed;
    private int undos;
    private boolean selecionado;
/**
  * Constructor.
  * 
  * @param username (required)  nome do utilizador ñao podendo ser nulln
  * @param password (required) passwor do utilizador.
  * @param typePlayer (required) o tipo de jogador
  */

    public User(String username, String password, TypePlayer typePlayer) {
        this.username = username;
        this.password = password;
        this.typePlayer = typePlayer;
        this.numberOfGames = 0;
        this.wins = 0;
        this.loses = 0;
        this.undos = undos;
        this.selecionado=false;
        configUndos(typePlayer);
        
    }

    public int getUndos() {
        return undos;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
   

    public boolean isSelecionado() {
        return selecionado;
    }

    public int configUndos(TypePlayer typePlayer) {
        if (typePlayer == TypePlayer.HUMAN) {
            this.undos = 1;
            return undos;
        } else {
            this.undos = 0;
            return undos;
        }
    }
    /**
     *@param username (required)  timePlayed
     * incrementa a variavel timePlayed pel valor em argumento
    */
 public void IncrementTimePlayed(long timePlayed) {
        this.timePlayed += timePlayed;
    }
  
   
   


/** Return timePlayed  do user.  */

    public long getTimePlayed() {
        return timePlayed;
    }
/** Return typePlayer  do user.  */
    public TypePlayer getTypePlayer() {
        return typePlayer;
    }
/** Return numberOfGames  do user.  */
    public int getNumberOfGames() {
        return numberOfGames;
    }
/** Return wins  do user.  */
    public int getWins() {
        return wins;
    }
/** Return loses  do user.  */
    public int getLoses() {
        return loses;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void incrementNumberOfGames() {
        this.numberOfGames++;
    }

    public void incrementWins() {
        this.wins++;
    }

    public void incrementLoses() {
        this.loses++;
    }
/** metodo que decrementa a variavel undos dada a condiçaode ser superior a 0
 * retorna true se a operaçao foi concluida ou false e uma mensagem se nao respeitar a condiçao
 */
    public boolean decrementUndos() {
        if (this.undos > 0) {
            this.undos--;
            return true;
        } else {
            System.out.println("Undos Esgotaram");
            return false;
        }
    }

}

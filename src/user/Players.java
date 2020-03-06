/*
 *Classe  que irá servir para adicionar players a uma lista de modo a salvar
a sua conta para estatistica
 */
package user;

import java.util.List;
import java.util.*;
import java.util.logging.Logger;

/**
 *
 * author João Gomes e Daniel Marques
 */
public class Players {

    private List<User> playersList;
     private List<User> playersListPC;

    public Players() {
        this.playersList = new ArrayList<>();
        User daniel = new User("Daniel", "daniel",TypePlayer.HUMAN);
        User joao = new User("Joao", "joao",TypePlayer.HUMAN);
        User pc = new User("Computer", "",TypePlayer.COMPUTER);
        playersList.add(daniel);
          playersList.add(joao);
          
          
          
          playersListPC= new ArrayList<>();
          playersListPC.add(joao);
          playersListPC.add(daniel);
          playersListPC.add(pc);
          
    }
   public User getLoginUser(String username , String password)
   {
       User i;
       for(User  item :playersList)
       {
           if(item.getUsername().equals(username) && item.getPassword().equals(password) )
           {
               i=item;
               return i;
           }
          
       }
        return null;
   }
    public List<User> getPlayersListPC() {
        return playersListPC;
    }

    public List<User> getPlayersList() {
        return playersList;
    }
    
     public String getPlayersListName() {
       ArrayList names = new  ArrayList<String>();
       for(User item: playersList)
       {
           names.add(item.getUsername());
            
       }
        return names.toString();
        
       
    }
    /**
     * adiciona um user a uma lista
     * @param player
     * @throws InvalidPlayerException 
     */
    public void addPlayer(User player) throws InvalidPlayerException {
        if (player != null) {
            if (!this.playersList.contains(player.getUsername())) {
                this.playersList.add(player);
                System.out.println("player adicionado:");
                System.out.println("-" + player.getUsername());
            } else {
                throw new InvalidPlayerException("player username alredy exist in list");
            }
        } else {
            throw new InvalidPlayerException("player invalid");
        }
    }
    
   // public String getPlayersScore()
    //{
        
    //}

    public User getPlayer(String Username) {
        for( User item: playersList)
        {
            if(item.getUsername().equals(Username))
            {
                return item;
                
            }
            }
         throw new InvalidPlayerException("Player Nao Reconhecido ");
        
    }
    
    
    public User getPlayerPC(String Username) {
        for( User item: playersListPC)
        {
            if(item.getUsername().equals(Username))
            {
                return item;
                
            }
            }
         throw new InvalidPlayerException("Player Nao Reconhecido ");
        
    }
   

}

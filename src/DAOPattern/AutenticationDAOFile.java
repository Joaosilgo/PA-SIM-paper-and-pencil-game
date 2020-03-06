/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxMenus.GamePlay;
import user.User;

/**
 *
 * @author João
 */
public class AutenticationDAOFile {
    
    private String basePath;

    public AutenticationDAOFile() {
        this.basePath = basePath;
         
    }
    
    /**
     *
     * @param s
     */
    public void saveUser(User s)
    {
      FileWriter fw = null;  
      try
      {
       
         fw = new FileWriter("logs") ;
         fw.write("Username: "+s.getUsername());
         fw.write("Password: "+s.getPassword());
         fw.close();
      }catch(IOException ex)
      {
            Logger.getLogger(AutenticationDAOFile.class.getName()).log(Level.SEVERE, null, ex);
      }finally
      {
          try
          {
              fw.close();
          }catch(IOException ex){
               Logger.getLogger(AutenticationDAOFile.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOPattern;

import user.User;

/**
 *
 * @author João
 */
public interface userDAO {
    
    public void saveUser(User s);
    public User saveUser(String  username ,String password);
    
}

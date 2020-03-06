/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Game.SimGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import user.TypePlayer;
import user.User;

/**
 *
 * @author João
 */
public class SimGameJUnitTest {

    private SimGame game;

    public SimGameJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        User user1 = new User("Joao", "gomes", TypePlayer.HUMAN);
        User user2 = new User("daniel", "jhgh", TypePlayer.HUMAN);

        this.game = new SimGame(user1, user2);
    }

    @Test
    public void test_whoPlaysFirst() {
        int value = 0;
        value = game.whoPlaysFirst();
        //assertEquals("1 ou 2",value==1 || value==2,game.whoPlaysFirst());
        assertTrue(value == 1 || value == 2);

        //assertEquals("3",true,tree.exists(3));
    }
    
    
     @Test
    public void testcheckVertices() {
        
         boolean t=game.checkTriangle(game.getEdgeTest());
        
                  
      assertEquals("3",false,t);
    }
    
    /**
     *
     */
   
   

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

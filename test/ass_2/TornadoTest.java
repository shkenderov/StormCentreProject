/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uchitelq
 */
public class TornadoTest {

    /**
     * Test of categorize method, of class Tornado.
     */
    @Test
    public void testCategorize() {
        Tornado instance = new Tornado(75,"name");
        String expResult = "F1";
        String result = instance.categorize();
        String expAdvice="Find safe room/shelter, shield yourself from debris";
        assertEquals(expAdvice,instance.getAdvice());
        assertEquals(expResult, result);
    }    
}

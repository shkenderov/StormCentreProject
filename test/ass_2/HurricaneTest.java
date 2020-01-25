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
public class HurricaneTest {
    

    /**
     * Test of categorize method, of class Hurricane.
     */
    @Test
    public void testCategorize() {
        Hurricane instance = new Hurricane(165,"name");
        String expResult = "Category Five";
        String expAdvice="Evacuate";
        String result = instance.categorize();
        assertEquals(expResult, result);
        assertEquals(expAdvice,instance.getAdvice());

    }
    
}

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
public class BlizzardTest {
    @Test
    public void testCategorize() {
        Storm instance = new Blizzard(-15,"name",75);
        String expResult = "Severe Blizzard";
        String result = instance.categorize();
        String expAdvice="Keep warm, avoid all travel.";
        assertEquals(expResult, result);
        assertEquals(expAdvice,instance.getAdvice());

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

import java.awt.event.ActionEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uchitelq
 */
public class MainScreenTest {
    

    @Test
    public void testTryParse() {
        String text = "AaBb";
        Integer expResult = null;
        Integer result = MainScreen.tryParse(text);
        assertEquals(expResult, result);
        text="1234";
        expResult=1234;
        result = MainScreen.tryParse(text);
        assertEquals(expResult, result);
    }
 
}

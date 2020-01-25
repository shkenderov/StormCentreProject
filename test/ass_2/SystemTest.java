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
public class SystemTest {

    @Test
    public void testAddStorm() {
        Storm a = new Blizzard(-5,"name",50);
        System instance = new System();
        boolean expResult = true;
        boolean result = instance.addStorm(a);
        assertEquals(expResult, result);
        Storm b = new Blizzard(-5,"name",90);
        expResult=false;
        result=instance.addStorm(a);
        assertEquals(expResult, result);
        System instance_full=new System();
        for(int i=0;i<20;i++){
            instance_full.storms[i]=new Hurricane(i,"name"+i);
        }
        a=new Tornado(100,"tor");
        result = instance_full.addStorm(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class System.
     */
    @Test
    public void testRemove() {
        String name = "name";
        System instance = new System();
        Storm a = new Blizzard(-5,"name",50);
        instance.addStorm(a);
        boolean result = instance.remove(name);
        boolean expResult = true;
        assertEquals(expResult, result);
        expResult = false;
        result = instance.remove(name);
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of view_info method, of class System.
     */
    @Test
    public void testView_info() {
        String name = "name";
        System instance = new System();
        Storm a = new Tornado(70,"name");
        instance.addStorm(a);
        String expResult = "The Tornado \"name\" is a F0, which has Wind speed of 70 mph\n Please, Find safe room/shelter, shield yourself from debris";
        String result = instance.view_info(name);
        assertEquals(expResult, result);
        expResult="No such storm in the Database";
        result = instance.view_info("eman");
        assertEquals(expResult, result);
    }

    /**
     * Test of search method, of class System.
     */
    @Test
    public void testSearch() {
        String name = "name";
        System instance = new System();
        Storm a = new Tornado(70,"name");
        instance.addStorm(a);
        Storm expResult = a;
        Storm result = instance.search(name);
        assertEquals(expResult, result);
        expResult=null;
        result = instance.search("eman");
        assertEquals(expResult, result);
    }
    
}

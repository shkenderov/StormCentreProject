/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass_2;

/**
 *
 * @author 4shkes64
 */
public class Tornado extends Storm {

    public Tornado(int WindSpeed,String name) {
        super(WindSpeed,name);
    }
@Override public String categorize(){
        if(WindSpeed>=40&&WindSpeed<=72){
            advice="Find safe room/shelter, shield yourself from debris";
            return "F0";
        }
        else if(WindSpeed>=73&&WindSpeed<=112) 
        {
            advice="Find safe room/shelter, shield yourself from debris";
            return "F1";
        }
        else if(WindSpeed>=113&&WindSpeed<=157) {
            advice="Find underground shelter, crouch near to the floor covering your head with your hands";
            return "F2";
        }
        else if(WindSpeed>=158&&WindSpeed<=205) {
            advice="Find underground shelter, crouch near to the floor covering your head with your hands";
            return "F3";
        }
        else if(WindSpeed>=206&&WindSpeed<=260) {
            advice="Find underground shelter, crouch near to the floor covering your head with your hands";
            return "F4";
        }
        
        else if(WindSpeed>261){
            advice="Find underground shelter, crouch near to the floor covering your head with your hands";
            return "F5";
        }
        else{
            advice="There is no need to panic";
            return "Unclassified tornado";
        }
    }
        @Override
    public String toString() {
    return "The Tornado \""+this.getName()+"\" is a "+this.categorize()+", which has Wind speed of "+this.getWindSpeed()+" mph\n Please, "+this.getAdvice();
    }
    
}

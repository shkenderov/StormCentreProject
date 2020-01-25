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
public class Blizzard extends Storm {
    
    
    

    public Blizzard(int temperature,String name, int WindSpeed) {
        super(WindSpeed,name);
        super.temperature = temperature;
        
    }
    @Override public String categorize(){
        if(WindSpeed>=73&&temperature<=-12){
            advice="Keep warm, avoid all travel.";
            return "Severe Blizzard";
        }
        else if(WindSpeed>=35) 
        {
            advice="Keep warm, Do not travel unless absolutely essential.";
            return "Blizzard";
        }
        else {
            advice="Take care and avoid travel if possible.";
            return "Snow Storm";
        }
    }

    


    @Override
    public String toString() {
        return "The Blizzard \""+this.getName()+"\" is a "+this.categorize()+", which has temperature of "+this.getTemperature()+" degrees and Wind speed of "+this.getWindSpeed()+" mph\n Please, "+this.getAdvice();
    }
}

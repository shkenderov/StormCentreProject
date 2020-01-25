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
public class Hurricane extends Storm {

    public Hurricane(int WindSpeed,String name) {
        super(WindSpeed,name);
    }
    
    @Override public String categorize(){
        if(WindSpeed>=74&&WindSpeed<=95){
            advice="Close storm shutters and stay away from windows";
            return "Category One";
        }
        else if(WindSpeed>=96&&WindSpeed<=110) 
        {
            advice="Close storm shutters and stay away from windows";
            return "Category Two";
        }
        else if(WindSpeed>=111&&WindSpeed<=129) {
            advice="Coastal regions are encouraged to evacuate";
            return "Category Three";
        }
        else if(WindSpeed>=130&&WindSpeed<=156) {
            advice="Evacuate";
            return "Category Four";
        }
        else if(WindSpeed>156){
            advice="Evacuate";
            return "Category Five";
        }
        else{
            advice="Close storm shutters and stay away from windows";
            return "Tropical Storm";
        }
    }
    @Override
    public String toString() {
    return "The Hurricane \""+this.getName()+"\" is a "+this.categorize()+", which has Wind speed of "+this.getWindSpeed()+" mph\n Please, "+this.getAdvice();
    }
}

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
public class System {
    Storm[] storms;

    public System() {
        storms=new Storm[20];
    }
    public boolean addStorm(Storm a){
        for(int i=0;i<20;i++){
            if(storms[i]!=null){
            if(storms[i].getName().equals(a.getName())) return false;
            }
        }
        for(int i=0;i<20;i++){
            if(storms[i]==null){
                storms[i]=a;
                return true;
                }
        }
        return false;
    } 
    public boolean remove(String name){
        for(int i=0;i<20;i++){
            if(storms[i]!=null){
                if(storms[i].getName().equals(name)){
                    storms[i]=null;
                    return true;
                }
            }
        }
        return false;
    }
    public String view_info(String name){
        for(int i=0;i<20;i++){
            if(storms[i]!=null){
                if(storms[i].getName().equals(name)){
                return storms[i].toString();
                }
            }
        }
        return "No such storm in the Database";
    }
    public Storm search(String name){
        for(int i=0;i<20;i++){
            if(storms[i]!=null){
                if(storms[i].getName().equals(name)){
                    return storms[i];
                }
            }
        }
        return null;
    }
}

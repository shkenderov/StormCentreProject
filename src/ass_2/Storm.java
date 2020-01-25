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
public abstract class Storm {

    public void setWindSpeed(int WindSpeed) {
        this.WindSpeed = WindSpeed;
    }
    protected int WindSpeed;
    protected String advice;
    protected String Name;
    protected Integer temperature;

    public String getName() {
        return Name;
    }

    @Override
    public abstract String toString();

    public String getAdvice() {
        return advice;
    }

    public int getWindSpeed() {
        return WindSpeed;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Storm(int WindSpeed,String name) {
        this.WindSpeed = WindSpeed;
        this.Name=name;
        temperature=null;
    }
    public abstract String categorize();
}

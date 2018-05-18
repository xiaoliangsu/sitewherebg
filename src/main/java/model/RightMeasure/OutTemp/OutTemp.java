package model.RightMeasure.OutTemp;

import java.util.List;

public class OutTemp {
    public  OutTemp(){}
    private double name;

    private List<String> value ;

    public void setName(double name){
        this.name = name;
    }
    public double getName(){
        return this.name;
    }
    public void setString(List<String> value){
        this.value = value;
    }
    public List<String> getString(){
        return this.value;
    }
}

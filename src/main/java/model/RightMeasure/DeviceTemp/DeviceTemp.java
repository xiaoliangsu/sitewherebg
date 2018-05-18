package model.RightMeasure.DeviceTemp;

import java.util.List;

public class DeviceTemp {
    public DeviceTemp(){}
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

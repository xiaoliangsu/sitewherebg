package model.DeviceList;

import java.util.List;

public class DeviceList {
    public DeviceList(){}
    private List<Data> data ;

    public void setData(List<Data> data){
        this.data = data;
    }
    public List<Data> getData(){
        return this.data;
    }
}

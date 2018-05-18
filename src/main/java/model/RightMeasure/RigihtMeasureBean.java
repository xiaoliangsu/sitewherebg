package model.RightMeasure;

import model.RightMeasure.DeviceTemp.DeviceTemp;
import model.RightMeasure.OutTemp.OutTemp;

import java.util.List;

public class RigihtMeasureBean {
    public RigihtMeasureBean(){}
    private List<InTemp> inTemp ;

    private List<OutTemp> outTemp ;

    private List<DeviceTemp> deviceTemp ;

    public void setInTemp(List<InTemp> inTemp){
        this.inTemp = inTemp;
    }
    public List<InTemp> getInTemp(){
        return this.inTemp;
    }
    public void setOutTemp(List<OutTemp> outTemp){
        this.outTemp = outTemp;
    }
    public List<OutTemp> getOutTemp(){
        return this.outTemp;
    }
    public void setDeviceTemp(List<DeviceTemp> deviceTemp){
        this.deviceTemp = deviceTemp;
    }
    public List<DeviceTemp> getDeviceTemp(){
        return this.deviceTemp;
    }
}

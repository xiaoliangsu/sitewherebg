package model;

public class Device {
    private String deviceType;

    private int deviceTypeNum;

    private String deviceName;

    private String deviceId;

    public void setDeviceType(String deviceType){
        this.deviceType = deviceType;
    }
    public String getDeviceType(){
        return this.deviceType;
    }
    public void setDeviceTypeNum(int deviceTypeNum){
        this.deviceTypeNum = deviceTypeNum;
    }
    public int getDeviceTypeNum(){
        return this.deviceTypeNum;
    }
    public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }
    public String getDeviceName(){
        return this.deviceName;
    }
    public void setDeviceId(String deviceId){
        this.deviceId = deviceId;
    }
    public String getDeviceId(){
        return this.deviceId;
    }
}

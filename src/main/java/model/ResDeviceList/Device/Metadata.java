package model.ResDeviceList.Device;

public class Metadata {
    public Metadata(){}

    private String centerLatitude;

    private String locationDetial;

    private String centerLongitude;

    private String locationCity;

    public void setCenterLatitude(String centerLatitude){
        this.centerLatitude = centerLatitude;
    }
    public String getCenterLatitude(){
        return this.centerLatitude;
    }
    public void setLocationDetial(String locationDetial){
        this.locationDetial = locationDetial;
    }
    public String getLocationDetial(){
        return this.locationDetial;
    }
    public void setCenterLongitude(String centerLongitude){
        this.centerLongitude = centerLongitude;
    }
    public String getCenterLongitude(){
        return this.centerLongitude;
    }
    public void setLocationCity(String locationCity){
        this.locationCity = locationCity;
    }
    public String getLocationCity(){
        return this.locationCity;
    }
}

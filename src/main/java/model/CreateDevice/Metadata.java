package model.CreateDevice;

public class Metadata {
    public Metadata(){}
    private String locationCity;

    private String locationDetial;

    private String centerLatitude;

    private String centerLongitude;

    public void setLocationCity(String locationCity){
        this.locationCity = locationCity;
    }
    public String getLocationCity(){
        return this.locationCity;
    }
    public void setLocationDetial(String locationDetial){
        this.locationDetial = locationDetial;
    }
    public String getLocationDetial(){
        return this.locationDetial;
    }
    public void setCenterLatitude(String centerLatitude){
        this.centerLatitude = centerLatitude;
    }
    public String getCenterLatitude(){
        return this.centerLatitude;
    }
    public void setCenterLongitude(String centerLongitude){
        this.centerLongitude = centerLongitude;
    }
    public String getCenterLongitude(){
        return this.centerLongitude;
    }
}

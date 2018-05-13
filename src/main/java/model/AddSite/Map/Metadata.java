package model.AddSite.Map;

public class Metadata {
    private String zoomLevel;

    private String centerLatitude;

    private String centerLongitude;

    public void setZoomLevel(String zoomLevel){
        this.zoomLevel = zoomLevel;
    }
    public String getZoomLevel(){
        return this.zoomLevel;
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

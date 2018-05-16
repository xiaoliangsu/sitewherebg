package model.DeviceList;

public class Data {
    public Data(){}
    private String hardwareId;

    private String assetName;

    private String comments;

    private String locationCity;

    private String locationDetial;

    private String name;

    private String id;

    private String emailAddress;

    private String centerLatitude;

    private String centerLongitude;
    private String assignToken;
    public void setAssignToken(String assignToken){
        this.assignToken = assignToken;
    }
    public String getAssignToken(){
        return this.assignToken;
    }
    public void setHardwareId(String hardwareId){
        this.hardwareId = hardwareId;
    }
    public String getHardwareId(){
        return this.hardwareId;
    }
    public void setAssetName(String assetName){
        this.assetName = assetName;
    }
    public String getAssetName(){
        return this.assetName;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public String getComments(){
        return this.comments;
    }
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
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress(){
        return this.emailAddress;
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

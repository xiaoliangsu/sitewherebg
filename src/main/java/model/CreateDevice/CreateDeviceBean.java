package model.CreateDevice;

public class CreateDeviceBean {
    public CreateDeviceBean(){}
    private String hardwareId;

    private String siteToken;

    private String specificationToken;

    private String comments;

    private Metadata metadata;

    private String sitewhereToken;

    private String centerLatitude;

    private String centerLongitude;

    public void setHardwareId(String hardwareId){
        this.hardwareId = hardwareId;
    }
    public String getHardwareId(){
        return this.hardwareId;
    }
    public void setSiteToken(String siteToken){
        this.siteToken = siteToken;
    }
    public String getSiteToken(){
        return this.siteToken;
    }
    public void setSpecificationToken(String specificationToken){
        this.specificationToken = specificationToken;
    }
    public String getSpecificationToken(){
        return this.specificationToken;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public String getComments(){
        return this.comments;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
    public void setSitewhereToken(String sitewhereToken){
        this.sitewhereToken = sitewhereToken;
    }
    public String getSitewhereToken(){
        return this.sitewhereToken;
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

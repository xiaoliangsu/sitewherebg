package model.AllDevice;

public class Assignment {
    public Assignment(){}
    private String createdDate;

    private String createdBy;

    private boolean deleted;

    private String token;

    private String deviceHardwareId;

    private String assignmentType;

    private String assetModuleId;

    private String assetId;

    private String assetName;

    private String assetImageUrl;

    private String siteToken;

    private String status;

    private String activeDate;

    private State state;

//    private Metadata metadata;

    public void setCreatedDate(String createdDate){
        this.createdDate = createdDate;
    }
    public String getCreatedDate(){
        return this.createdDate;
    }
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    public String getCreatedBy(){
        return this.createdBy;
    }
    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }
    public boolean getDeleted(){
        return this.deleted;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }
    public void setDeviceHardwareId(String deviceHardwareId){
        this.deviceHardwareId = deviceHardwareId;
    }
    public String getDeviceHardwareId(){
        return this.deviceHardwareId;
    }
    public void setAssignmentType(String assignmentType){
        this.assignmentType = assignmentType;
    }
    public String getAssignmentType(){
        return this.assignmentType;
    }
    public void setAssetModuleId(String assetModuleId){
        this.assetModuleId = assetModuleId;
    }
    public String getAssetModuleId(){
        return this.assetModuleId;
    }
    public void setAssetId(String assetId){
        this.assetId = assetId;
    }
    public String getAssetId(){
        return this.assetId;
    }
    public void setAssetName(String assetName){
        this.assetName = assetName;
    }
    public String getAssetName(){
        return this.assetName;
    }
    public void setAssetImageUrl(String assetImageUrl){
        this.assetImageUrl = assetImageUrl;
    }
    public String getAssetImageUrl(){
        return this.assetImageUrl;
    }
    public void setSiteToken(String siteToken){
        this.siteToken = siteToken;
    }
    public String getSiteToken(){
        return this.siteToken;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setActiveDate(String activeDate){
        this.activeDate = activeDate;
    }
    public String getActiveDate(){
        return this.activeDate;
    }
    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return this.state;
    }
//    public void setMetadata(Metadata metadata){
//        this.metadata = metadata;
//    }
//    public Metadata getMetadata(){
//        return this.metadata;
//    }
}

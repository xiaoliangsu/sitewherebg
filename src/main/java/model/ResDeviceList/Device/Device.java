package model.ResDeviceList.Device;

import java.util.List;

public class Device {
    public Device(){}
    private String createdDate;

    private String createdBy;

    private boolean deleted;

    private String hardwareId;

    private String siteToken;

    private String specificationToken;

    private List<DeviceElementMappings> deviceElementMappings ;

    private String comments;

    private String assignmentToken;

    private String assetId;

    private String assetName;

    private String assetImageUrl;

    private Metadata metadata;

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
    public void setDeviceElementMappings(List<DeviceElementMappings> deviceElementMappings){
        this.deviceElementMappings = deviceElementMappings;
    }
    public List<DeviceElementMappings> getDeviceElementMappings(){
        return this.deviceElementMappings;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public String getComments(){
        return this.comments;
    }
    public void setAssignmentToken(String assignmentToken){
        this.assignmentToken = assignmentToken;
    }
    public String getAssignmentToken(){
        return this.assignmentToken;
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
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}

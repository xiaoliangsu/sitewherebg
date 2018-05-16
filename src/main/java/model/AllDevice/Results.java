package model.AllDevice;

import java.util.List;

public class Results {
    public  Results(){}
    private String createdDate;

    private String createdBy;

    private boolean deleted;

    private String hardwareId;

    private String siteToken;

    private List<DeviceElementMappings> deviceElementMappings ;

    private String comments;

    private Specification specification;

    private Assignment assignment;

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
    public void setSpecification(Specification specification){
        this.specification = specification;
    }
    public Specification getSpecification(){
        return this.specification;
    }
    public void setAssignment(Assignment assignment){
        this.assignment = assignment;
    }
    public Assignment getAssignment(){
        return this.assignment;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}

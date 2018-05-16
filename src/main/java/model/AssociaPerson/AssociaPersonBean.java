package model.AssociaPerson;

public class AssociaPersonBean {
    public AssociaPersonBean(){}
    private String deviceHardwareId;

    private String assignmentType;

    private String assetModuleId;

    private String assetId;

    private Metadata metadata;

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
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}

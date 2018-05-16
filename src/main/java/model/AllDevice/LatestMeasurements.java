package model.AllDevice;

public class LatestMeasurements {
    public LatestMeasurements(){}
    private String id;

    private String eventType;

    private String siteToken;

    private String deviceAssignmentToken;

    private String assignmentType;

    private String assetModuleId;

    private String assetId;

    private String eventDate;

    private String receivedDate;

    private String name;

    private double value;

//    private Metadata metadata;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setEventType(String eventType){
        this.eventType = eventType;
    }
    public String getEventType(){
        return this.eventType;
    }
    public void setSiteToken(String siteToken){
        this.siteToken = siteToken;
    }
    public String getSiteToken(){
        return this.siteToken;
    }
    public void setDeviceAssignmentToken(String deviceAssignmentToken){
        this.deviceAssignmentToken = deviceAssignmentToken;
    }
    public String getDeviceAssignmentToken(){
        return this.deviceAssignmentToken;
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
    public void setEventDate(String eventDate){
        this.eventDate = eventDate;
    }
    public String getEventDate(){
        return this.eventDate;
    }
    public void setReceivedDate(String receivedDate){
        this.receivedDate = receivedDate;
    }
    public String getReceivedDate(){
        return this.receivedDate;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setValue(double value){
        this.value = value;
    }
    public double getValue(){
        return this.value;
    }
//    public void setMetadata(Metadata metadata){
//        this.metadata = metadata;
//    }
//    public Metadata getMetadata(){
//        return this.metadata;
//    }
}

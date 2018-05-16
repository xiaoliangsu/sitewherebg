package model.AllDevice;

public class Specification {
    public Specification(){}
    private String createdDate;

    private String createdBy;

    private boolean deleted;

    private String token;

    private String name;

    private String assetModuleId;

    private String assetId;

    private String assetName;

    private String assetImageUrl;

    private Asset asset;

    private String containerPolicy;

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
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
    public void setAsset(Asset asset){
        this.asset = asset;
    }
    public Asset getAsset(){
        return this.asset;
    }
    public void setContainerPolicy(String containerPolicy){
        this.containerPolicy = containerPolicy;
    }
    public String getContainerPolicy(){
        return this.containerPolicy;
    }
//    public void setMetadata(Metadata metadata){
//        this.metadata = metadata;
//    }
//    public Metadata getMetadata(){
//        return this.metadata;
//    }
}

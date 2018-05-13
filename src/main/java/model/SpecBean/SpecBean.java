package model.SpecBean;

public class SpecBean {
    private String assetId;

    private String assetModuleId;

    private String containerPolicy;

    private Metadata metadata;

    private String name;

    public void setAssetId(String assetId){
        this.assetId = assetId;
    }
    public String getAssetId(){
        return this.assetId;
    }
    public void setAssetModuleId(String assetModuleId){
        this.assetModuleId = assetModuleId;
    }
    public String getAssetModuleId(){
        return this.assetModuleId;
    }
    public void setContainerPolicy(String containerPolicy){
        this.containerPolicy = containerPolicy;
    }
    public String getContainerPolicy(){
        return this.containerPolicy;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

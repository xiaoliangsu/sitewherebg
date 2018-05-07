package model;

public class AssetsBean {
    private String id;
    private String name;
    private String assetType;
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
    public String getAssetType() {
        return assetType;
    }
}

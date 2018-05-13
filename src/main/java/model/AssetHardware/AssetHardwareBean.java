package model.AssetHardware;

public class AssetHardwareBean {
    private String id;

    private String name;

    private String imageUrl;

    private Properties properties;

    private String sku;

    private String description;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setProperties(Properties properties){
        this.properties = properties;
    }
    public Properties getProperties(){
        return this.properties;
    }
    public void setSku(String sku){
        this.sku = sku;
    }
    public String getSku(){
        return this.sku;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}

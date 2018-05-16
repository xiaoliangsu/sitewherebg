package model.ResDeviceList;

import java.util.List;

public class AssociatedPerson {
//    public AssociatedPerson(){}

    private String id;

    private String name;

    private String type;

    private String assetCategoryId;

    private String imageUrl;

    private Properties properties;

    private String userName;

    private String emailAddress;

    private List<Roles> roles ;

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
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setAssetCategoryId(String assetCategoryId){
        this.assetCategoryId = assetCategoryId;
    }
    public String getAssetCategoryId(){
        return this.assetCategoryId;
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
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress(){
        return this.emailAddress;
    }
    public void setRoles(List<Roles> roles){
        this.roles = roles;
    }
    public List<Roles> getRoles(){
        return this.roles;
    }
}

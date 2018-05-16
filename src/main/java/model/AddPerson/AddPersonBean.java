package model.AddPerson;

public class AddPersonBean {
    public AddPersonBean(){}
    private String emailAddress;

    private String id;

    private String imageUrl;

    private String name;

    private Properties properties;

    private String userName;

    private String sitewhereToken;

    private String deviceHardwareId;

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress(){
        return this.emailAddress;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
    public void setSitewhereToken(String sitewhereToken){
        this.sitewhereToken = sitewhereToken;
    }
    public String getSitewhereToken(){
        return this.sitewhereToken;
    }
    public void setDeviceHardwareId(String deviceHardwareId){
        this.deviceHardwareId = deviceHardwareId;
    }
    public String getDeviceHardwareId(){
        return this.deviceHardwareId;
    }
}

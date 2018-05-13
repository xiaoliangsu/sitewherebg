package model;

public class DeviceInfoBean {
    private String name;

    private String siteToken;

    private String specificationToken;

    private String sitewhereToken;
    private String specName;
    public void setSpecName(String specName){
        this.specName = specName;
    }
    public String getSpecName(){
        return this.specName;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
    public void setSitewhereToken(String sitewhereToken){
        this.sitewhereToken = sitewhereToken;
    }
    public String getSitewhereToken(){
        return this.sitewhereToken;
    }
}

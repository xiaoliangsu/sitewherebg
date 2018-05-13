package model.AddSite;

import model.AddSite.Map.Map;


public class AddSiteBean {
    private String sitewhereToken;

    private Metadata metadata;

    private String name;

    private String description;

    private Map map;

    public void setSitewhereToken(String sitewhereToken){
        this.sitewhereToken = sitewhereToken;
    }
    public String getSitewhereToken(){
        return this.sitewhereToken;
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
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setMap(Map map){
        this.map = map;
    }
    public Map getMap(){
        return this.map;
    }
}

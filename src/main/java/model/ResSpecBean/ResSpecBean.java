package model.ResSpecBean;

import java.util.List;

public class ResSpecBean {
    private String createdDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;

    private boolean deleted;

    private String token;

    private String specificationToken;

    private String namespace;

    private String name;

    private String description;

    private List<Parameters> parameters ;

    private Metadata metadata;

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
    public void setUpdatedDate(String updatedDate){
        this.updatedDate = updatedDate;
    }
    public String getUpdatedDate(){
        return this.updatedDate;
    }
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    public String getUpdatedBy(){
        return this.updatedBy;
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
    public void setSpecificationToken(String specificationToken){
        this.specificationToken = specificationToken;
    }
    public String getSpecificationToken(){
        return this.specificationToken;
    }
    public void setNamespace(String namespace){
        this.namespace = namespace;
    }
    public String getNamespace(){
        return this.namespace;
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
    public void setParameters(List<Parameters> parameters){
        this.parameters = parameters;
    }
    public List<Parameters> getParameters(){
        return this.parameters;
    }
    public void setMetadata(Metadata metadata){
        this.metadata = metadata;
    }
    public Metadata getMetadata(){
        return this.metadata;
    }
}

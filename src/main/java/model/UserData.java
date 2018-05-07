package model;

public class UserData {
    private String tenantToken;

    private String name;

    public void setTenantToken(String tenantToken){
        this.tenantToken = tenantToken;
    }
    public String getTenantToken(){
        return this.tenantToken;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

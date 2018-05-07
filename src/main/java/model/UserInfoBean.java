package model;

import java.util.List;

public class UserInfoBean
{
    private String name;

    private int pwd;

    private String unitName;

    private String unitId;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPwd(int pwd){
        this.pwd = pwd;
    }
    public int getPwd(){
        return this.pwd;
    }
    public void setUnitName(String unitName){
        this.unitName = unitName;
    }
    public String getUnitName(){
        return this.unitName;
    }
    public void setUnitId(String unitId){
        this.unitId = unitId;
    }
    public String getUnitId(){
        return this.unitId;
    }
}

package model;

public class LoginStatusBean {
    private int status;

    private String msg;

    private UserData userData;

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setUserData(UserData userData){
        this.userData = userData;
    }
    public UserData getUserData(){
        return this.userData;
    }
}

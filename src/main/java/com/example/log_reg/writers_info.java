package com.example.log_reg;

import javafx.beans.property.SimpleStringProperty;

public class writers_info {
    private SimpleStringProperty userName;
    private String email;

    private String userPass;

    public writers_info(String userName,String email,String userPass){
        this.userName=new SimpleStringProperty(userName);
        this.email=email;
        this.userPass=userPass;
    }



    public String getUserName() {
        return userName.get();
    }
    public void setUserName(String userName){
        this.userName= new SimpleStringProperty(userName);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass){
        this.userPass=userPass;
    }
}

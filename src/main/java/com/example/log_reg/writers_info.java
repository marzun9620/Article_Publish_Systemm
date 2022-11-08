package com.example.log_reg;

public class writers_info {
    private String name;
    private String email;
    private String action;
    public writers_info(String name,String email,String action){
        this.action=action;
        this.name=name;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAction() {
        return action;
    }
}

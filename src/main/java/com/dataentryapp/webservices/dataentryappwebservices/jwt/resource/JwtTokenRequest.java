package com.dataentryapp.webservices.dataentryappwebservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;

//    {
//    	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW1pIiwiZXhwIjoxNjQxODU3NDY0LCJpYXQiOjE2NDEyNTI2NjR9.v9bFGbD5BIB3Ep1rnbNVTugkV1QBypBZaCm7AqY5IxHZ1PM3rkM-jwYtM-5t9PK78CIjf6q0ErnkG8kLzyUxLA"
//    }
    
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


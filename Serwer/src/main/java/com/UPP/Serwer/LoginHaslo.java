package com.UPP.Serwer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginHaslo {
    private String login;
    private String haslo;

    public LoginHaslo(){}
    public LoginHaslo(@JsonProperty("login") String login,
                      @JsonProperty("haslo") String haslo){
        this.login = login;
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}

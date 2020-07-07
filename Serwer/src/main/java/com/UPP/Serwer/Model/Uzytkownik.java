package com.UPP.Serwer.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Uzytkownik implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eska;
    private String login;
    private String haslo;
    private String imie;
    private String dataRejestracji;
    private String emailUczelniany;
    private String emailPrywatny;

    public Uzytkownik(){}
    public Uzytkownik(String eska, String login, String haslo, String imie, String dataRejestracji, String emailUczelniany, String emailPrywatny){
        this.eska = eska;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.dataRejestracji = dataRejestracji;
        this.emailUczelniany = emailUczelniany;
        this.emailPrywatny = emailPrywatny;

    }

    public String getEska() {
        return eska;
    }

    public void setEska(String eska) {
        this.eska = eska;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDataRejestracji() {
        return dataRejestracji;
    }

    public void setDataRejestracji(String dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    public String getEmailUczelniany() {
        return emailUczelniany;
    }

    public void setEmailUczelniany(String emailUczelniany) {
        this.emailUczelniany = emailUczelniany;
    }

    public String getEmailPrywatny() {
        return emailPrywatny;
    }

    public void setEmailPrywatny(String emailPrywatny) {
        this.emailPrywatny = emailPrywatny;
    }
}

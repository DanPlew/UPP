package com.UPP.Serwer.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Temat implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private String opis;
    private String dataUtworzenia;
    private String ostatnioDodane;

    private Long uzytkownik_id;

    public Temat(){}
    public Temat(String nazwa, String opis, String dataUtworzenia, String ostatnioDodane, Long uzytkownik_id){
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataUtworzenia = dataUtworzenia;
        this.ostatnioDodane = ostatnioDodane;
        this.uzytkownik_id = uzytkownik_id;
    }

    public Long getUzytkownik_id() {
        return uzytkownik_id;
    }

    public void setUzytkownik_id(Long uzytkownik_id) {
        this.uzytkownik_id = uzytkownik_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public String getOstatnioDodane() {
        return ostatnioDodane;
    }

    public void setOstatnioDodane(String ostatnioDodane) {
        this.ostatnioDodane = ostatnioDodane;
    }
}

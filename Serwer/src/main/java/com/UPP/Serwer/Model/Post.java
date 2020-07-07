package com.UPP.Serwer.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wiadomosc;
    private String dataUtworzenia;

    private Long uzytkownik_id;
    private Long temat_id;

    public Post(){}
    public Post(String wiadomosc, String dataUtworzenia, Long uzytkownik_id, Long temat_id){
        this.wiadomosc = wiadomosc;
        this.dataUtworzenia = dataUtworzenia;
        this.uzytkownik_id = uzytkownik_id;
        this.temat_id = temat_id;
    }

    public Long getUzytkownik_id() {
        return uzytkownik_id;
    }

    public void setUzytkownik_id(Long uzytkownik_id) {
        this.uzytkownik_id = uzytkownik_id;
    }

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public Long getTemat_id() {
        return temat_id;
    }

    public void setTemat_id(Long temat_id) {
        this.temat_id = temat_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }

}

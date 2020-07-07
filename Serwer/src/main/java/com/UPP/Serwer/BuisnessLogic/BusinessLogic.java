package com.UPP.Serwer.BuisnessLogic;

import com.UPP.Serwer.Model.Post;
import com.UPP.Serwer.Model.Temat;
import com.UPP.Serwer.Model.Uzytkownik;
import com.UPP.Serwer.RepositoryInterface.PostDBRepository;
import com.UPP.Serwer.RepositoryInterface.TematDBRepository;
import com.UPP.Serwer.RepositoryInterface.UzytkownikDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BusinessLogic {

    private UzytkownikDBRepository uzytkownikDBRepository;
    private TematDBRepository tematDBRepository;
    private PostDBRepository postDBRepository;

    private Temat temat;
    private Uzytkownik uzytkownik;
    private Post post;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BusinessLogic(@Autowired UzytkownikDBRepository uzytkownikDBRepository,
                         @Autowired TematDBRepository tematDBRepository,
                         @Autowired PostDBRepository postDBRepository) {
        this.uzytkownikDBRepository = uzytkownikDBRepository;
        this.tematDBRepository = tematDBRepository;
        this.postDBRepository = postDBRepository;
    }

    public Temat getTemat() {
        return temat;
    }

    public void setTemat(Long idTemat) {
        temat = tematDBRepository.findById(idTemat).orElse(null);
    }
    public void setTemat(Temat temat) {
        this.temat = temat;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void saveTemat(){
        LocalDate localDate = LocalDate.now();
        temat.setDataUtworzenia(dateTimeFormatter.format(localDate));
        temat.setUzytkownik_id(uzytkownik.getId());
        tematDBRepository.save(temat);
    }

    public void savePost(){
        LocalDate localDate = LocalDate.now();
        post.setDataUtworzenia(dateTimeFormatter.format(localDate));
        post.setUzytkownik_id(uzytkownik.getId());
        post.setTemat_id(temat.getId());
        postDBRepository.save(post);

        tematDBRepository.updateTemat(post.getDataUtworzenia(), temat.getId());
    }
}

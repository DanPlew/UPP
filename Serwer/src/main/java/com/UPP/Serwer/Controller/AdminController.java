package com.UPP.Serwer.Controller;

import com.UPP.Serwer.Model.Post;
import com.UPP.Serwer.Model.Temat;
import com.UPP.Serwer.Model.Uzytkownik;
import com.UPP.Serwer.RepositoryInterface.PostDBRepository;
import com.UPP.Serwer.RepositoryInterface.TematDBRepository;
import com.UPP.Serwer.RepositoryInterface.UzytkownikDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private PostDBRepository postDBRepository;
    private TematDBRepository tematDBRepository;
    private UzytkownikDBRepository uzytkownikDBRepository;

    public AdminController(@Autowired PostDBRepository postDBRepository,
                          @Autowired TematDBRepository tematDBRepository,
                          @Autowired UzytkownikDBRepository uzytkownikDBRepository) {
        this.postDBRepository = postDBRepository;
        this.tematDBRepository = tematDBRepository;
        this.uzytkownikDBRepository = uzytkownikDBRepository;

        uzytkownikDBRepository.save(new Uzytkownik("S17198", "admin", "qwe", "Daniel", "26/06/2020", "S17198@pjwstk.edu.pl", "dpplewinski@gmail.com"));
        uzytkownikDBRepository.save(new Uzytkownik("S16607", "moder", "qwe", "Hubert", "26/06/2020", "S16607@pjwstk.edu.pl", null));

        tematDBRepository.save(new Temat("Problemy w Javie 11", "Prosze o pomoc w rowiązaniu problemu castingu", "26/06/2020", "20/06/2020",1l));
        tematDBRepository.save(new Temat("Spring Framework", "Pilna pomoc w rozwiązaniu mapowania", "26/06/2020", "20/06/2020", 2l));

        postDBRepository.save(new Post("Restart komputera zawsze pomaga", "26/06/2020", 1l, 1l));
        postDBRepository.save(new Post("Nie prawda, format dysku C jest jedynie istotny", "26/06/2020", 2l, 1l));
        postDBRepository.save(new Post("Restart komputera zawsze pomaga", "26/06/2020", 1l, 2l));
    }

    @GetMapping("X")
    public String panelAdministracyjny(Model model){
        Iterable<Uzytkownik> uzytkownicy = uzytkownikDBRepository.findAll();
        Iterable<Temat> tematy = tematDBRepository.findAll();
        Iterable<Post> posty = postDBRepository.findAll();

        model.addAttribute("users", uzytkownicy);
        model.addAttribute("tematy", tematy);
        model.addAttribute("posty", posty);

        return "PanelAdministracyjny";
    }
}

/*      model.addAttribute("user", new Uzytkownik());
        model.addAttribute(new Temat());
        model.addAttribute(new Post());
        */
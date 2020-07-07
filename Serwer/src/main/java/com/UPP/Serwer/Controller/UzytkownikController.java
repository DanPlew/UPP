package com.UPP.Serwer.Controller;

import com.UPP.Serwer.BuisnessLogic.BusinessLogic;
import com.UPP.Serwer.LoginHaslo;
import com.UPP.Serwer.Model.Uzytkownik;
import com.UPP.Serwer.RepositoryInterface.UzytkownikDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UzytkownikController{

    private BusinessLogic businessLogic;
    private Uzytkownik uzytkownik;
    private UzytkownikDBRepository uzytkownikDBRepository;

    public UzytkownikController(@Autowired UzytkownikDBRepository uzytkownikDBRepository,
                                @Autowired BusinessLogic businessLogic){
        this.uzytkownikDBRepository = uzytkownikDBRepository;
        this.businessLogic = businessLogic;
    }

    @GetMapping
    public String EkranLogowania(Model model){
        model.addAttribute("LoginHaslo", new LoginHaslo());
        return "EkranLogowania";
    }

    @PostMapping
    public String ZalogowanieDoSytemu(@RequestParam(name = "login") String login,
                                      @RequestParam(name = "haslo") String haslo,
                                      Model model)
    {
        List<Uzytkownik> users = uzytkownikDBRepository.findAll();
        List<Uzytkownik> result = users.stream().filter(user -> user.getLogin().equals(login) && user.getHaslo().equals(haslo)).collect(Collectors.toList());

        if(result.isEmpty()) return "redirect:/";
        else{
            businessLogic.setUzytkownik(result.get(0));
            return "redirect:/StronaGlowna";
        }
    }
}
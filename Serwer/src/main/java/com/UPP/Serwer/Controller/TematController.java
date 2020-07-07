package com.UPP.Serwer.Controller;

import com.UPP.Serwer.BuisnessLogic.BusinessLogic;
import com.UPP.Serwer.Model.Post;
import com.UPP.Serwer.Model.Temat;
import com.UPP.Serwer.RepositoryInterface.TematDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TematController {

    private BusinessLogic businessLogic;
    private TematDBRepository tematDBRepository;

    public TematController(@Autowired TematDBRepository tematDBRepository,
                           @Autowired BusinessLogic businessLogic){
        this.tematDBRepository = tematDBRepository;
        this.businessLogic = businessLogic;
    }

    @GetMapping("/StronaGlowna")
    public String stronaGlowna(Model model){
        List<Temat> tematy = tematDBRepository.findAll();
        model.addAttribute("temat", new Temat());
        model.addAttribute("tematy", tematy);

        model.addAttribute("user",businessLogic.getUzytkownik());
        return "StronaGlowna";
    }

    @PostMapping("StronaGlowna")
    public String dodajTemat(@ModelAttribute Temat temat){
     businessLogic.setTemat(temat);
     businessLogic.saveTemat();
     return "redirect:/StronaGlowna";
    }
}

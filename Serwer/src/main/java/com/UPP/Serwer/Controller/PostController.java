package com.UPP.Serwer.Controller;

import com.UPP.Serwer.BuisnessLogic.BusinessLogic;
import com.UPP.Serwer.Model.Post;
import com.UPP.Serwer.Model.Uzytkownik;
import com.UPP.Serwer.RepositoryInterface.PostDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PostController {

    private BusinessLogic businessLogic;
    private PostDBRepository postDBRepository;

    public PostController(@Autowired PostDBRepository postDBRepository,
                          @Autowired BusinessLogic businessLogic){
        this.postDBRepository = postDBRepository;
        this.businessLogic = businessLogic;
    }

    @GetMapping("/temat")
    public String temat(@RequestParam("id") Long id, Model model){
        model.addAttribute("post", new Post());
        List<Post> posty = postDBRepository.findAll();
        List<Post> postyWTemacie = posty.stream().filter(post -> post.getTemat_id() == id).collect(Collectors.toList());
        model.addAttribute("posty", postyWTemacie);
        businessLogic.setTemat(id);
        return "Temat";
    }

    @PostMapping("/temat")
    public String dodajPost(@ModelAttribute Post post){
        System.out.println(post.getWiadomosc());
        businessLogic.setPost(post);
        businessLogic.savePost();
        return "redirect:/temat?id=" + businessLogic.getTemat().getId();
    }

}

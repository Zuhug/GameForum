package top.zugovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.zugovo.entity.PokeInfo;
import top.zugovo.service.QueryPokesService;

import javax.servlet.http.HttpSession;

@Controller
public class DisplayPokeController {

    @Autowired
    private QueryPokesService pokeService;

    private PokeInfo poke;

    public void setPokeService(QueryPokesService pokeService) {
        this.pokeService = pokeService;
    }

    /**
     * 展示宝可梦基本信息
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public String display(HttpSession session, @PathVariable int id) {
        poke = pokeService.queryPoke(id);
        session.setAttribute("poke", poke);
        return "redirect:/detail";
    }


}

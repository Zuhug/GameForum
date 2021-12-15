package top.zugovo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.zugovo.entity.PokeInfo;
import top.zugovo.service.QueryPokesService;

@Controller
public class SearchController {

    @Autowired
    private QueryPokesService service;

    public void setService(QueryPokesService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public String queryPokeInfoByName(String pokename) {
        PokeInfo pokeInfo = service.queryPokeByName(pokename);
        if (pokeInfo == null) return "redirect:/error/404";
        return "redirect:/detail/"+pokeInfo.getId();
    }

}

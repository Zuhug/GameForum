package top.zugovo.service;

import top.zugovo.entity.PokeInfo;

public interface QueryPokesService {

    public PokeInfo queryPoke(Integer id);

    public PokeInfo queryPokeByName(String name);

}

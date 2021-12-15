package top.zugovo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zugovo.entity.PokeFeature;
import top.zugovo.entity.PokeInfo;
import top.zugovo.mapper.PokeInfoMapper;
import top.zugovo.service.QueryPokesService;

import java.util.List;

/**
 * 实现查询宝可梦信息的业务
 */
@Service
public class QueryPokesServiceImpl implements QueryPokesService {

    @Autowired
    private PokeInfoMapper pokeInfoMapper;
    private PokeInfo poke = new PokeInfo();

    public void setPokeInfoMapper(PokeInfoMapper pokeInfoMapper) {
        this.pokeInfoMapper = pokeInfoMapper;
    }

    /**
     * 实现查询宝可梦信息的业务
     * @param id 宝可梦的编号
     * @return poke: 宝可梦的基本信息 + 属性 + 特征
     */
    @Override
    public PokeInfo queryPoke(Integer id) {
        // 查询 宝可梦基本信息 + 属性
        poke = pokeInfoMapper.findAttributeFromPokeInfo(id);
        // 查询 宝可梦的特性
        List<PokeFeature> features = pokeInfoMapper.findFeatureFromPokeInfo(id);
        poke.setPokeFeatures(features);
        return poke;
    }

    @Override
    public PokeInfo queryPokeByName(String name) {
        return pokeInfoMapper.findPokeByName(name);
    }

}

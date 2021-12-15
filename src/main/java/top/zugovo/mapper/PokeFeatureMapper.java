package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.PokeAttribute;
import top.zugovo.entity.PokeFeature;

@Mapper
@Repository
public interface PokeFeatureMapper {

    public int savePokeFeature(PokeFeature pokeFeature);

    public int updatePokeFeature(PokeFeature pokeFeature);

    public int dropPokeFeature(Integer id);

    public PokeFeature findPokeFeatureById(Integer id);

    // 多表连接: 查询对应特性的所有宝可梦
    public PokeFeature queryPokeInfosFromPokeFeature(Integer id);

}

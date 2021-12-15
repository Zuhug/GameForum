package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.Account;
import top.zugovo.entity.PokeAttribute;

import java.util.List;

@Mapper
@Repository
public interface PokeAttributeMapper {

    // 增
    public int savePokeAttribute(PokeAttribute pokeAttribute);

    // 改
    public int updatePokeAttribute(PokeAttribute pokeAttribute);

    // 删
    public int dropPokeAttribute(Integer id);

    // 查
    public PokeAttribute findPokeAttributeById(Integer id);

    // 多表连接: 查询对应属性的所有的宝可梦
    public PokeAttribute queryPokeInfosFromPokeAttribute(Integer id);

}

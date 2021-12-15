package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.PokeFeature;
import top.zugovo.entity.PokeInfo;

import java.util.List;

@Mapper
@Repository
public interface PokeInfoMapper {

    public int savePokeInfo(PokeInfo pokeInfo);

    public int updatePokeInfo(PokeInfo pokeInfo);

    public int dropPokeInfo(Integer id);

    public PokeInfo findPokeInfoById(Integer id);

    // 按照宝可梦的名字模糊查询, 如果返回有多个结果, 之取最前面的一条
    public PokeInfo findPokeByName(String pokeName);

    // 多表连接: 查询该宝可梦的属性
    public PokeInfo findAttributeFromPokeInfo(Integer id);

    // 多表连接: 查询宝可梦的特性
    public List<PokeFeature> findFeatureFromPokeInfo(Integer id);

}

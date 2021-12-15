package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.Topic;

@Mapper
@Repository
public interface TopicMapper {

    // 按照id查询 主题(讨论区) 和 板块信息
    public Topic queryTopicPlate(Integer id);

}

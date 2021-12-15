package top.zugovo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zugovo.entity.Topic;
import top.zugovo.mapper.TopicMapper;
import top.zugovo.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    /**
     * 按照id查询主题(讨论区)和板块
     * @param id
     * @return
     */
    @Override
    public Topic queryTopicPlate(Integer id) {
        Topic topic = topicMapper.queryTopicPlate(id);
        return topic;
    }


}

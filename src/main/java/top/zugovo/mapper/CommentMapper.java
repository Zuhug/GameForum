package top.zugovo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.Comment;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    // 保存一条回复
    public void saveComment(Comment comment);

    // 查询某个主题下面的某篇帖子的回复信息
    public List<Comment> queryCommentsByAid(Integer id);

    // 删除谋篇文章下的所有评论
    public void deleteCommentByAid(Integer aid);

}

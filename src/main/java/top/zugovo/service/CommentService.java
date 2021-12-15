package top.zugovo.service;

import com.github.pagehelper.PageInfo;
import top.zugovo.entity.Comment;
import top.zugovo.entity.vo.CommentVO;
import top.zugovo.utils.PageResult;

import java.util.List;

public interface CommentService {

    // 保存一条回复信息
    public void saveCommentService(Comment comment);

    // 查询某个主题下面的某篇帖子的回复信息
    public PageResult<CommentVO> queryCommentsByAid(Integer id, Integer start);

}

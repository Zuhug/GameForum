package top.zugovo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zugovo.entity.Comment;
import top.zugovo.entity.User;
import top.zugovo.entity.vo.CommentVO;
import top.zugovo.mapper.CommentMapper;
import top.zugovo.mapper.UserMapper;
import top.zugovo.service.CommentService;
import top.zugovo.utils.PageResult;
import top.zugovo.utils.PageUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void saveCommentService(Comment comment) {
        commentMapper.saveComment(comment);
    }

    @Override
    public PageResult<CommentVO> queryCommentsByAid(Integer id, Integer start) {
        List<CommentVO> commentVOS = new ArrayList<>();

        Page ps = PageHelper.startPage(start, 10, "comment.id desc");
        List<Comment> comments = commentMapper.queryCommentsByAid(id);
        PageInfo<Comment> result = new PageInfo<>(comments);

        for (Comment comment : comments) {
            CommentVO commentVO = new CommentVO();
            User user = userMapper.findUserById(comment.getUid());
            commentVO.setContent(comment.getCommentContent());
            commentVO.setUsername(user.getUsername());
            commentVO.setUserImgUrl(user.getImgUrl());
            commentVOS.add(commentVO);
        }

        PageResult<CommentVO> commentPage = new PageResult<>();
        commentPage.setRows(commentVOS);
        PageUtil.setterPageResult(commentPage, result);

        return commentPage;
    }
}

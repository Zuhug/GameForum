package top.zugovo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zugovo.mapper.AccountMapper;
import top.zugovo.mapper.ArticalMapper;
import top.zugovo.mapper.CommentMapper;
import top.zugovo.mapper.UserMapper;
import top.zugovo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticalMapper articalMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private AccountMapper accountMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setArticalMapper(ArticalMapper articalMapper) {
        this.articalMapper = articalMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void deleteArtical(Integer id) {
        deleteComment(id);
        articalMapper.dropArtical(id);
    }

    @Override
    public void deleteComment(Integer id) {
        commentMapper.deleteCommentByAid(id);
    }

}

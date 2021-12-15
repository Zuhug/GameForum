package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    public List<User> queryAll();

    public int saveUser(User user);

    public int updateUser(User user);

    public int dropUser(Integer id);

    public User findUserById(Integer id);

    public User findNewUser();

    public User findAccountFromUser(Integer id);

    public User findRoleFromUser(Integer id);

    public User findArticalsFromUser(Integer id);

}

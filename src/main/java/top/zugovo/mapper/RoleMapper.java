package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.Role;

@Mapper
@Repository
public interface RoleMapper {

    // 增
    public int saveRole(Role role);

    // 改
    public int updateRole(Role role);

    // 删
    public int dropRole(Integer id);

    // 查
    public Role findRoleById(Integer id);

    // 多表连接: 查询该角色下有多少用户
    public Role findUsersFromRole(Integer id);

}

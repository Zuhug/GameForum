package top.zugovo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.zugovo.entity.Account;

// 这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface AccountMapper {

    // 通过外键查询数据: 因为用户和账号是 1-1关系, 所以一个uid必定只能查出一个账号
    public Account queryAccountByForeignKey(Integer foreignKey);

    // 增: 增加账号 (用于注册)
    public int saveAccount(Account account);

    // 改: 修改账号密码
    public int updateAccount(Account account);

    // 删: 注销某个账户
    public int dropAccount(Integer id);

    // 查: 通过id查出账号信息
    public Account findAccountById(Integer id);

    // 查询是否存在这个账号
    public Account accountExists(Account account);

    public Account findUserFromAccount(Integer id);

}

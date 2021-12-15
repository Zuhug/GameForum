package top.zugovo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zugovo.entity.Account;
import top.zugovo.mapper.AccountMapper;
import top.zugovo.service.LoginService;

/**
 * 用户登录的操作
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 验证账号和密码， 并且将Account放回 (此时只有id, email, password等信息)
     * @param account
     * @return
     */
    @Override
    public Account login(Account account) {
        boolean success;
        Account a = accountMapper.accountExists(account);
        return a;
    }

    /**
     * 通过账号id查询用户 (返回一个完整的Account信息)
     * @param id
     * @return
     */
    @Override
    public Account getAccount(Integer id) {
        Account account = accountMapper.findUserFromAccount(id);
        return account;
    }
}

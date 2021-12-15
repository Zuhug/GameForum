package top.zugovo.service;

import top.zugovo.entity.Account;

public interface LoginService {

    public Account login(Account account);

    public Account getAccount(Integer id);

}

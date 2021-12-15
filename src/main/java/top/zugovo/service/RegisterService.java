package top.zugovo.service;

import org.springframework.web.multipart.MultipartFile;
import top.zugovo.entity.Account;
import top.zugovo.entity.User;

public interface RegisterService {

    public void register(User user, Account account, String birthStr, MultipartFile imgUpload);

}

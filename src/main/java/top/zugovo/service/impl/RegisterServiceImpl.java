package top.zugovo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.zugovo.entity.Account;
import top.zugovo.entity.User;
import top.zugovo.mapper.AccountMapper;
import top.zugovo.mapper.UserMapper;
import top.zugovo.service.RegisterService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {

    /**
     * 实现注册业务
     */

    /**
     * 用户上传的头像的保存地址
     */
    @Value("${file.uploadFolder}")
    private String uploadDir;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    /**
     * 将用户头像保存在本地的某个地址
     * @param imgUpload 用户上传的头像
     * @param suffix 头像图片后缀
     * @param filename 文件名
     * @return fileStr: 该文件访问的路径
     * @throws IOException
     */
    public String saveImg2Local(MultipartFile imgUpload, String suffix, String filename) throws IOException {
        byte[] bs = imgUpload.getBytes();
        // 防止用户上传的头像名字重复
        filename = UUID.randomUUID() + suffix;
        // 保存的真实地址
        String fileStr = uploadDir + filename;
        File file = new File(fileStr);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(fileStr);
        fos.write(bs);
        fos.close();
        // 访问地址
        fileStr = "/img/header/" + filename;
        return fileStr;
    }

    /**
     * 将用户信息保存到数据库, 以及账号页放入数据库并且关联起来
     * @param user 用户
     * @param account 账号
     */
    public void addUser(User user, Account account) {
        // 保存用户信息
        userMapper.saveUser(user);
        Integer uid = userMapper.findNewUser().getId();
        // 将用户和账号关联
        account.setUid(uid);
        // 保存账户信息
        accountMapper.saveAccount(account);
    }

    /**
     * 实现注册业务
     * @param user 注册的用户基本信息
     * @param account 注册的账号
     * @param birthStr 生日的字符串 (yyyy-MM-dd格式)
     * @param imgUpload 用户上传的头像
     */
    @Override
    public void register(User user, Account account, String birthStr, MultipartFile imgUpload) {
        // 获取文件名字
        String filename= imgUpload.getOriginalFilename();
        String fileStr = "/img/header/default.jpg";
        if ( filename.length() != 0 ) {
            // 拿到后缀
            String suffix = filename.substring(filename.lastIndexOf("."));
            // 创建保存头像的本地文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            try {
                fileStr = saveImg2Local(imgUpload, suffix, filename);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        user.setBirth(Date.valueOf(birthStr));
        // 默认都是普通用户, 只有"我"一个管理员
        user.setRid(2);
        user.setImgUrl(fileStr);
        addUser(user, account);
    }

}

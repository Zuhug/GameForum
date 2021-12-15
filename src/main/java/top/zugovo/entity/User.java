package top.zugovo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

public class User {

    private Integer id;
    private String username;
    private String imgUrl;
    private Integer sex;
    private String addr;
    private String tel;
    private Date birth;
    private Integer age;
    private Integer rid;

    private Role role;
    private Account account;
    private List<Artical> articals;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sex=" + sex +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", rid=" + rid +
                ", role=" + role +
                ", account=" + account +
                ", articals=" + articals +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Artical> getArticals() {
        return articals;
    }

    public void setArticals(List<Artical> articals) {
        this.articals = articals;
    }
}

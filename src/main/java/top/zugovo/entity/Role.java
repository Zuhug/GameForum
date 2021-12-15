package top.zugovo.entity;

import java.util.List;

public class Role {

    private Integer id;
    private String descri;

    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", descri='" + descri + '\'' +
                ", users=" + users +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

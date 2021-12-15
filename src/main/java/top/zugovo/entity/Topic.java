package top.zugovo.entity;

import java.util.List;

public class Topic {

    private Integer id;
    private String name;
    private Integer pid;

    private Plate plate;
    private List<Artical> articals;

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", plate=" + plate +
                ", articals=" + articals +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Plate getPlate() {
        return plate;
    }

    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    public List<Artical> getArticals() {
        return articals;
    }

    public void setArticals(List<Artical> articals) {
        this.articals = articals;
    }
}

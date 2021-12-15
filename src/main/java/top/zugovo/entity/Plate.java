package top.zugovo.entity;

import java.util.List;

public class Plate {

    private Integer id;
    private String pname;

    private List<Topic> topics;

    @Override
    public String toString() {
        return "Plate{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", topics=" + topics +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}

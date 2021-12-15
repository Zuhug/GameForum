package top.zugovo.entity;

import java.util.List;

public class PokeAttribute {

    private Integer id;
    private String attribute;
    private List<PokeInfo> pokeInfos;

    @Override
    public String toString() {
        return "PokeAttribute{" +
                "id=" + id +
                ", attribute='" + attribute + '\'' +
                ", pokeInfos=" + pokeInfos +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public List<PokeInfo> getPokeInfos() {
        return pokeInfos;
    }

    public void setPokeInfos(List<PokeInfo> pokeInfos) {
        this.pokeInfos = pokeInfos;
    }
}

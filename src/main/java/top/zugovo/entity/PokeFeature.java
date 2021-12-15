package top.zugovo.entity;

import java.util.List;

public class PokeFeature {

    private Integer id;
    private String feature;
    private String descri;
    private List<PokeInfo> pokeInfos;

    @Override
    public String toString() {
        return "PokeFeature{" +
                "id=" + id +
                ", feature='" + feature + '\'' +
                ", descri='" + descri + '\'' +
                ", pokeInfos=" + pokeInfos +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public List<PokeInfo> getPokeInfos() {
        return pokeInfos;
    }

    public void setPokeInfos(List<PokeInfo> pokeInfos) {
        this.pokeInfos = pokeInfos;
    }
}

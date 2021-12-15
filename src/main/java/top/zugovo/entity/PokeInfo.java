package top.zugovo.entity;

import java.util.List;

public class PokeInfo {

    private Integer id;
    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer spatk;
    private Integer spdef;
    private Integer speed;
    private String dex;
    private String img300Src;
    private String img128Src;
    private String pokeName;

    private List<PokeAttribute> pokeAttributes;
    private List<PokeFeature> pokeFeatures;

    @Override
    public String toString() {
        return "PokeInfo{" +
                "id=" + id +
                ", hp=" + hp +
                ", atk=" + atk +
                ", def=" + def +
                ", spatk=" + spatk +
                ", spdef=" + spdef +
                ", speed=" + speed +
                ", dex='" + dex + '\'' +
                ", img300Src='" + img300Src + '\'' +
                ", img128Src='" + img128Src + '\'' +
                ", pokeName='" + pokeName + '\'' +
                ", pokeAttributes=" + pokeAttributes +
                ", pokeFeatures=" + pokeFeatures +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getSpatk() {
        return spatk;
    }

    public void setSpatk(Integer spatk) {
        this.spatk = spatk;
    }

    public Integer getSpdef() {
        return spdef;
    }

    public void setSpdef(Integer spdef) {
        this.spdef = spdef;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getDex() {
        return dex;
    }

    public void setDex(String dex) {
        this.dex = dex;
    }

    public String getImg300Src() {
        return img300Src;
    }

    public void setImg300Src(String img300Src) {
        this.img300Src = img300Src;
    }

    public String getImg128Src() {
        return img128Src;
    }

    public void setImg128Src(String img128Src) {
        this.img128Src = img128Src;
    }

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public List<PokeAttribute> getPokeAttributes() {
        return pokeAttributes;
    }

    public void setPokeAttributes(List<PokeAttribute> pokeAttributes) {
        this.pokeAttributes = pokeAttributes;
    }

    public List<PokeFeature> getPokeFeatures() {
        return pokeFeatures;
    }

    public void setPokeFeatures(List<PokeFeature> pokeFeatures) {
        this.pokeFeatures = pokeFeatures;
    }
}

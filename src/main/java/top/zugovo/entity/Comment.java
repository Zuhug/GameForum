package top.zugovo.entity;

public class Comment {

    private Integer id;
    private String commentContent;
    private Integer aid;
    private Integer uid;

    private Artical artical;
    private User user;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", aid=" + aid +
                ", uid=" + uid +
                ", artical=" + artical +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Artical getArtical() {
        return artical;
    }

    public void setArtical(Artical artical) {
        this.artical = artical;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

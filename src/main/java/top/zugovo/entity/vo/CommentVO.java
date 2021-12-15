package top.zugovo.entity.vo;

public class CommentVO {

    private String userImgUrl;
    private String username;
    private String content;

    @Override
    public String toString() {
        return "CommentVO{" +
                "userImgUrl='" + userImgUrl + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

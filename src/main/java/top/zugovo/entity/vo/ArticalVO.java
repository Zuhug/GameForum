package top.zugovo.entity.vo;

import java.sql.Timestamp;

public class ArticalVO {

    private Integer aid;
    private String publishTime;
    private String title;
    private String content;
    private String authorName;
    private String authorImg;

    @Override
    public String toString() {
        return "ArticalVO{" +
                "aid=" + aid +
                ", publishTime='" + publishTime + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorImg='" + authorImg + '\'' +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }
}

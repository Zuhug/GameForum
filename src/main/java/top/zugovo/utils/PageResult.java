package top.zugovo.utils;

import java.util.List;

public class PageResult<T>{

    // 每页需要展示的数据
    private List<T> rows;
    // 当前页
    private int pageNum;
    // 当前页的大小
    private int size;
    // 总页数
    private int pages;
    // 上一页
    private int prePage;
    // 下一页
    private int nextPage;
    // 是否为第一页
    private boolean isFirstPage;
    // 是否为最后一页
    private boolean isLastPage;

    @Override
    public String toString() {
        return "PageResult{" +
                "rows=" + rows +
                ", pageNum=" + pageNum +
                ", size=" + size +
                ", pages=" + pages +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                '}';
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }
}

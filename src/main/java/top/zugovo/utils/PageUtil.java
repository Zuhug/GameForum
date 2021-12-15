package top.zugovo.utils;

import com.github.pagehelper.PageInfo;

public class PageUtil {

    public static void setterPageResult(PageResult pageResult, PageInfo result) {
        pageResult.setFirstPage(result.isIsFirstPage());
        pageResult.setLastPage(result.isIsLastPage());
        pageResult.setNextPage(result.getNextPage());
        pageResult.setPrePage(result.getPrePage());
        pageResult.setPages(result.getPages());
        pageResult.setSize(result.getSize());
        pageResult.setPageNum(result.getPageNum());
    }

}

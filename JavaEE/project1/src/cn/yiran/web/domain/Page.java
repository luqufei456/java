package cn.yiran.web.domain;

import java.util.List;

public class Page {
    // 总记录条数
    private int totalCount;
    // 总页数
    private int totalPage;
    // 当前页数
    private int currentPage;
    // 每页显示的条数
    private int pageSize;
    // 分页携带的数据
    private List<Product> data;
    // 分页工具栏
    private int[] bar;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public int[] getBar() {
        int start ;
        int stop ;
        //少于10页
        if(totalPage < 10){
            start = 1;
            stop = totalPage;
        }
        else
        {
            start = currentPage -5;
            stop = currentPage +4;
            if(currentPage +4 >= totalPage){
                start = totalPage - 9;
                stop = totalPage ;
            }
            if(currentPage -5 <=0){
                start = 1;
                stop = 10;
            }

        }
        bar = new int[stop - start + 1];
        int index = 0;
        for (int i = start; i <= stop; i++) {
            bar[index++] = i;
        }

        return bar;
    }

    public void setBar(int[] bar) {
        this.bar = bar;
    }
}

package cn.tedu.ems.commom.web;

/**
 * @Author: lulin
 * @Date: 3/7/2019 3:00 PM
 * @Version 1.0
 */
public class pageObject {
    private int count;
    private int pageSize;
    /*
    总页数
     */
    private int pageCount;
    private int currentPage;
    private int fontCount;
    private int rearCount;

    public pageObject(){
        this.currentPage=1;
        this.rearCount=0;
        this.fontCount=0;
    }

    public pageObject(int count, int pageSize,  int currentPage) {
        super();
        if(count>0) {
            pageCount = count / pageSize + 1;
            fontCount = (currentPage - 1) / pageSize + 1;
            this.rearCount=count;
            if (currentPage < pageCount)
                rearCount = currentPage * pageSize;
        }
    }


    @Override
    public String toString() {
        return "pageObject{" +
                "页面行数=" + pageSize +
                ", 当前页=" + currentPage +
                ", 初始行数=" + fontCount +
                ", 末尾行数=" + rearCount +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
      this.pageCount=pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getFontCount() {
        return fontCount;
    }

    public void setFontCount(int fontCount) {
        this.fontCount = fontCount;
    }

    public int getRearCount() {
        return rearCount;
    }

    public void setRearCount(int rearCount) {
        this.rearCount = rearCount;
    }
}

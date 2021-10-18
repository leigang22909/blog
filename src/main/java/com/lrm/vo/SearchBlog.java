package com.lrm.vo;

public class SearchBlog {
    private String title;
    private Long typeId;
    private boolean recommend;

    public SearchBlog() {
    }

    public SearchBlog(String title, Long typeId, boolean recommend) {
        this.title = title;
        this.typeId = typeId;
        this.recommend = recommend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "SearchBlog{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommend=" + recommend +
                '}';
    }
//推荐符号从前端传过来是String类型
//    private String recommend;
//    private Integer recommend2;

//    public SearchBlog() {
//    }
//
//    public SearchBlog(String title, Long typeId, String recommend, Integer recommend2) {
//        this.title = title;
//        this.typeId = typeId;
//        this.recommend = recommend;
//        this.recommend2 = recommend2;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Long getTypeId() {
//        return typeId;
//    }
//
//    public void setTypeId(Long typeId) {
//        this.typeId = typeId;
//    }
//
//    public String getRecommend() {
//        return recommend;
//    }
//
//    public void setRecommend(String recommend) {
//        this.recommend = recommend;
//    }
//
//    public Integer getRecommend2() {
//        return recommend2;
//    }
//
//    public void setRecommend2(Integer recommend2) {
//        this.recommend2 = recommend2;
//    }
//
//    @Override
//    public String toString() {
//        return "SearchBlog{" +
//                "title='" + title + '\'' +
//                ", typeId=" + typeId +
//                ", recommend='" + recommend + '\'' +
//                ", recommend2=" + recommend2 +
//                '}';
//    }
}

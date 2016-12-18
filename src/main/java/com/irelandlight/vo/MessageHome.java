package com.irelandlight.vo;

/**
 * Created by lenovo on 2016/12/6.
 */
public class MessageHome {

    private String message;
    private OrderCustom order;
    private String news;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /*public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }*/

    public OrderCustom getOrder() {
        return order;
    }

    public void setOrder(OrderCustom order) {
        this.order = order;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}

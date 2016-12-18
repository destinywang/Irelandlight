package com.irelandlight.vo;

/**
 * 当访问单人页面时,需要将用户id和管理员id一起传过来
 * Created by lenovo on 2016/12/10.
 */
public class SinglePageParam {

    private Long consumer_id;
    private Long productor_id;

    public Long getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(Long consumer_id) {
        this.consumer_id = consumer_id;
    }

    public Long getProductor_id() {
        return productor_id;
    }

    public void setProductor_id(Long productor_id) {
        this.productor_id = productor_id;
    }
}

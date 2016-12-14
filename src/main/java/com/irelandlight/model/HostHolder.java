package com.irelandlight.model;

import org.springframework.stereotype.Component;

/**
 * Created by destiny on 2016/12/14.
 */
@Component
public class HostHolder {

    private static ThreadLocal<Consumer> consumerThreadLocal = new ThreadLocal<Consumer>();

    public Consumer getConsumer() {
        return consumerThreadLocal.get();
    }

    public void setConsumer(Consumer consumer) {
        consumerThreadLocal.set(consumer);
    }

    public void clear() {
        consumerThreadLocal.remove();
    }

}

package com.irelandlight.manager;

/**
 * Created by mac on 2016/12/8.
 */
public class ContextException extends Exception{
    public String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {

        return message;
    }

    public ContextException(String message){
        this.message=message;
    }
}

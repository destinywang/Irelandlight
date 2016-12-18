package com.irelandlight.vo;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Created by lenovo on 2016/12/13.
 */
public class MessagePicAjax {

    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    private Long toId;
    private Long fromId;

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }
}

package com.irelandlight.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by mac on 2016/12/21.
 */
@ControllerAdvice
public class ContextExceptionHandler {
    /**
     * 全局处理Exception
     * 错误的情况下返回500
     * @param ex
     * @param req
     * @return
     */
    private static Logger logger = LoggerFactory.getLogger(ContextExceptionHandler.class);

    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<String> handleServiceException(Exception exception, HttpServletRequest request) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception exception, HttpServletRequest request) {
        logger.error("有一个坏蛋正在捣乱!", exception);
        return new ResponseEntity<String>("操作失败，请联系黄柯！陌陌:15691981686", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

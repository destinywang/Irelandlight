package com.irelandlight.exception;

/**
 * <p>The Top-design class in this project</p>
 * <p>All of other custom exception class must be extended this class</p>
 *
 * @author destiny
 * @see java.lang.Exception
 * @since 2016/12/15.
 */
public class IrelandLightException extends Exception{
    public IrelandLightException() {
        super();
    }

    public IrelandLightException(String message) {
        super(message);
    }
}

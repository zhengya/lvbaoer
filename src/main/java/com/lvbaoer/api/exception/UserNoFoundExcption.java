/**
 * 
 */
package com.lvbaoer.api.exception;

public class UserNoFoundExcption extends Exception {

    private static final long serialVersionUID = 3880507764532214689L;

    /**
     * @param message
     */
    public UserNoFoundExcption(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public UserNoFoundExcption(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

}

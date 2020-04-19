package com.nihfkeol.exception;

public class UserNotExisException extends RuntimeException {

    public UserNotExisException(){
        super("用户不存在");
    }

}

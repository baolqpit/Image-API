package com.baolqp.image_thumbnail.exception;

public enum ErrorCode
{
    OBJECT_EXISTED(409, "Object already existed"),
    USER_NOT_FOUND(404, "User not found"),
    UNCAUGHT_EXCEPTION(500, "Uncaught exception"),
    INVALID_KEY(400, "Invalid key"),
    USERNAME_INVALID(400, "Username is invalid"),
    PASSWORD_INVALID(400, "Password is invalid"),
    UNAUTHENTICATED(401, "Unauthenticated"),
    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

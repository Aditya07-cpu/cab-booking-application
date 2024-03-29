package com.cab.booking.application.dtos;

public class ResponseObject {

    private String message;
    private boolean success;
    private Object data;

    public ResponseObject() {
    }

    public ResponseObject(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }
}

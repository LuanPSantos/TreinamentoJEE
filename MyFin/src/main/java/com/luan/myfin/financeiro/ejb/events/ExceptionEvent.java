package com.luan.myfin.financeiro.ejb.events;

import java.io.Serializable;

public class ExceptionEvent implements Serializable{

    private Exception exception;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}

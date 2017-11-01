package com.luan.helloejb.lib.models;

import java.io.Serializable;

public class Message implements Serializable{
    
    private String texto;

    public Message(String texto) {
        this.texto = texto;
    }

    public Message() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

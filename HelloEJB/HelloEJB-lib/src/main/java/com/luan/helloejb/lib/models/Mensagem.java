package com.luan.helloejb.lib.models;

import java.io.Serializable;

public class Mensagem implements Serializable{
    
    private String texto;

    public Mensagem(String texto) {
        this.texto = texto;
    }

    public Mensagem() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

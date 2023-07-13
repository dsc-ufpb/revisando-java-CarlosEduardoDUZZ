package main.entities;

import java.util.*;

public class Comentario {
    private int id;
    private String usuario;
    private String conteudo;
    private Date data;
    private boolean removido;

    public Comentario(int id, String usuario, String conteudo) {
        this.id = id;
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.data = new Date();
        this.removido = false;
    }

        public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Date getData() {
        return data;
    }

    public boolean isRemovido() {
        return removido;
    }

    public void marcarRemovido() {
        removido = true;
    }
}
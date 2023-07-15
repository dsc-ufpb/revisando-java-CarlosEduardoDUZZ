package main.entities;

import java.util.*;

public class Disciplina {
    private int id;
    String nome;
    private List<Comentario> comentarios;
    private int likes;
    private List<Double> notas;

    public Disciplina(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.comentarios = new ArrayList<>();
        this.likes = 0;
        this.notas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void adicionarNota (double nota) {
        notas.add(nota);
    }

    public void adicionarComentario (Comentario comentario) {
        comentarios.add(comentario);
    }

    public void removerComentario(int comentarioId) {
        for (Comentario comentario : comentarios) {
            if (comentario.getId() == comentarioId) {
                comentario.marcarRemovido();
                break;
            }
        }
    }
}
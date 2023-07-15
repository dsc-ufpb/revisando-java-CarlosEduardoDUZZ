package main.entities;

import java.util.*;

import main.exceptions.CredenciaisInvalidasException;
import main.exceptions.SistemaRedeSocialException;

public class SistemaRedeSocial {
    private GerenteDeUsuarios gerenteDeUsuarios;
    private GerenteDeDisciplinas gerenteDeDisciplinas;

    public SistemaRedeSocial() {
        this.gerenteDeUsuarios = new GerenteDeUsuarios();
        this.gerenteDeDisciplinas = new GerenteDeDisciplinas();
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        gerenteDeUsuarios.adicionarUsuario(usuario);
    }

    public boolean fazerLogin(String email, String senha) throws CredenciaisInvalidasException {
        return gerenteDeUsuarios.validarCredenciais(email, senha);
    }

    public void adicionarDisciplina(int id, String nome) throws SistemaRedeSocialException {
        Disciplina disciplina = new Disciplina(id, nome);
        if (gerenteDeDisciplinas.buscarDisciplinaPorId(id) != null) {
            throw new SistemaRedeSocialException("JÃ¡ existe uma disciplina com o ID: " + id);
        }
        gerenteDeDisciplinas.adicionarDisciplina(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return gerenteDeDisciplinas.getDisciplinas();
    }

    public Disciplina atualizarNomeDisciplina(int id, String novoNome) {
        return gerenteDeDisciplinas.atualizarNomeDisciplina(id, novoNome);
    }

    public double adicionarNotaDisciplina(int id, double nota) {
        return gerenteDeDisciplinas.adicionarNotaDisciplina(id, nota);
    }

    public Disciplina adicionarComentarioDisciplina(int id, Comentario comentario) {
        return gerenteDeDisciplinas.adicionarComentarioDisciplina(id, comentario);
    }

    public Disciplina removerDisciplina(int id) {
        return gerenteDeDisciplinas.removerDisciplina(id);
    }

    public Disciplina buscarDisciplinaPorId(int id) {
        return gerenteDeDisciplinas.buscarDisciplinaPorId(id);
    }

    public List<Disciplina> getDisciplinasOrdenadasPorMedia() {
        return gerenteDeDisciplinas.getDisciplinasOrdenadasPorMedia();
    }
}
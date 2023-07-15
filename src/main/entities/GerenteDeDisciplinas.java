package main.entities;

import java.util.*;

public class GerenteDeDisciplinas {
    private List<Disciplina> disciplinas;

    public GerenteDeDisciplinas () {
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina (Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina buscarDisciplinaPorId(int id) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    public Disciplina atualizarNomeDisciplina(int id, String novoNome) {
        Disciplina disciplina = buscarDisciplinaPorId(id);
        if (disciplina != null) {
            disciplina.nome = novoNome;
            return disciplina;
        }
        return null;
    }

    public double adicionarNotaDisciplina(int id, double nota) {
        Disciplina disciplina = buscarDisciplinaPorId(id);
        if (disciplina != null) {
            disciplina.adicionarNota(nota);
            return calcularMediaNotas(disciplina);
        }
        return 0.0;
    }

    public Disciplina adicionarComentarioDisciplina(int id, Comentario comentario) {
        Disciplina disciplina = buscarDisciplinaPorId(id);
        if (disciplina != null) {
            disciplina.adicionarComentario(comentario);
            return disciplina;
        }
        return null;
    }

    public Disciplina removerDisciplina(int id) {
        Disciplina disciplina = buscarDisciplinaPorId(id);
        if (disciplina != null) {
            disciplinas.remove(disciplina);
            return disciplina;
        }
        return null;
    }

    public List<Disciplina> getDisciplinasOrdenadasPorMedia() {
        List<Disciplina> disciplinasOrdenadas = new ArrayList<>(disciplinas);
        disciplinasOrdenadas.sort((d1, d2) -> Double.compare(calcularMediaNotas(d2), calcularMediaNotas(d1)));
        return disciplinasOrdenadas;
    }

    private double calcularMediaNotas(Disciplina disciplina) {
        List<Double> notas = disciplina.getNotas();
        if (notas.isEmpty()) {
            return 0.0;
        }
        // Estratégia de cálculo da média usando a mediana
        Collections.sort(notas);
        int size = notas.size();
        if (size % 2 == 0) {
            return (notas.get(size / 2 - 1) + notas.get(size / 2)) / 2.0;
        } else {
            return notas.get(size / 2);
        }
    }
}
package main;

import java.util.List;

import main.entities.Comentario;
import main.entities.Disciplina;
import main.entities.SistemaRedeSocial;
import main.exceptions.CredenciaisInvalidasException;
import main.exceptions.SistemaRedeSocialException;

public class Main {
    public static void main(String[] args) throws SistemaRedeSocialException, CredenciaisInvalidasException {
        SistemaRedeSocial sistema = new SistemaRedeSocial();

        
        sistema.cadastrarUsuario("Carlos", "carlos@example.com", "334445555");
        sistema.cadastrarUsuario("Eduarda", "eduarda@example.com", "bbccddee");

        
        boolean loginSucesso = sistema.fazerLogin("carlos@example.com", "334445555");
        if (loginSucesso) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Credenciais inválidas. Login falhou.");
        }

        
        sistema.adicionarDisciplina(1, "Sistemas de Informação");

        
        Disciplina disciplina = sistema.atualizarNomeDisciplina(1, "Banco de Dados");
        if (disciplina != null) {
            System.out.println("Nome da disciplina atualizado: " + disciplina.getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }

        
        double media = sistema.adicionarNotaDisciplina(1, 7.0);
        System.out.println("Média da disciplina: " + media);

        
        Comentario comentario = new Comentario(1, "carlos@example.com", "Achei a disciplina legal!");
        disciplina = sistema.adicionarComentarioDisciplina(1, comentario);
        if (disciplina != null) {
            System.out.println("Comentário adicionado à disciplina: " + disciplina.getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }

        
        sistema.removerDisciplina(1);
        System.out.println("Comentário removido.");

        
        disciplina = sistema.buscarDisciplinaPorId(1);
        if (disciplina != null) {
            System.out.println("Disciplina encontrada: " + disciplina.getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }

        
        List<Disciplina> disciplinas = sistema.getDisciplinasOrdenadasPorMedia();
        for (Disciplina d : disciplinas) {
            System.out.println(d.getNome() + " - Média: " + sistema.adicionarNotaDisciplina(d.getId(), 8.0));
        }
    }
}

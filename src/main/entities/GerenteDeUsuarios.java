package main.entities;

import java.util.*;

import main.exceptions.CredenciaisInvalidasException;

public class GerenteDeUsuarios {
    private List<Usuario> usuarios;

    public GerenteDeUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean validarCredenciais(String email, String senha) throws CredenciaisInvalidasException {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        throw new CredenciaisInvalidasException("Credenciais invÃ¡lidas para o email: " + email);
    }

    
}
package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.LoggedIn;
import br.com.idtrust.meerkwatch.model.TipoUsuario;
import br.com.idtrust.meerkwatch.model.Usuario;

@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1936958493391194270L;

	@Inject
	@LoggedIn
	private Usuario usuarioLogado;

	private void validarDados() {

	}

	private void validarPerfilUsuario() {

	}

	private void enviarEmailSenhaPadrao() {

	}

	public void visualizarUsuarios() {
		if (TipoUsuario.USUARIO.equals(usuarioLogado.getTipo())) {
			throw new IllegalArgumentException("Acesso restrito apenas para administradores");
		}

	}

	public void cadastrarUsuario(Usuario usuario) {

	}

	public void desativarUsuario(Usuario usuario) {

	}

}

package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.security.Principal;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.LoggedIn;
import br.com.idtrust.meerkwatch.dao.UsuarioDAO;
import br.com.idtrust.meerkwatch.model.Usuario;

@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = -909030022577583906L;

	@Inject
	private Principal principal;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Produces
	@LoggedIn
	@SessionScoped
	public Usuario getUsuarioLogado() {
		return usuarioDAO.buscarPorLogin(principal.getName());
	}

	private String converterSenha(String senha) {
		return "";
	}

	public void alterarSenha(Usuario usuario, String senha) {
		// TODO: alterar senha
	}

	public void autenticar(String login, String senha) {
		// TODO: autenticar
	}

	public void compararSenhas(String senhaBanco, String senhaEnviada) {
		String senhaConvertida = converterSenha(senhaEnviada);
		// TODO: comparar senhas
	}

}

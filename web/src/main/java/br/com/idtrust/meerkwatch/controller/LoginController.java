package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.security.Principal;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.LoggedIn;
import br.com.idtrust.meerkwatch.Utils;
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

	public void alterarSenha(Usuario usuario, String senha) {
		if (principal.getName() != usuario.getLogin()) {
			throw new IllegalArgumentException("Usuário não pode alterar senha de um outro usuário");
		}

		String senhaCripto = Utils.converterSenha(senha);
		usuario.setSenha(senhaCripto);
		usuarioDAO.atualizar(usuario);
	}

	public void autenticar(String login, String senha) {
		Usuario usuario = usuarioDAO.buscarPorLogin(login);
		if (!compararSenhas(usuario.getSenha(), senha)) {
			throw new IllegalArgumentException("Usuário/senha inválidos");
		}
	}

	public boolean compararSenhas(String senhaBanco, String senhaEnviada) {
		String senhaConvertida = Utils.converterSenha(senhaEnviada);
		return senhaBanco.equals(senhaConvertida);
	}

}

package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.LoggedIn;
import br.com.idtrust.meerkwatch.Utils;
import br.com.idtrust.meerkwatch.dao.UsuarioDAO;
import br.com.idtrust.meerkwatch.model.Email;
import br.com.idtrust.meerkwatch.model.TipoUsuario;
import br.com.idtrust.meerkwatch.model.Usuario;

@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1936958493391194270L;

	@Inject
	@LoggedIn
	private Usuario usuarioLogado;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private EmailController emailController;

	private void validarDados(Usuario usuario) {
		if (usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()) {
			throw new IllegalArgumentException("Login não deve estar vazio");
		}
		if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
			throw new IllegalArgumentException("Email não deve estar vazio");
		}
		if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não deve estar vazio");
		}
	}

	private void validarPerfilUsuario() {
		if (TipoUsuario.USUARIO.equals(usuarioLogado.getTipo())) {
			throw new IllegalArgumentException("Acesso restrito apenas para administradores");
		}
	}

	private void enviarEmailSenhaPadrao(Usuario usuario) {
		final String conteudoEmail = "<html>" + "Prezado " + usuario.getNome() + "," + "<br/><br/>"
				+ "Sua senha para primeiro acesso ao sistema Meerkwatch é <b>" + usuario.getSenha() + ".</b><br/>"
				+ "É importante, ao efetuar o primeiro login, realizar a alteração de sua senha.<br/>"
				+ "<br/>Atenciosamente<br/><br/>Equipe Meerkwatch</html>";

		Email email = new Email();
		email.setEndereco(usuario.getEmail());

		emailController.enviarEmail(email, "Senha padrao", conteudoEmail);
	}

	private String criarSenhaPadrao() {
		Random rnd = new Random();
		Integer number = new Integer(rnd.nextInt(Integer.MAX_VALUE));
		return Integer.toHexString(number);
	}

	public List<Usuario> visualizarUsuarios() {
		validarPerfilUsuario();
		return usuarioDAO.findAll();
	}

	public void cadastrarUsuario(Usuario usuario) {
		Usuario u = usuarioDAO.buscarPorLogin(usuario.getLogin());
		if (u != null) {
			throw new IllegalArgumentException("Usuário já existe no sistema");
		}
		validarDados(usuario);
		usuario.setSenha(Utils.converterSenha(criarSenhaPadrao()));
		usuarioDAO.salvar(usuario);
		enviarEmailSenhaPadrao(usuario);
	}

	public void desativarUsuario(Usuario usuario) {
		usuario.setAtivado(Boolean.FALSE);
		usuarioDAO.atualizar(usuario);
	}

}

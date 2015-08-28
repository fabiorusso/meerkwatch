package br.com.idtrust.meerkwatch;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;

import br.com.idtrust.meerkwatch.dao.UsuarioDAO;
import br.com.idtrust.meerkwatch.model.Usuario;

public class LoginModule implements javax.security.auth.spi.LoginModule {

	private UsuarioDAO usuarioDAO;

	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map<String, ?> sharedState;
	private Map<String, ?> args;

	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		return false;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler cbh, Map<String, ?> sharedState, Map<String, ?> args) {
		this.subject = subject;
		this.callbackHandler = cbh;
		this.sharedState = sharedState;
		this.args = args;
		this.usuarioDAO = new UsuarioDAO();
	}

	@Override
	public boolean login() throws LoginException {
		String[] userPass = getUsernameAndPassword();
		String username = userPass[0];
		String senha = Utils.converterSenha(userPass[1]);

		Usuario usuario = getUsuarioFromDataBase(username);
		if (usuario.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	private Usuario getUsuarioFromDataBase(String usuario) {
		return usuarioDAO.buscarPorLogin(usuario);
	}

	@Override
	public boolean logout() throws LoginException {
		return false;
	}

	private String[] getUsernameAndPassword() {
		String[] result = new String[2];

		NameCallback uncb = new NameCallback("Usuário");
		PasswordCallback pwcb = new PasswordCallback("Senha", false);

		try {
			this.callbackHandler.handle(new Callback[] { uncb, pwcb });
			result[0] = uncb.getName();

			char[] pass = pwcb.getPassword();

			char[] pw = new char[pass.length];
			System.arraycopy(pass, 0, pw, 0, pass.length);

			result[1] = new String(pw);

			return result;
		} catch (IOException | UnsupportedCallbackException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}

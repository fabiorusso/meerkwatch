package br.com.idtrust.meerkwatch;

import java.security.acl.Group;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

import br.com.idtrust.meerkwatch.dao.UsuarioDAO;
import br.com.idtrust.meerkwatch.model.Usuario;

public class LoginModule extends UsernamePasswordLoginModule {

	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	@Override
	public void initialize(Subject arg0, CallbackHandler arg1, Map<String, ?> arg2, Map<String, ?> arg3) {
		super.initialize(arg0, arg1, arg2, arg3);
		this.usuarioDAO = new UsuarioDAO();
	}

	@Override
	protected String getUsersPassword() throws LoginException {
		String login = getUsername();
		usuario = usuarioDAO.buscarPorLogin(login);
		if (usuario != null) {
			return usuario.getSenha();
		}
		throw new LoginException("Usuário não encontrado");
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		String name = usuario.getTipo().name();
		System.out.println();
		Group[] result = new Group[] { new SimpleGroup("Roles") };
		try {
			result[0].addMember(createIdentity(name));
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoginException("Erro ao obter grupo: " + e.getMessage());
		}
		return result;
	}

}

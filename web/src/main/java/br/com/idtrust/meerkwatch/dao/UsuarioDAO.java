package br.com.idtrust.meerkwatch.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.idtrust.meerkwatch.model.TipoUsuario;
import br.com.idtrust.meerkwatch.model.Usuario;

public class UsuarioDAO extends DAO<Usuario> {

	private static final long serialVersionUID = 2954691127888006712L;

	public Usuario buscarPorLogin(String login) {
		return transform(getCollection().findOne(new BasicDBObject("login", login)));
	}

	@Override
	protected DBObject getIdQuery(Usuario obj) {
		return new BasicDBObject("login", obj.getLogin());
	}

	@Override
	protected String getCollectionName() {
		return "usuario";
	}

	@Override
	protected Usuario transform(DBObject obj) {
		Usuario usuario = new Usuario();
		usuario.setEmail(String.valueOf(obj.get("email")));
		usuario.setLogin(String.valueOf(obj.get("login")));
		usuario.setNome(String.valueOf(obj.get("nome")));
		usuario.setSenha(String.valueOf(obj.get("senha")));
		usuario.setTipo(TipoUsuario.valueOf(String.valueOf(obj.get("tipo"))));
		return usuario;
	}

	@Override
	protected DBObject convert(Usuario obj) {
		BasicDBObject result = new BasicDBObject("email", obj.getEmail()).append("login", obj.getLogin())
				.append("nome", obj.getNome()).append("senha", obj.getSenha())
				.append("tipo", (obj.getTipo() != null ? obj.getTipo().name() : null));
		return result;
	}

}

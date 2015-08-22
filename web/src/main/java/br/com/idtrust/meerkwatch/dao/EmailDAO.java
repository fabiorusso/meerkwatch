package br.com.idtrust.meerkwatch.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.idtrust.meerkwatch.model.Email;

public class EmailDAO extends DAO<Email> {

	public Email buscarEmail(String endereco) {
		List<Email> result = convertCursor(getCollection().find(new BasicDBObject("endereco", endereco)));
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	protected DBObject getIdQuery(Email obj) {
		return convert(obj);
	}

	@Override
	protected String getCollectionName() {
		return "email";
	}

	@Override
	protected Email transform(DBObject obj) {
		Email email = new Email();
		email.setEndereco(String.valueOf(obj.get("endereco")));
		return email;
	}

	@Override
	protected DBObject convert(Email obj) {
		return new BasicDBObject("endereco", obj.getEndereco());
	}

}

package br.com.idtrust.meerkwatch.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public abstract class DAO<T> {

	private MongoClient client;
	private DBCollection collection;
	private DB db;

	public List<T> findAll() {
		List<T> result = new ArrayList<>();
		DBCursor cursor = getCollection().find();
		try {
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();
				result.add(transform(obj));
			}
			return result;
		} finally {
			cursor.close();
		}
	}

	public void salvar(T obj) {
		getCollection().save(convert(obj));
	}

	public void excluir(T obj) {
		// getCollection().remove(convert(obj));
	}

	public void atualizar(T obj) {
		// getCollection().update
	}

	protected abstract String getCollectionName();

	protected abstract T transform(DBObject obj);

	protected abstract DBObject convert(T obj);

	protected synchronized DBCollection getCollection() {
		if (client == null) {
			String server = System.getProperty("mongodb.server.address", "localhost");
			String port = System.getProperty("mongodb.server.port", "27017");
			String db = System.getProperty("mongodb.server.db", "meerkwatch");
			try {
				client = new MongoClient(server, Integer.parseInt(port));
				this.db = client.getDB(db);
				this.collection = this.db.getCollection(getCollectionName());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		return this.collection;
	}

}

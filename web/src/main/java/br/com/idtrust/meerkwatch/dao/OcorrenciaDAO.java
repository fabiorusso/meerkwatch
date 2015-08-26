package br.com.idtrust.meerkwatch.dao;

import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.idtrust.meerkwatch.model.Ocorrencia;

public class OcorrenciaDAO extends DAO<Ocorrencia> {

	private static final long serialVersionUID = -999137375636719981L;

	public List<Ocorrencia> buscarPorServidorEPeriodo(String idServidor, Date dataInicial, Date dataFinal) {
		BasicDBObject query = new BasicDBObject("data",
				new BasicDBObject("$gte", dataInicial.getTime()).append("$lte", dataFinal.getTime()))
						.append("idServidor", idServidor);
		return convertCursor(getCollection().find(query));
	}

	@Override
	protected DBObject getIdQuery(Ocorrencia obj) {
		return new BasicDBObject("data", obj.getData().getTime()).append("mensagem", obj.getMensagem())
				.append("idServidor", obj.getIdServidor());
	}

	@Override
	protected String getCollectionName() {
		return "ocorrencia";
	}

	@Override
	protected Ocorrencia transform(DBObject obj) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setData(new Date(Long.parseLong(String.valueOf(obj.get("data")))));
		ocorrencia.setMensagem(String.valueOf(obj.get("mensagem")));
		ocorrencia.setIdServidor(String.valueOf(obj.get("idServidor")));
		return ocorrencia;
	}

	@Override
	protected DBObject convert(Ocorrencia obj) {
		BasicDBObject result = new BasicDBObject("data", obj.getData().getTime()).append("mensagem", obj.getMensagem())
				.append("idServidor", obj.getIdServidor());
		return result;
	}

}

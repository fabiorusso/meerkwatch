package br.com.idtrust.meerkwatch.dao;

import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.idtrust.meerkwatch.model.DisponibilidadeParametro;
import br.com.idtrust.meerkwatch.model.Parametro;
import br.com.idtrust.meerkwatch.model.Servidor;
import br.com.idtrust.meerkwatch.model.ThresholdParametro;
import br.com.idtrust.meerkwatch.model.TipoParametro;

public class ServidorDAO extends DAO<Servidor> {

	public Servidor buscarPorIdentificador(String id) {
		return transform(getCollection().findOne(new BasicDBObject("id", id)));
	}

	public List<Servidor> buscarAtivos() {
		return convertCursor(getCollection().find(new BasicDBObject("ativo", true)));
	}

	public void salvarSenha(String idServidor, String senha) {
		Servidor servidor = buscarPorIdentificador(idServidor);
		servidor.setSenha(senha);
		atualizar(servidor);
	}

	@Override
	protected DBObject getIdQuery(Servidor obj) {
		return new BasicDBObject("id", obj.getId());
	}

	@Override
	protected String getCollectionName() {
		return "servidor";
	}

	@Override
	protected Servidor transform(DBObject obj) {
		Servidor servidor = new Servidor();
		servidor.setDescricao(String.valueOf(obj.get("descricao")));
		servidor.setId(String.valueOf(obj.get("id")));
		servidor.setAtivo(new Boolean((boolean) obj.get("ativo")));
		servidor.setSenha(String.valueOf(obj.get("senha")));
		if (obj.get("parametros") instanceof BasicDBList) {
			BasicDBList list = (BasicDBList) obj.get("parametros");
			list.forEach((item) -> {
				if (item instanceof BasicDBObject) {
					BasicDBObject dbObj = (BasicDBObject) item;
					Parametro parametro = null;
					String tipo = String.valueOf(dbObj.get("tipoParametro"));
					switch (tipo) {
					case "DISPONIBILIDADE":
						parametro = new DisponibilidadeParametro();
						break;
					case "THRESHOLD":
						parametro = new ThresholdParametro();
						((ThresholdParametro) parametro)
								.setTempoTolerancia(new Integer((int) dbObj.get("tempoTolerancia")));
						((ThresholdParametro) parametro).setThreshold(new Long((long) dbObj.get("threshold")));
						break;
					}
					if (parametro != null) {
						parametro.setAtivado(new Boolean((boolean) dbObj.get("ativado")));
					}
					servidor.getParametros().add(parametro);
				}
			});
		}
		return servidor;
	}

	@Override
	protected DBObject convert(Servidor obj) {
		BasicDBObject result = new BasicDBObject("id", obj.getId()).append("descricao", obj.getDescricao())
				.append("ativo", obj.getAtivo()).append("senha", obj.getSenha());
		BasicDBList params = new BasicDBList();
		for (Parametro parametro : obj.getParametros()) {
			BasicDBObject p = new BasicDBObject("ativado", parametro.getAtivado()).append("tipoParametro",
					parametro.getTipoParametro().name());
			if (TipoParametro.THRESHOLD.equals(parametro.getTipoParametro())) {
				ThresholdParametro tp = ((ThresholdParametro) parametro);
				p.append("threshold", tp.getThreshold());
				p.append("tempoTolerancia", tp.getTempoTolerancia());
			}
			params.add(p);
		}
		result.append("parametros", params);
		return result;
	}

}

package br.com.idtrust.meerkwatch.dao;

import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import br.com.idtrust.meerkwatch.model.DisponibilidadeResultadoMonitoramento;
import br.com.idtrust.meerkwatch.model.ParametroChecagem;
import br.com.idtrust.meerkwatch.model.ParametroChecagemDisponibilidade;
import br.com.idtrust.meerkwatch.model.ParametroChecagemThreshold;
import br.com.idtrust.meerkwatch.model.ResultadoMonitoramento;
import br.com.idtrust.meerkwatch.model.ThresholdResultadoMonitoramento;
import br.com.idtrust.meerkwatch.model.TipoParametro;

public class ResultadoMonitoramentoDAO extends DAO<ResultadoMonitoramento> {

	private static final long serialVersionUID = -292396641825354676L;

	public List<ResultadoMonitoramento> buscarPorServidor(String idServidor) {
		return convertCursor(getCollection().find(new BasicDBObject("idServidor", idServidor)));
	}

	public List<ResultadoMonitoramento> buscarUltimosMonitoramentos(String idServidor, TipoParametro tipoParametro,
			ParametroChecagem checagem, int quantidade) {
		BasicDBObject query = new BasicDBObject("idServidor", idServidor).append("parametroChecagem",
				checagem.toString());
		switch (tipoParametro) {
		case DISPONIBILIDADE:
			query.append("tipo", "D");
			break;
		case THRESHOLD:
			query.append("tipo", "T");
			break;
		}
		return convertCursor(
				getCollection().find(query).sort(new BasicDBObject("dataMonitoramento", -1)).limit(quantidade));
	}

	@Override
	protected DBObject getIdQuery(ResultadoMonitoramento obj) {
		return new BasicDBObject("idServidor", obj.getIdServidor()).append("tipo", getTipoFromResultado(obj))
				.append("parametroChecagem", obj.getParametroChecagem().toString());
	}

	@Override
	protected String getCollectionName() {
		return "resultadoMonitoramento";
	}

	@Override
	protected ResultadoMonitoramento transform(DBObject obj) {
		ResultadoMonitoramento resultado = null;
		switch (String.valueOf(obj.get("tipo"))) {
		case "D":
			resultado = new DisponibilidadeResultadoMonitoramento();
			resultado.setParametroChecagem(
					ParametroChecagemDisponibilidade.valueOf(String.valueOf(obj.get("parametroChecagem"))));
			((DisponibilidadeResultadoMonitoramento) resultado)
					.setValorObtido(new Boolean((boolean) obj.get("valorObtido")));
			break;
		case "T":
			resultado = new ThresholdResultadoMonitoramento();
			resultado.setParametroChecagem(
					ParametroChecagemThreshold.valueOf(String.valueOf(obj.get("parametroChecagem"))));

			((ThresholdResultadoMonitoramento) resultado).setValorObtido((long) obj.get("valorObtido"));
			break;
		}
		resultado.setDataMonitoramento(new Date((long) obj.get("dataMonitoramento")));
		resultado.setIdServidor(String.valueOf(obj.get("idServidor")));
		return resultado;
	}

	@Override
	protected DBObject convert(ResultadoMonitoramento obj) {
		BasicDBObject result = new BasicDBObject("dataMonitoramento", obj.getDataMonitoramento().getTime())
				.append("idServidor", obj.getIdServidor())
				.append("parametroChecagem", obj.getParametroChecagem().toString());
		if (obj instanceof DisponibilidadeResultadoMonitoramento) {
			result.append("tipo", "D").append("valorObtido",
					((DisponibilidadeResultadoMonitoramento) obj).getValorObtido());
		} else if (obj instanceof ThresholdResultadoMonitoramento) {
			result.append("tipo", "T").append("valorObtido", ((ThresholdResultadoMonitoramento) obj).getValorObtido());
		}

		return result;
	}

	private String getTipoFromResultado(ResultadoMonitoramento resultado) {
		if (resultado instanceof DisponibilidadeResultadoMonitoramento) {
			return "D";
		} else if (resultado instanceof ThresholdResultadoMonitoramento) {
			return "T";
		} else {
			return null;
		}
	}

}

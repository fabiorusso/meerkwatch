package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.dao.OcorrenciaDAO;
import br.com.idtrust.meerkwatch.dao.ResultadoMonitoramentoDAO;
import br.com.idtrust.meerkwatch.model.Ocorrencia;
import br.com.idtrust.meerkwatch.model.ResultadoMonitoramento;

@SessionScoped
public class RelatorioController implements Serializable {

	private static final long serialVersionUID = 3486045678615617995L;

	@Inject
	private OcorrenciaDAO ocorrenciaDAO;

	@Inject
	private ResultadoMonitoramentoDAO resultadoMonitoramentoDAO;

	public void gerarRelatorio(String idServidor, Date dataInicial, Date dataFinal) {
		List<ResultadoMonitoramento> resultados = resultadoMonitoramentoDAO.buscarMonitoramentosEntre(idServidor,
				dataInicial, dataFinal);
		List<Ocorrencia> ocorrencias = ocorrenciaDAO.buscarPorServidorEPeriodo(idServidor, dataInicial, dataFinal);
		// TODO: realizar a agregação dos dados para gerar o relatório
	}

}

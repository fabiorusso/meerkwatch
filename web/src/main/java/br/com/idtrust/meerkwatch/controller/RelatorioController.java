package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.sql.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.dao.OcorrenciaDAO;

@SessionScoped
public class RelatorioController implements Serializable {

	private static final long serialVersionUID = 3486045678615617995L;

	@Inject
	private OcorrenciaDAO ocorrenciaDAO;

	public void gerarRelatorio(String idServidor, Date dataInicial, Date dataFinal) {
		// TODO: gerar relatório
	}

}

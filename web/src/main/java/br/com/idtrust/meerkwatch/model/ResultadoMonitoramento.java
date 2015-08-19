package br.com.idtrust.meerkwatch.model;

import java.util.Date;

public abstract class ResultadoMonitoramento {

	private Long id;
	private Parametro parametro;
	private Date dataMonitoramento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public Date getDataMonitoramento() {
		return dataMonitoramento;
	}

	public void setDataMonitoramento(Date dataMonitoramento) {
		this.dataMonitoramento = dataMonitoramento;
	}

}

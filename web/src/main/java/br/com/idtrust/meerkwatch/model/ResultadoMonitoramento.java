package br.com.idtrust.meerkwatch.model;

import java.util.Date;

public abstract class ResultadoMonitoramento {

	private String idServidor;
	private ParametroChecagem parametroChecagem;
	private Date dataMonitoramento;

	public ResultadoMonitoramento() {
		this.dataMonitoramento = new Date();
	}

	public Date getDataMonitoramento() {
		return dataMonitoramento;
	}

	public void setDataMonitoramento(Date dataMonitoramento) {
		this.dataMonitoramento = dataMonitoramento;
	}

	public String getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(String idServidor) {
		this.idServidor = idServidor;
	}

	public ParametroChecagem getParametroChecagem() {
		return parametroChecagem;
	}

	public void setParametroChecagem(ParametroChecagem parametroChecagem) {
		this.parametroChecagem = parametroChecagem;
	}

}

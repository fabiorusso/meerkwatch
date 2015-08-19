package br.com.idtrust.meerkwatch.model;

import java.util.Date;

public class Ocorrencia {

	private Date data;
	private String mensagem;
	private Servidor servidor;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

}

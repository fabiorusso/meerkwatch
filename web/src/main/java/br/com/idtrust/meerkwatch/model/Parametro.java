package br.com.idtrust.meerkwatch.model;

public abstract class Parametro {

	private Servidor servidor;
	private Boolean ativado;

	protected abstract TipoParametro getTipoParametro();

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Boolean getAtivado() {
		return ativado;
	}

	public void setAtivado(Boolean ativado) {
		this.ativado = ativado;
	}

}

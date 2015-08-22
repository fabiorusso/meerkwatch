package br.com.idtrust.meerkwatch.model;

public abstract class Parametro {

	private Boolean ativado;

	public abstract TipoParametro getTipoParametro();

	public Parametro() {
		this.ativado = Boolean.FALSE;
	}

	public Boolean getAtivado() {
		return ativado;
	}

	public void setAtivado(Boolean ativado) {
		this.ativado = ativado;
	}

}

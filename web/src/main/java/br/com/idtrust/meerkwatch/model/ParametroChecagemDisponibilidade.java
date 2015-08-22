package br.com.idtrust.meerkwatch.model;

public enum ParametroChecagemDisponibilidade implements ParametroChecagem {
	HTTP, SMTP;

	@Override
	public String toString() {
		return this.name();
	}

}

package br.com.idtrust.meerkwatch.model;

public enum ParametroChecagemThreshold implements ParametroChecagem {
	CPU, MEMORIA, ARMAZENAMENTO;

	@Override
	public String toString() {
		return this.name();
	}

}

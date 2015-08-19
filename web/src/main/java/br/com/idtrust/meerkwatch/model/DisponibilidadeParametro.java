package br.com.idtrust.meerkwatch.model;

public class DisponibilidadeParametro extends Parametro {

	@Override
	protected TipoParametro getTipoParametro() {
		return TipoParametro.DISPONIBILIDADE;
	}

}

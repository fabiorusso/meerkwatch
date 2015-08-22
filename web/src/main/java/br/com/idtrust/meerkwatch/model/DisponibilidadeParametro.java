package br.com.idtrust.meerkwatch.model;

public class DisponibilidadeParametro extends Parametro {

	@Override
	public TipoParametro getTipoParametro() {
		return TipoParametro.DISPONIBILIDADE;
	}

}

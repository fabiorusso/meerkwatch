package br.com.idtrust.meerkwatch.model;

public class ThresholdParametro extends Parametro {

	private Long threshold;
	private Integer tempoTolerancia;

	@Override
	public TipoParametro getTipoParametro() {
		return TipoParametro.THRESHOLD;
	}

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public Integer getTempoTolerancia() {
		return tempoTolerancia;
	}

	public void setTempoTolerancia(Integer tempoTolerancia) {
		this.tempoTolerancia = tempoTolerancia;
	}

}

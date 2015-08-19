package br.com.idtrust.meerkwatch.model;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

	private Long id;
	private String descricao;
	private List<Parametro> parametros;

	public Servidor() {
		this.parametros = new ArrayList<Parametro>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

}

package br.com.idtrust.meerkwatch.model;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

	private String id;
	private String descricao;
	private String senha;
	private Boolean ativo;
	private List<Parametro> parametros;

	public Servidor() {
		this.parametros = new ArrayList<Parametro>();
		this.ativo = Boolean.FALSE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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

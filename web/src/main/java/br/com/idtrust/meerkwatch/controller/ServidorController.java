package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.dao.ServidorDAO;
import br.com.idtrust.meerkwatch.model.Servidor;

@SessionScoped
public class ServidorController implements Serializable {

	private static final long serialVersionUID = 2384796905434449043L;

	@Inject
	private ServidorDAO servidorDAO;

	private void verificarOuGerarSenha() {
		// TODO:
	}

	private void validarDados(Servidor servidor) {
		// TODO:
	}

	public void download(String idServidor) {
		// TODO:
	}

	public void gerarPacoteInstalacao() {

	}

	public List<Servidor> buscarServidores() {
		return servidorDAO.findAll();
	}

	public void novoServidor(Servidor servidor) {
		// TODO:
	}

	public void atualizarServidor(Servidor servidor) {
		// TODO:
	}

	public void ativarOuDesativar(Servidor servidor) {

	}

	public void excluirServidor(Servidor servidor) {
		// TODO:
	}

}

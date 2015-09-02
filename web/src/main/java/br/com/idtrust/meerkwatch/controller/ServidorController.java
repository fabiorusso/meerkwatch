package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.LoggedIn;
import br.com.idtrust.meerkwatch.dao.ServidorDAO;
import br.com.idtrust.meerkwatch.model.Servidor;
import br.com.idtrust.meerkwatch.model.TipoUsuario;
import br.com.idtrust.meerkwatch.model.Usuario;

@SessionScoped
public class ServidorController implements Serializable {

	private static final long serialVersionUID = 2384796905434449043L;

	@Inject
	private ServidorDAO servidorDAO;

	@Inject
	@LoggedIn
	private Usuario usuarioLogado;

	private void verificarOuGerarSenha() {
		// TODO: realizar mecanismo de gerar senha antes de criar o pacote de
		// instalação
	}

	private void validarDados(Servidor servidor) {
		if (servidor.getDescricao() == null || servidor.getDescricao().trim().isEmpty()) {
			throw new IllegalArgumentException("Descrição é obrigatória");
		}
		if (servidor.getId() == null || servidor.getId().trim().isEmpty()) {
			throw new IllegalArgumentException("Identificador é obrigatório");
		}
		if (servidor.getParametros() == null || servidor.getParametros().isEmpty()) {
			throw new IllegalArgumentException("É necessário pelo menos um parâmetro para o servidor");
		}
	}

	public byte[] download(String idServidor) {
		return gerarPacoteInstalacao();
	}

	public byte[] gerarPacoteInstalacao() {
		// TODO: fazer mecanismo de criação do pacote de instalação do
		// monitoramento
		return null;
	}

	public List<Servidor> buscarServidores() {
		return servidorDAO.findAll();
	}

	public void novoServidor(Servidor servidor) {
		if (TipoUsuario.ADMINISTRADOR.equals(usuarioLogado.getTipo())) {
			throw new IllegalAccessError("Tipo de usuário é inválido");
		}
		validarDados(servidor);
		servidorDAO.atualizar(servidor);
	}

	public void atualizarServidor(Servidor servidor) {
		validarDados(servidor);
		servidorDAO.atualizar(servidor);
	}

	public void ativarOuDesativar(Servidor servidor) {
		if (servidor.getAtivo()) {
			servidor.setAtivo(Boolean.FALSE);
		} else {
			servidor.setAtivo(Boolean.TRUE);
		}
		servidorDAO.atualizar(servidor);
	}

	public void excluirServidor(Servidor servidor) {
		// TODO:
	}

}

package br.com.idtrust.meerkwatch.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.idtrust.meerkwatch.dao.ServidorDAO;
import br.com.idtrust.meerkwatch.model.DisponibilidadeParametro;
import br.com.idtrust.meerkwatch.model.Servidor;
import br.com.idtrust.meerkwatch.model.ThresholdParametro;

@Ignore
public class ServidorDAOTest {

	private ServidorDAO servidorDAO;

	@Before
	public void init() {
		this.servidorDAO = new ServidorDAO();
	}

	@Test
	public void testSave() {
		Servidor servidor = new Servidor();
		servidor.setId("1");
		servidor.setDescricao("teste");

		ThresholdParametro tp = new ThresholdParametro();
		tp.setAtivado(true);
		tp.setThreshold(80L);
		tp.setTempoTolerancia(10);
		servidor.getParametros().add(tp);

		DisponibilidadeParametro dp = new DisponibilidadeParametro();
		dp.setAtivado(true);
		servidor.getParametros().add(dp);

		servidorDAO.salvar(servidor);
	}

	@Test
	public void testSalvarSenha() {
		servidorDAO.salvarSenha("1", "123456");
		Servidor servidor = servidorDAO.buscarPorIdentificador("1");
		Assert.assertEquals("123456", servidor.getSenha());
	}

	@Test
	public void testFind() {
		List<Servidor> servidor = servidorDAO.findAll();
		Assert.assertNotNull(servidor);
	}

	@Test
	public void testRemove() {
		Servidor servidor = new Servidor();
		servidor.setId("1");
		servidorDAO.excluir(servidor);
	}

}

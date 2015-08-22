package br.com.idtrust.meerkwatch.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.idtrust.meerkwatch.dao.ResultadoMonitoramentoDAO;
import br.com.idtrust.meerkwatch.model.DisponibilidadeResultadoMonitoramento;
import br.com.idtrust.meerkwatch.model.ParametroChecagemDisponibilidade;
import br.com.idtrust.meerkwatch.model.ParametroChecagemThreshold;
import br.com.idtrust.meerkwatch.model.ResultadoMonitoramento;
import br.com.idtrust.meerkwatch.model.ThresholdResultadoMonitoramento;
import br.com.idtrust.meerkwatch.model.TipoParametro;

@Ignore
public class ResultadoMonitoramentoTest {

	private ResultadoMonitoramentoDAO dao;

	@Before
	public void init() {
		this.dao = new ResultadoMonitoramentoDAO();
	}

	@Test
	public void testSave() {
		DisponibilidadeResultadoMonitoramento res = new DisponibilidadeResultadoMonitoramento();
		res.setIdServidor("1");
		res.setParametroChecagem(ParametroChecagemDisponibilidade.HTTP);
		res.setValorObtido(true);
		dao.salvar(res);

		ThresholdResultadoMonitoramento t = new ThresholdResultadoMonitoramento();
		t.setIdServidor("1");
		t.setParametroChecagem(ParametroChecagemThreshold.CPU);
		t.setValorObtido(1L);
		dao.salvar(t);
	}

	@Test
	public void testBuscarUltimos() {
		List<ResultadoMonitoramento> res = dao.buscarUltimosMonitoramentos("1", TipoParametro.DISPONIBILIDADE,
				ParametroChecagemDisponibilidade.HTTP, 10);
		Assert.assertEquals(1, res.size());

		res = dao.buscarUltimosMonitoramentos("1", TipoParametro.THRESHOLD, ParametroChecagemThreshold.MEMORIA, 10);
		Assert.assertEquals(0, res.size());

		res = dao.buscarUltimosMonitoramentos("1", TipoParametro.THRESHOLD, ParametroChecagemThreshold.CPU, 10);
		Assert.assertEquals(1, res.size());
	}

	@Test
	public void testRemove() {
		ResultadoMonitoramento res = new DisponibilidadeResultadoMonitoramento();
		res.setIdServidor("1");
		res.setParametroChecagem(ParametroChecagemDisponibilidade.HTTP);
		dao.excluir(res);
		res = new ThresholdResultadoMonitoramento();
		res.setIdServidor("1");
		res.setParametroChecagem(ParametroChecagemThreshold.CPU);
		dao.excluir(res);
	}
}

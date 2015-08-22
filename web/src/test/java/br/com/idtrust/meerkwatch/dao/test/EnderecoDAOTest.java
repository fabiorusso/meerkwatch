package br.com.idtrust.meerkwatch.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.idtrust.meerkwatch.dao.EmailDAO;
import br.com.idtrust.meerkwatch.model.Email;

@Ignore
public class EnderecoDAOTest {

	static final String EMAIL_TESTE = "teste@teste.com";

	private EmailDAO emailDAO;

	@Before
	public void init() {
		this.emailDAO = new EmailDAO();
	}

	@Test
	public void testBuscarEmail() {
		Email email = this.emailDAO.buscarEmail(EMAIL_TESTE);
		Assert.assertEquals(null, email);
	}

	@Test
	public void testSaveEmail() {
		Email email = new Email();
		email.setEndereco("teste@teste.com.br");
		emailDAO.salvar(email);
		Email tmp = emailDAO.buscarEmail(EMAIL_TESTE);
		Assert.assertNotNull(tmp);
		emailDAO.excluir(email);
		tmp = emailDAO.buscarEmail(EMAIL_TESTE);
		Assert.assertNull(tmp);
	}

}

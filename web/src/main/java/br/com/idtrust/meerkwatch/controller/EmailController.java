package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import br.com.idtrust.meerkwatch.dao.EmailDAO;
import br.com.idtrust.meerkwatch.model.Email;

@SessionScoped
public class EmailController implements Serializable {

	private static final long serialVersionUID = 1936958493391194270L;

	@Inject
	private EmailDAO emailDAO;

	public void enviarEmail(Email email) {
	}

	public List<Email> visualizarEmails() {
		return emailDAO.findAll();
	}

}

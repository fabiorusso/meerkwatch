package br.com.idtrust.meerkwatch.controller;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.com.idtrust.meerkwatch.dao.EmailDAO;
import br.com.idtrust.meerkwatch.model.Email;

@SessionScoped
public class EmailController implements Serializable {

	private static final long serialVersionUID = 1936958493391194270L;

	private static final String BCC_ADDRESSES = "ricardo.vanhoz@gmail.com";

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	@Resource(lookup = "java:jboss/mail/meerkwatch")
	private Session mailSession;

	@Inject
	private EmailDAO emailDAO;

	public void enviarEmail(Email email, String assunto, String conteudo) {
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				try {
					MimeMessage msg = new MimeMessage(mailSession);
					msg.setSubject(assunto);
					msg.addFrom(InternetAddress.parse("noreply@meerkwatch.com.br"));
					msg.addRecipients(RecipientType.TO, InternetAddress.parse(email.getEndereco()));
					msg.addRecipients(RecipientType.BCC, InternetAddress.parse(BCC_ADDRESSES));

					MimeBodyPart body = new MimeBodyPart();
					body.setText(conteudo);

					MimeMultipart mm = new MimeMultipart();
					mm.addBodyPart(body);
					msg.setContent(mm);

					Transport.send(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public List<Email> visualizarEmails() {
		return emailDAO.findAll();
	}
}

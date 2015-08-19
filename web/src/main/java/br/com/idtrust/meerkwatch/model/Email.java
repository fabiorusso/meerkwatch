package br.com.idtrust.meerkwatch.model;

import java.util.regex.Pattern;

public class Email {

	private String endereco;

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean validarEmail() {
		if (endereco != null) {
			final String REGEX_EMAIL = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
			return Pattern.matches(REGEX_EMAIL, endereco);

		}
		return false;
	}

}

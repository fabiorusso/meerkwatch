package br.com.idtrust.meerkwatch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Utils {

	private static final String HASH_ALG = "SHA256";
	private static final byte[] PASSWORD_SALT = "]B2]'&k[/4MKwj3,!kO;{%:;r".getBytes();

	public static String converterSenha(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance(HASH_ALG);
			md.update(senha.getBytes());
			md.update(PASSWORD_SALT);

			String encrypted = new HexBinaryAdapter().marshal(PASSWORD_SALT);

			return encrypted;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Não foi possível converter a senha: " + e.getMessage());
		}

	}

}

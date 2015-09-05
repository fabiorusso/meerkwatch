package br.com.idtrust.meerkwatch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

public class Utils {

	public static String converterSenha(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance(CustomDigestCallback.HASH_ALG);
			md.update(senha.getBytes());
			md.update(CustomDigestCallback.PASSWORD_SALT);

			String encrypted = new HexBinaryAdapter().marshal(CustomDigestCallback.PASSWORD_SALT);

			return encrypted;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Não foi possível converter a senha: " + e.getMessage());
		}

	}

}

package br.com.idtrust.meerkwatch;

import java.security.MessageDigest;
import java.util.Map;

import org.jboss.crypto.digest.DigestCallback;

public class CustomDigestCallback implements DigestCallback {

	public static final String HASH_ALG = "SHA256";
	public static final byte[] PASSWORD_SALT = "]B2]'&k[/4MKwj3,!kO;{%:;r".getBytes();

	@Override
	public void init(Map<String, Object> arg0) {
	}

	@Override
	public void postDigest(MessageDigest md) {
		md.update(PASSWORD_SALT);
	}

	@Override
	public void preDigest(MessageDigest arg0) {
	}

}

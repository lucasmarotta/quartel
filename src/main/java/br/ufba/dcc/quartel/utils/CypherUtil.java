package br.ufba.dcc.quartel.utils;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.registry.AlgorithmRegistry;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.google.common.collect.ImmutableList;

import br.ufba.dcc.quartel.app.AppConstants;

public class CypherUtil 
{
	public static String defaultAlgorithm = "SHA-256";
	public static final String MD5_ALGORITHM = "MD5";
	public static final String SHA1_ALGORITHM = "SHA-1";
	public static final String SHA256_ALGORITHM = "SHA-256";
	public static final String SHA512_ALGORITHM = "SHA-512";
	public static final String PBE_ALGORITHM = "PBEWithMD5AndDES";
	public static final int PBE_BYTE_SIZE = 96;
	private static final Logger LOGGER = LogManager.getLogger(CypherUtil.class);
	
	public static String getDefaultAlgorithm() 
	{
		return defaultAlgorithm;
	}

	public static void setDefaultAlgorithm(String defaultAlgorithm) 
	{
		CypherUtil.defaultAlgorithm = defaultAlgorithm;
	}
	
	public static ConfigurablePasswordEncryptor getEncryptor()
	{
		return getEncryptor(defaultAlgorithm, false);
	}
	
	public static ConfigurablePasswordEncryptor getEncryptor(String algorithm)
	{
		return getEncryptor(algorithm, false);
	}
	
	public static ConfigurablePasswordEncryptor getEncryptor(String algorithm, boolean base64)
	{
		ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
		encryptor.setAlgorithm(algorithm);
		if(base64) encryptor.setStringOutputType("base64");
		else encryptor.setStringOutputType("hexadecimal");
		return encryptor;
	}
	
	public static StandardPBEStringEncryptor getPBEEncryptor()
	{
		return getPBEEncryptor(AppConstants.APP_KEY, false);
	}
	
	public static StandardPBEStringEncryptor getPBEEncryptor(String pass)
	{
		return getPBEEncryptor(pass, PBE_ALGORITHM, false);
	}
	
	public static StandardPBEStringEncryptor getPBEEncryptor(String pass, boolean base64)
	{
		return getPBEEncryptor(pass, PBE_ALGORITHM, base64);
	}
	
	public static StandardPBEStringEncryptor getPBEEncryptor(String pass, String algorithm, boolean base64)
	{
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm(algorithm);
		encryptor.setPassword(pass);
		if(base64) encryptor.setStringOutputType("base64");
		else encryptor.setStringOutputType("hexadecimal");
		return encryptor;
	}
	
	public static StandardPBEByteEncryptor getPBEByteEncryptor()
	{
		return getPBEByteEncryptor(AppConstants.APP_KEY, PBE_ALGORITHM);
	}
	
	public static StandardPBEByteEncryptor getPBEByteEncryptor(String pass)
	{
		return getPBEByteEncryptor(pass, PBE_ALGORITHM);
	}
	
	public static StandardPBEByteEncryptor getPBEByteEncryptor(String pass, String algorithm)
	{
		StandardPBEByteEncryptor encryptor = new StandardPBEByteEncryptor();
		encryptor.setAlgorithm(algorithm);
		encryptor.setPassword(pass);
		return encryptor;
	}	
	
	public static String hash(String input)
	{
		return hash(input, defaultAlgorithm, false);
	}

	public static String hash(String input, String algorithm)
	{
		return hash(input, algorithm, false);
	}
	
	public static String hash(String input, String algorithm, boolean base64)
	{
		final ConfigurablePasswordEncryptor encryptor = getEncryptor(algorithm, base64);
		encryptor.setPlainDigest(true);
		return encryptor.encryptPassword(input);
	}
	
	public static String hashSecret(String key)
	{
		return hashSecret(key, defaultAlgorithm, false);
	}
	
	public static String hashSecret(String key, String algorithm)
	{
		return hashSecret(key, algorithm, false);
	}
	
	public static String hashSecret(String key, String algorithm, boolean base64)
	{
		final ConfigurablePasswordEncryptor encryptor = getEncryptor(algorithm, base64);
		return encryptor.encryptPassword(key);
	}
	
	public static String encryptString(String input)
	{
		return encryptString(input, AppConstants.APP_KEY);
	}
	
	public static String encryptString(String input, String password)
	{
		return encryptString(input, password, false);
	}
	
	public static String encryptString(String input, String password, boolean base64)
	{
		StandardPBEStringEncryptor encryptor = getPBEEncryptor(password, base64);
		return encryptor.encrypt(input);	
	}
	
	public static String decryptString(String input)
	{
		return decryptString(input, AppConstants.APP_KEY);
	}
	
	public static String decryptString(String input, String password)
	{
		return decryptString(input, password, false);
	}
	
	public static String decryptString(String input, String password, boolean base64)
	{
		StandardPBEStringEncryptor encryptor = getPBEEncryptor(password, base64);
		try {
			return encryptor.decrypt(input);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static boolean checkHashSecret(String secretHash, String key)
	{
		return checkHashSecret(secretHash, key, defaultAlgorithm, false);
	}
	
	public static boolean checkHashSecret(String secretHash, String key, String algorithm)
	{
		return checkHashSecret(secretHash, key, algorithm, false);
	}
	
	public static boolean checkHashSecret(String secretHash, String key, String algorithm, boolean base64)
	{
		final ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
		encryptor.setAlgorithm(algorithm);
		if(base64) encryptor.setStringOutputType("base64");
		else encryptor.setStringOutputType("hexadecimal");
		return encryptor.checkPassword(key, secretHash);
	}
	
	public static String generateRandomSalt()
	{
		return generateRandomSalt(32);
	}
	
	public static String generateRandomSalt(int byteSize)
	{
		RandomSaltGenerator salt = new RandomSaltGenerator();
		return Base64.getEncoder().encodeToString(salt.generateSalt(byteSize));
	}
	
	public static byte[] getRandomBytes()
	{
		return getRandomBytes(32);
	}
	
	public static byte[] getRandomBytes(int byteSize)
	{
		RandomSaltGenerator salt = new RandomSaltGenerator();
		return salt.generateSalt(byteSize);
	}
	
	public static ImmutableList<String> getAlgorithms()
	{
		ArrayList<String> algos = new ArrayList<String>();
		Set<?> pbeAlgos = AlgorithmRegistry.getAllDigestAlgorithms();
		for (Object object : pbeAlgos) 
		{
			algos.add(object.toString());
		}
		pbeAlgos = AlgorithmRegistry.getAllPBEAlgorithms();
		for (Object object : pbeAlgos) 
		{
			algos.add(object.toString());
		}		
		return ImmutableList.<String>builder().addAll(algos).build();
	}
}

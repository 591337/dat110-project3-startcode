package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest

		// compute the hash of the input 'entity'

		// convert the hash into hex format

		// convert the hex into BigInteger

		// return the BigInteger

		byte[] hash = null;
		try {
			hash = entity.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			hash = md.digest(hash);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String hex = toHex(hash);

		hashint = new BigInteger(hex, 16);

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// get the digest length

		// compute the number of bits = digest length * 8

		// compute the address size = 2 ^ number of bits

		// return the address size

		BigInteger b = new BigInteger("2");

		return b.pow(bitSize());
	}

	public static int bitSize() {

		int diglen = 0;
		try {
			diglen = MessageDigest.getInstance("MD5").digest().length;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diglen * 8;		

		// find the digest length

	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}

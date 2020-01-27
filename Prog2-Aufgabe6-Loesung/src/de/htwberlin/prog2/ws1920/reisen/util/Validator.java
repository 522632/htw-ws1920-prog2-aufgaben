package de.htwberlin.prog2.ws1920.reisen.util;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Validator {

	public static boolean isValidReservierungsnummer(long reservierungsnummer) {

		return (reservierungsnummer > 0);

	}
}

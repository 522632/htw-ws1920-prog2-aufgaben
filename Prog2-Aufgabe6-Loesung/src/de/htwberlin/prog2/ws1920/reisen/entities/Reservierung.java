package de.htwberlin.prog2.ws1920.reisen.entities;

import java.util.UUID;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public abstract class Reservierung {

	private String reservierunsnummer;
	private String datum;
	private double summe;

	/**
	 * @param datum
	 */
	public Reservierung(String datum) {
		this.datum = datum;
		this.reservierunsnummer = UUID.randomUUID().toString().split("-")[0].toUpperCase();

	}

	/**
	 * @return the summe
	 */
	public double getSumme() {
		return this.summe;
	}

	/**
	 * @param summe the summe to set
	 */
	public void setSumme(double summe) {
		this.summe = summe;
	}

	/**
	 * @return the reservierunsnummer
	 */
	public String getReservierunsnummer() {
		return this.reservierunsnummer;
	}

	/**
	 * @return the datum
	 */
	public String getDatum() {
		return this.datum;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.reservierunsnummer);
		builder.append(". ");
		if (this.datum != null) {
			builder.append(this.datum);
			builder.append(", ");
		}
//		builder.append(this.summe);
//		builder.append(" EURO");
		return builder.toString();
	}

}

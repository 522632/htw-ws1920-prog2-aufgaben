package de.htwberlin.prog2.ws1920.reisen.entities;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public abstract class Reservierung {

	private long reservierunsnummer;
	private String datum;
	private double summe;
	private static long nextReservierungsnummer = 1;

	/**
	 * @param datum
	 */
	public Reservierung(String datum) {
		this.datum = datum;
		this.reservierunsnummer = nextReservierungsnummer++;

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
	public long getReservierunsnummer() {
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
		builder.append(this.summe);
		builder.append(" EURO");
		return builder.toString();
	}

}

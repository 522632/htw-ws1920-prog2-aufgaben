package de.htwberlin.prog2.ws1920.reisen.entities;

import de.htwberlin.prog2.ws1920.reisen.util.Settings;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public abstract class Kunde {
	private long kundennummer;
	private Anrede anrede;
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	private Adresse adresse;
	private String telefonnummer;
	private String email;
	private Reservierung reservierungen[];

	private static long nextKundennummer = 1;

	/**
	 * @param anrede
	 * @param vorname
	 * @param nachname
	 */
	public Kunde(Anrede anrede, String vorname, String nachname) {
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.reservierungen = new Reservierung[Settings.MAX_RESERVIERUNGEN_PRO_KUNDE];

		this.kundennummer = nextKundennummer++;
	}

	public abstract String getName();

	public abstract Bezahlmethode[] getBazahlMethoden();

	/**
	 * @return the anrede
	 */
	public Anrede getAnrede() {
		return this.anrede;
	}

	/**
	 * @param anrede the anrede to set
	 */
	public void setAnrede(Anrede anrede) {
		this.anrede = anrede;
	}

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return this.vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return this.nachname;
	}

	/**
	 * @param nachname the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return the geburtsdatum
	 */
	public String getGeburtsdatum() {
		return this.geburtsdatum;
	}

	/**
	 * @param geburtsdatum the geburtsdatum to set
	 */
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return this.adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the telefonnummer
	 */
	public String getTelefonnummer() {
		return this.telefonnummer;
	}

	/**
	 * @param telefonnummer the telefonnummer to set
	 */
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the kundennummer
	 */
	public long getKundennummer() {
		return this.kundennummer;
	}

	/**
	 * @return the reservierungen
	 */
	public Reservierung[] getReservierungen() {
		return this.reservierungen;
	}

	public boolean addReservierung(Reservierung reservierung) {
		for (int i = 0; i < this.reservierungen.length; i++) {
			if (this.reservierungen[i] == null) {
				this.reservierungen[i] = reservierung;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.vorname + " " + this.nachname;
	}

}

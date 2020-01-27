package de.htwberlin.prog2.ws1920.reisen.entities;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Bezahlmethode {

	private String bezeichnung;
	private String beschreibung;

	/**
	 * @param bezeichnung
	 * @param beschreibung
	 */
	public Bezahlmethode(String bezeichnung, String beschreibung) {
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
	}

	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return this.bezeichnung;
	}

	/**
	 * @return the beschreibung
	 */
	public String getBeschreibung() {
		return this.beschreibung;
	}

	/**
	 * @param beschreibung the beschreibung to set
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

}

package de.htwberlin.prog2.ws1920.reisen.entities;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Geschaeftskunde extends Kunde {

	private String firmenname;
	private Bezahlmethode bezahlmethode;

	/**
	 * Geschaeftskunde bekommt die Rechnung per Email standardmäßig.
	 * 
	 * @param anrede
	 * @param vorname
	 * @param nachname
	 */
	public Geschaeftskunde(Anrede anrede, String vorname, String nachname, String firmenname) {
		super(anrede, vorname, nachname);
		this.firmenname = firmenname;
		this.bezahlmethode = new Bezahlmethode("Rechnung", "E-Mail");
	}

	/**
	 * @return the firmenname
	 */
	public String getFirmenname() {
		return this.firmenname;
	}

	public void rechnungMitDerPostSchicken() {
		this.bezahlmethode.setBeschreibung("Post");
	}

	public void rechnungPerEmailSchicken() {
		this.bezahlmethode.setBeschreibung("E-Mail");
	}

	public String getName() {
		return super.getVorname() + " " + super.getNachname() + " - " + this.firmenname;
	}

	public Bezahlmethode[] getBazahlMethoden() {
		return new Bezahlmethode[] { this.bezahlmethode };
	}

}

package de.htwberlin.prog2.ws1920.reisen.entities;

import de.htwberlin.prog2.ws1920.reisen.util.Settings;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Privatkunde extends Kunde {

	private Bezahlmethode bezahlMethoden[];

	/**
	 * @param anrede
	 * @param vorname
	 * @param nachname
	 */
	public Privatkunde(Anrede anrede, String vorname, String nachname) {
		super(anrede, vorname, nachname);
		this.bezahlMethoden = new Bezahlmethode[Settings.MAX_BEZAHLMETHODEN_PRO_KUNDE];
	}

	public String getName() {
		return super.getVorname() + " " + super.getNachname();
	}

	public Bezahlmethode[] getBazahlMethoden() {
		return this.bezahlMethoden;
	}

}

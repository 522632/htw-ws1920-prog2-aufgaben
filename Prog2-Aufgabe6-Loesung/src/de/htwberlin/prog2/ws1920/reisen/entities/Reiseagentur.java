package de.htwberlin.prog2.ws1920.reisen.entities;

import java.util.ArrayList;
import java.util.List;

import de.htwberlin.prog2.ws1920.reisen.util.Settings;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Reiseagentur {

	private Adresse adresse;
	private String ustIdnr;
	private String name;
	private Kunde kunden[];

	/**
	 * @param ustIdnr
	 * @param name
	 */
	public Reiseagentur(String name, String ustIdnr) {
		this.ustIdnr = ustIdnr;
		this.name = name;
		this.kunden = new Kunde[Settings.MAX_KUNDEN];
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
	 * @return the ustIdnr
	 */
	public String getUstIdnr() {
		return this.ustIdnr;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the kunden
	 */
	public Kunde[] getKunden() {
		return this.kunden;
	}

	public Kunde [] searchKunde(String name) {
	    List<Kunde> matchKunden = new ArrayList<>();
	    
	    for(Kunde kunde : kunden) {
	        if(kunde != null && kunde.getName().toLowerCase().contains(name.toLowerCase()) )
	            matchKunden.add(kunde);
	    }
	    return matchKunden.toArray(new Kunde[] {});
	}
	/**
	 * @param kunde the kunde to add
	 */
	public boolean addKunde(Kunde kunde) {
		for (int i = 0; i < this.kunden.length; i++) {
			if (this.kunden[i] == null) {
				this.kunden[i] = kunde;
				return true;
			}
		}

		return false;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reiseagentur [");
		if (this.name != null) {
			builder.append(this.name);
			builder.append("\n");
		}
		if (this.ustIdnr != null) {
			builder.append(this.ustIdnr);
			builder.append("\n");
		}
		if (this.adresse != null) {
			builder.append(this.adresse);
			builder.append("\n");
		}

		if (this.kunden != null) {
			builder.append("kunden:\n");
			for (Kunde kunde : this.kunden)
				if (kunde != null)
					builder.append(kunde + "\n");
		}
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @param reservierungsnummer
	 * @return
	 */
	public Reservierung reservierungSuchen(String reservierungsnummer) {

		for (Kunde kunde : this.kunden)
			if (kunde != null)
				for (Reservierung reservierung : kunde.getReservierungen())
					if (reservierung != null && reservierung.getReservierunsnummer().compareToIgnoreCase(reservierungsnummer) == 0)
						return reservierung;
		return null;
	}

}

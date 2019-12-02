package de.htwberlin.prog2.ws1920.reisen.entities;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Flugreservierung extends Reservierung {

	private String abflughafen;
	private String zielflughafen;
	private String flugnummer;

	/**
	 * @param datum
	 */
	public Flugreservierung(String abflughafen, String zielflughafen, String flugnummer, String datum) {
		super(datum);
		this.abflughafen = abflughafen;
		this.zielflughafen = zielflughafen;
		this.flugnummer = flugnummer;

	}

	/**
	 * @return the abflughafen
	 */
	public String getAbflughafen() {
		return this.abflughafen;
	}

	/**
	 * @return the zielflughafen
	 */
	public String getZielflughafen() {
		return this.zielflughafen;
	}

	/**
	 * @return the flugnummer
	 */
	public String getFlugnummer() {
		return this.flugnummer;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString() + " ");
		if (this.abflughafen != null) {
			builder.append("ab ");
			builder.append(this.abflughafen);
			builder.append(" ");
		}
		if (this.zielflughafen != null) {
			builder.append("nach ");
			builder.append(this.zielflughafen);
			builder.append(", ");
		}
		if (this.flugnummer != null) {
			builder.append("flugnummer ");
			builder.append(this.flugnummer);
		}
		return builder.toString();
	}

}

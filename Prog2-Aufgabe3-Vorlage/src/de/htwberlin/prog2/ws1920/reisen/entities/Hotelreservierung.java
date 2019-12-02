package de.htwberlin.prog2.ws1920.reisen.entities;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Hotelreservierung extends Reservierung {

	private String hotelname;
	private int reisedauer;

	/**
	 * @param datum
	 */
	public Hotelreservierung(String hotelname, String datum, int reisedauer) {
		super(datum);
		this.hotelname = hotelname;
		this.reisedauer = reisedauer;
	}

	/**
	 * @return the hotelname
	 */
	public String getHotelname() {
		return this.hotelname;
	}

	/**
	 * @return the reisedauer
	 */
	public int getReisedauer() {
		return this.reisedauer;
	}

	/**
	 * @param reisedauer the reisedauer to set
	 */
	public void setReisedauer(int reisedauer) {
		this.reisedauer = reisedauer;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString() + " ");

		builder.append(this.reisedauer);
		builder.append(" Tage ");

		if (this.hotelname != null) {
			builder.append("beim Hotel ");
			builder.append(this.hotelname);
		}
		return builder.toString();
	}
}

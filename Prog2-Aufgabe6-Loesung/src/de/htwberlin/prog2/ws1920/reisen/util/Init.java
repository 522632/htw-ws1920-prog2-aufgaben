package de.htwberlin.prog2.ws1920.reisen.util;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;

import de.htwberlin.prog2.ws1920.reisen.entities.Adresse;
import de.htwberlin.prog2.ws1920.reisen.entities.Anrede;
import de.htwberlin.prog2.ws1920.reisen.entities.Flugreservierung;
import de.htwberlin.prog2.ws1920.reisen.entities.Geschaeftskunde;
import de.htwberlin.prog2.ws1920.reisen.entities.Hotelreservierung;
import de.htwberlin.prog2.ws1920.reisen.entities.Kunde;
import de.htwberlin.prog2.ws1920.reisen.entities.Privatkunde;
import de.htwberlin.prog2.ws1920.reisen.entities.Reiseagentur;
import de.htwberlin.prog2.ws1920.reisen.entities.Reservierung;

/**
 * @author Mohammed AbuJarour (mohammed.abujarour@htw-berlin.de)
 *
 */
public class Init {

	private static String companies[] = { "Essence", "Daydream Systems", "Icecap Foods", "Wooductions", "Elitelligence",
			"Vinedustries", "Blizzart", "Mountainway", "Crowcoms", "Cloudmaster" };

	private static String hotels[] = { "Snowy Lake Hotel", "King's Flower Hotel", "Winter Cove Hotel",
			"Ebony Landscape Hotel & Spa", "Illustrious Vertex Hotel", "Southern Veil Hotel", "Antique Hotel",
			"Recreation Hotel", "Mountain Hotel & Spa", "Majestic Hotel" };

	private static String flughaefen[] = { "Altenbach", "Bischofstein", "Antden", "Grimselt", "Saumur", "Maitoise",
			"Neunsloh", "Oderhofen", "Tullaroom", "Athnard", "Groveen", "Culemstein", "Spreitendrisio", "Reistadt" };

	public static void initReiseagentur(Reiseagentur agentur) {
		Kunde kunden[] = loadKunden();
		for (Kunde kunde : kunden) {
			agentur.addKunde(kunde);
			makeSomeReservations(kunde);
		}

	}

	private static void makeSomeReservations(Kunde kunde) {

		LocalDate startDate = LocalDate.of(2019, 1, 1);
		Random rand = new Random();
		for (int i = 0; i < rand.nextInt(10); i++) {
			LocalDate from = startDate.plusDays(rand.nextInt(100));
			String datum = from
					.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).localizedBy(Locale.GERMAN));
			Reservierung reservierung;
			if (rand.nextBoolean())
				reservierung = new Hotelreservierung(hotels[i], datum, rand.nextInt(10) + 1);
			else
				reservierung = new Flugreservierung(flughaefen[i], flughaefen[flughaefen.length - i - 1],
						"FL-" + (1000 + rand.nextInt(8999)), datum);
			reservierung.setSumme(rand.nextInt(2000));
			kunde.addReservierung(reservierung);
		}
	}

	private static Kunde[] loadKunden() {

		Random rand = new Random();

		Faker faker = new Faker(Locale.GERMAN);
		
		Kunde darrin = new Privatkunde(Anrede.Herr, "Darrin", "Blake");
		Kunde maxwell = new Privatkunde(Anrede.Herr, "Maxwell", "Ferber");
		Kunde scott = new Privatkunde(Anrede.Herr, "Scott", "Turner");
		Kunde emma = new Privatkunde(Anrede.Frau, "Emma", "Toller");
		Kunde flora = new Privatkunde(Anrede.Frau, "Flora", "Toller");

		Kunde hartmann = new Geschaeftskunde(Anrede.Herr, "Hartmann", "Toller",
				companies[rand.nextInt(companies.length)]);
		Kunde vera = new Geschaeftskunde(Anrede.Frau, "Vera", "Hooker", companies[rand.nextInt(companies.length)]);
		Kunde brandt = new Geschaeftskunde(Anrede.Herr, "Brandt", "Siegel", companies[rand.nextInt(companies.length)]);
		Kunde gerhard = new Geschaeftskunde(Anrede.Herr, "Gerhard", "Fletcher",
				companies[rand.nextInt(companies.length)]);
		Kunde martina = new Geschaeftskunde(Anrede.Frau, "Martina", "Abbott",
				companies[rand.nextInt(companies.length)]);
		Kunde sara = new Geschaeftskunde(Anrede.Frau, "Sara", "Young", companies[rand.nextInt(companies.length)]);
		Kunde sabine = new Geschaeftskunde(Anrede.Frau, "Sabine", "Hunt", companies[rand.nextInt(companies.length)]);

		Kunde kunden [] = new Kunde[] { darrin, martina, maxwell, scott, emma, flora, hartmann, vera, brandt, gerhard, sara,
				sabine };
		
		for(Kunde kunde : kunden)
		{
		    Address add = faker.address();
		    long yearsToSubtract = new Random().nextInt(80);
            long monthsToSubtract = new Random().nextInt(12);
            long daysToSubtract = new Random().nextInt(28);
            LocalDate geburtsdatum = LocalDate.now().minusYears(yearsToSubtract).minusMonths(monthsToSubtract).minusDays(daysToSubtract );
		    Adresse adresse = new Adresse(add.streetName(), add.buildingNumber(), add.zipCode(), add.cityName());
            kunde.setAdresse(adresse );
            kunde.setGeburtsdatum(geburtsdatum.toString());
		}
		return kunden;

	}

}

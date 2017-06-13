package de.uni_koeln.info.java.model;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

public class PhoneBook extends ArrayList<PhoneBookEntry> {

	private static final long serialVersionUID = 6625679018064813149L;

	private transient Collator collator;

	public PhoneBook() {
		collator = Collator.getInstance();
	}

	/**
	 * 
	 * @param locale
	 */
	public PhoneBook(Locale locale) {
		collator = Collator.getInstance(locale);
	}

	/**
	 * Sortiert die Einträge des Telefonbuchs nach Nachnamen. Falls
	 * <code>reverseOrder</code> wahr ist, soll in absteigender (desc = größter
	 * Wert zuerst), andernfalls in aufsteigender (asc = kleinster Wert zuerst)
	 * Reihenfolge sortiert werden.
	 * 
	 * @param reverseOrder
	 */
	public void sortByLastName(boolean reverseOrder) {

		// TODO: Falls die Nachnamen zweier Telefonbucheinträge identisch
		// sind, d.h. die compare-Methode '0' zurück gibt, soll der Vorname
		// als weiteres Kriterium der Sortierung dienen, so dass
		// bspw. 'Müller, Anton' vor 'Müller, Thomas' steht.

		// TODO: Die Sortierung erfolgt in aufsteigender (A-Z) Reihenfolge.
		// Wenn 'reverseOrder' wahr ist, soll in absteigender (Z-A)
		// Reihenfolge sortiert werden.

		Comparator<PhoneBookEntry> lastNameComparator = new Comparator<PhoneBookEntry>() {
			@Override
			public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
				return collator.compare(o1.getLastName(), o2.getLastName());
			}
		};

		Collections.sort(this, lastNameComparator);
	}


	/**
	 * Sortiert die Einträge des Telefonbuchs nach Vornamen. Falls
	 * <code>reverseOrder</code> wahr ist, soll in absteigender (desc = größter
	 * Wert zuerst), andernfalls in aufsteigender (asc = kleinster Wert zuerst)
	 * Reihenfolge sortiert werden.
	 * 
	 * @param reverseOrder
	 */
	public void sortByFirstName(boolean reverseOrder) {

		// TODO: Die Sortierung erfolgt in aufsteigender (A-Z) Reihenfolge.
		// Wenn 'reverseOrder' wahr ist, soll in absteigender (Z-A)
		// Reihenfolge sortiert werden.

		Comparator<PhoneBookEntry> firstNameComparator = new Comparator<PhoneBookEntry>() {
			@Override
			public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
				return collator.compare(o1.getFirstName(), o2.getFirstName());
			}
		};

		Collections.sort(this, firstNameComparator);
	}

	/**
	 * Sortiert die Einträge des Telefonbuchs nach der E-Mail-Adresse.
	 */
	public void sortByEmail(boolean reverseOrder) {
		
		// TODO: Implemetation der Sortieren
	
	}

	/**
	 * Sortiert die Einträge des Telefonbuchs nach der Postleitzahl.
	 */
	public void sortByZipCode(boolean reverseOrder) {

		// TODO: Sortierung der Postleizahlen. Falls zwei Postleizahlen
		// identisch sind, soll, analog zur Sortierung der Nachnamen, der
		// Straßenname als weiteres Kriterium berücksichtigt werden.

	}

}

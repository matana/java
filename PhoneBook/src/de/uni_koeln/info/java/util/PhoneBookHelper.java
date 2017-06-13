package de.uni_koeln.info.java.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import de.uni_koeln.info.java.model.Address;
import de.uni_koeln.info.java.model.PhoneBook;
import de.uni_koeln.info.java.model.PhoneBookEntry;

public class PhoneBookHelper {

	/**
	 * Speichert das Telefonbuch als Binärdatei im Projektverzeichnis. Dieser
	 * Prozess wird als Serialisierung bezeichnet. Die Klassen der zu
	 * persistierenden Objekte müssen das Interface {@link java.io.Serializable}
	 * implementieren. Dies gilt auch für die komplexen Klassenattribute
	 * innerhalb einer Klasse (vgl. {@link PhoneBookEntry} und {@link Address}).
	 */
	public static void save(PhoneBook phoneBook) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("phoneBook.bin")));
			out.writeObject(phoneBook);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static PhoneBook loadPhoneBook() {

		// TODO: Das gespeicherte Telefonbuch soll aus der 'phonBook.bin' Datei
		// eingelesen und in das entsprechende Objekt überführt werden.

		return null;
	}

}

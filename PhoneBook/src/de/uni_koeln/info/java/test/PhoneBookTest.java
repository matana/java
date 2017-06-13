package de.uni_koeln.info.java.test;

import java.io.File;
import java.util.Collections;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_koeln.info.java.model.Address;
import de.uni_koeln.info.java.model.PhoneBook;
import de.uni_koeln.info.java.model.PhoneBookEntry;
import de.uni_koeln.info.java.util.PhoneBookHelper;

public class PhoneBookTest {

	private PhoneBook phoneBook;

	@Before
	public void init() {

		phoneBook = new PhoneBook();

		phoneBook.add(new PhoneBookEntry("Zoro", "Mariella", "3409876", new Address("Dürenerstr. 99", "Köln", "50931"),
				"mariella.zoro@mail.de"));
		phoneBook.add(new PhoneBookEntry("Schmidt", "Marie", "4701234", new Address("Zülpicherstr. 9", "Köln", "50937"),
				"schmidt.marie@mail.de"));
		phoneBook.add(new PhoneBookEntry("Frosch", "Kermit", "279087", new Address("Aachener Weiher", "Köln", "50674"),
				"the.real.kermit@muppets.com"));
		phoneBook.add(new PhoneBookEntry("Mayer", "Thömas", "4701209", new Address("Zülpicherstr. 19", "Köln", "50937"),
				"mayer.tommy@uni-koeln.de"));
		phoneBook.add(new PhoneBookEntry("Mayer", "Thomas", "2907877", new Address("Neusser Str. 233", "Köln", "50733"),
				"mayo@email.de"));
		phoneBook.add(new PhoneBookEntry("Schmidt", "Harry", "4301234", new Address("Neumarkt 9a", "Köln", "50933"),
				"yolo.harry@email.de"));
		phoneBook.add(new PhoneBookEntry("Schmidt", "Mara", "3201234", new Address("Kerpenerstr. 123", "Köln", "50937"),
				"mara.schmidt@email.com"));
		phoneBook.add(new PhoneBookEntry("Karlsdotter", "Elsa", "7701543",
				new Address("Luxemburger. 10", "Köln", "50674"), "elsa86.karld@uni-koeln.de"));
		phoneBook.add(new PhoneBookEntry("Potter", "Harry", "466565", new Address("Höninger Weg 3", "Köln", "50969"),
				"potter.harry@uni-koeln.de"));

	}
	
	@AfterClass
	public static void afterClass() {
		File file = new File("phoneBook.bin");
		if(file.exists())
			file.deleteOnExit();
	}

	@Test
	public void bookEntries() {
		
		Assert.assertNotNull(phoneBook);
		Assert.assertNotNull(phoneBook.get(0));
		Assert.assertNotNull(phoneBook.get(0).getLastName());
		Assert.assertEquals("Zoro", phoneBook.get(0).getLastName());
		Assert.assertEquals("Potter", phoneBook.get(phoneBook.size() - 1).getLastName());
	
	}

	@Test
	public void comaprableBookEntry() {
	
		Collections.sort(phoneBook);
		Assert.assertEquals("Zoro", phoneBook.get(phoneBook.size() - 1).getLastName());
	
	}

	@Test
	public void sortByLastName() {
		
		phoneBook.sortByLastName(false);
		Assert.assertEquals("Zoro", phoneBook.get(phoneBook.size() - 1).getLastName());
		phoneBook.sortByLastName(true);
		Assert.assertEquals("Zoro", phoneBook.get(0).getLastName());
	
	}

	@Test
	public void sortByFirstName() {
	
		phoneBook.sortByFirstName(false);
		Assert.assertEquals("Thömas", phoneBook.get(phoneBook.size() - 1).getFirstName());
		phoneBook.sortByFirstName(true);
		Assert.assertEquals("Thömas", phoneBook.get(0).getFirstName());
	
	}

	@Test
	public void sortByEmail() {
		
		// TODO: Implentierung der PhoneBook.sortByEmail(boolean) Methode und
		// entsprechender Unit-Tests

		Assert.assertFalse(true);
	}

	@Test
	public void sortByZipCode() {
		
		// TODO: Implentierung der PhoneBook.sortByZipCode(boolean) Methode und
		// entsprechender Unit-Tests

		Assert.assertFalse(true);
	}

	@Test
	public void serializePhoneBook() {
		
		PhoneBookHelper.save(phoneBook);
		File file = new File("phoneBook.bin");
		Assert.assertNotNull(file);
		Assert.assertTrue(file.exists());
		PhoneBook phoneBook = PhoneBookHelper.loadPhoneBook();
		Assert.assertNotNull(phoneBook);

		// TODO: Damit der letzte Test 'Assert.assertEquals(this.phoneBook,
		// phoneBook)' besteht, müssen in den Klassen 'PhoneBookEntry' und
		// 'Address' zwei weitere Methoden ergänzt werden...

		Assert.assertEquals(this.phoneBook, phoneBook);
		
	}

}

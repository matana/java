package linkedList.simple;

import java.util.Iterator;

/**
 * <p>
 * Die Klasse <code>List</code> repräsentiert eine einfach verkettete Liste:
 * <ul>
 * <li>Eine Liste ist eine endliche Folge von Elementen
 * <code>[a1,a2,...aN]</code></li>
 * <li>Ein Sonderfall ist die leere Liste <code>[]</code></li>
 * <li>Die Länge einer Liste entspricht der Anzahl ihrer Elemente</li>
 * </ul>
 * <p>
 * Im Unterschied zu einem Array erfolgt der Zugriff auf die Elemente nicht über
 * einen Index, sondern sequenziell. Dabei besitzt jedes Element eine Referenz
 * auf seinen Nachfolger, daher spricht man von einer einfachen Verkettetung.
 * Besitzt ein Element zusätzlich eine Referenz auf seinen Vorgänger, spricht
 * man von einer doppelt verketteten Liste.
 * </p>
 * <p>
 * Die Elemente der Liste werden durch die Klasse {@link Node} realisiert.
 * </p>
 */

public class List implements Iterable<Node> {

	/**
	 * Referenzen auf das erste und auf das letzte Element der Liste. Der Zeiger
	 * auf das letzte Element ermöglicht das Einfügen neuer Elemente in
	 * konstanter Zeit.
	 */
	Node first, last;

	int size = 0;

	// TODO:
	public List subList(int from, int to) {
		return null;
	}

	// TODO:
	public int[] toArray() {
		return null;
	}

	// TODO:
	public int indexOf(int value) {
		return 0;
	}

	// TODO:
	public void insertFirst(int value) {

	}

	// insert
	public void insert(Integer value) {

		Node newNode = new Node(value);

		// (1) Liste ist leer, d.h. erstes Element zeigt auf "null"
		if (first == null)
			first = last = newNode;
		else {
			// (2) Der letzte Knoten bekommt einen Nachfolger...
			last.next = newNode;
			// ... und der neue Knoten zeigt auf 'last'
			last = newNode;
		}
		// (3) Länge der Liste um eins erhöhen.
		size++;
	}

	public Integer first() {
		return first == null ? null : first.value;
	}

	public Integer last() {
		return last == null ? null : last.value;
	}

	// size
	public int size() {
		return size;
	}

	// remove
	public boolean remove(int value) {

		// (1) Liste enthält das Element nicht
		if (!contains(value)) {
			return false; // Methode wird abgebrochen
		} else {

			Node current = first;
			Node prev = null;

			// (2.1) Wert befindet sich im ersten Element
			if (first.value == value) {
				first = first.next; // ... Element wird überschrieben.
			} else {
				// (2.2) Das zu löschende Element befindet sich innerhalb der
				// Liste
				while (current != null && current.value != value) {
					prev = current;
					current = current.next;
				}
				prev.next = current.next;
			}
			// (3) Länge der Liste um 1 verringern.
			size--;
			return true;
		}

	}

	// contains
	public boolean contains(int value) {
		return contains(value, first);
	}

	private boolean contains(int value, Node current) {
		while (current != null) {
			if (current.value == value)
				return true;
			current = current.next;
		}
		return false;
	}

	// removeAll
	public void removeAll() {
		first = null;
		size = 0;
	}

	// print
	public void print() {
		print(first);
	}

	private void print(Node current) {
		if (current != null) {
			System.out.print(current.value + " ");
			print(current.next);
		}
		System.out.println();
	}

	@Override
	public Iterator<Node> iterator() {

		Iterator<Node> iterator = new Iterator<Node>() {

			Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Node next() {
				Node toReturn = current;
				current = current.next;
				return toReturn;
			}
		};
		return iterator;
	}

}

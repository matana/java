package linkedList.simple;

/**
 * <p>
 * Die Klasse Node speichert einen beliebigen Wert und eine Referenz auf seinen Nachfolger
 * (siehe: rekursive Datenstruktur).
 * </p>
 */
public class Node {

	/**
	 * Die Referenz (oder auch Zeiger) 'next' zeigt auf das nächste Element.
	 * Wenn 'next' null ist, ist das Ende der Liste erreicht.
	 */
	Node next;

	/**
	 * Der Datenwert der im Element gespeichert wird.
	 */
	Integer value;

	public Node(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Node[" + value + "] -> " + next;
	}
}

package de.uni_koeln.info.java.binarytree;
import java.util.List;

/*
 * Repräsentation eines Binärbaums:
 * 
 * (1) Auf jeden Knoten, außer der Wurzel, zeigt nur ein Knoten, der sein direkter Vorgänger ist
 * (2) Ein Binärbaum hat linke und rechter Verkettungen (max. zwei Kindknoten, diese wiederum sind potentielle Teilbäume) 
 * (3) Der Bau ist leer, wenn 'root' null ist 
 * (4) !!! WICHTIG FÜR DAS ERZEUGEN UND SUCHEN IM BAUM: Alle Datensätze mit < (kleinerem) Schlüsselwert befinden sich im LINKEN Unterbaum, alle Datensätze mit einem > (größeren) Schlüsselwert befinden sich im RECHTEN Unterbaum 
 * (5) Die Sortierfunktion erhält man gratis, sofern der Baum in der richtigen Reihenfolge (Travesierung) durchlaufen wird
 * (6) Die Laufzeit ist O(log n). Bei einem 'entarteten' Baum ist die Laufzeit O(n)
 * 
 * 
 * Hier ein Beispiel:
 * 	
 * Eingabesequenz = { 6, 9, 4, 13, 17, 1, 10, 5, 7, 3 }
 * 
 *					       (6)
 *					      /   \
 *					   (4)     (9)
 *					   / \     /  \	
 *					 (1) (5) (7)  (13)
 *					     /        /  \
 *					   (3)      (10) (17)
 *
 *  1) insert(6)
 * 
 *					        (6) <- Wurzel (root)
 *
 *  2) insert(9)
 * 
 *					        (6)
 *					      	   \
 *					            (9)
 *
 *  3) insert(4)
 * 
 *					        (6)
 *					       /   \
 *					     (4)   (9)
 * 
 * 
 *  3) insert(13)		   
 *  
 *					       (6)
 *					      /   \
 *					   (4)     (9)
 *					      		 \
 *					 			 (13)
 *
 *  4) insert(17)
 *   				       (6)
 *					      /   \
 *					   (4)     (9)
 *					   			 \
 *					 			 (13)
 *					     		    \
 *					   			    (17)
 *
 *  5) insert(1)
 *  
 *   					   (6)
 *					      /   \
 *					   (4)     (9)
 *					   /         \
 *					 (1)         (13)
 *					                \
 *					                (17)
 *
 *  6) insert(10)
 * 
 *  					   (6)
 *					      /   \
 *					   (4)     (9)
 *					   /          \
 *					 (1)          (13)
 *					              /  \
 *					            (10) (17)
 *
 *	7) insert(5) 
 *
 * 					       (6)
 *					      /   \
 *					   (4)     (9)
 *					   / \        \
 *					 (1) (5)      (13)
 *					              /  \
 *					            (10) (17)
 * 
 *	8) insert(7)
 *
 * 					       (6)
 *					      /   \
 *					   (4)     (9)
 *					   / \     /  \
 *					 (1) (5) (7)  (13)
 *					              /  \
 *					            (10) (17)
 *
 *	9) insert(3)
 *
 * 					       (6)
 *					      /   \
 *					   (4)     (9)
 *					   / \     /  \
 *					 (1) (5) (7)  (13)
 *					     /        /  \
 *					   (3)      (10) (17)
 *
 *
 * 
 * Hier ein Beispiel eines 'entarteten' Baums:
 * 
 * Eingabesequenz = { 1, 3, 4, 5, ... } 
 * 
 * 							 (1)
 * 						        \
 * 								(3)
 * 							       \
 * 								   (4)
 * 								      \
 * 									   (5)
 *									     \ ...
 *
 * NB! Eine sortierte Eingabe verändert die Laufzeit des Binärbaums zu O(n). Die Suche erfolgt linear, wie bei der einfach verketteten List.
 *
 * @author matana (Mihail Atanassov)
 * 
 */
public class BTree {
	
	
	// Die Wurzel des Binärbaums
	BTreeNode root;

	public BTree() {
		// Default-Konstruktor
	}
	
	public BTree(int[] input) {
		for (int value : input) {
			insert(value);
		}
	}

	public void insert(int value) {
		if (root == null) // Baum ist leer?
			root = new BTreeNode(value); // Wurzel wird erzeugt...
		else
			insert(root, value); // Rekursives Einfügen des Wertes 'value' im Baum
	}

	private void insert(BTreeNode currentNode, int value) {
		
		if (value < currentNode.value) { // Wert ist kleiner, als der Wert im aktuellen Knoten, d.h. wir gehen nach links...
			if (currentNode.left == null) { // Linker Teilbaum leer?
				currentNode.left = new BTreeNode(value); // Erzege neuen Knoten
			} else
				insert(currentNode.left, value); // Linker Teilbaum nicht leer, d.h. wir steigen ab (rekursiv)
		}

		if (value > currentNode.value) { // Wert ist größer, als der Wert im aktuellen Knoten, wir gehen nach rechts... 
			if (currentNode.right == null) { // Rechter Teilbaum leer?
				currentNode.right = new BTreeNode(value); // Erzege neuen Knoten
			} else
				insert(currentNode.right, value); // Rechter Teilbaum nicht leer, d.h. wir steigen ab (rekursiv)
		}
		
	}
	
	public void print() {
		if (root != null)
			print(root);
		System.out.println();
	}

	/**
	 * WURZEL = W
	 * LINKER_KNOTEN = l (rekursiv)
	 * RECHTER_KNOTEN = r (rekursiv)
	 * 
	 * Es gibt mehrere Möglichkeiten die Knoten eines Baumes zu durchlaufen, dieser Vorgang wird auch Travesierung genannt.
	 * Es gibt u.a. folgende Travesierungsarten:
	 * 
	 * 1) pre-order :: W-l-r
	 * 2) post-order :: l-r-W
	 * 3) in-order ::  l-W-r 
	 * 
	 * @param currentNode
	 */
	private void print(BTreeNode currentNode) {
		/*
		 * Hier eine in-order Implementation (l-W-r). Diese Travesierungsart hat
		 * den Vorteil, dass die in den Knoten gespeicherten Werte in einer sortierten
		 * Reihenfolge durchlaufen werden, denn für jeden Teilbaum gilt:
		 * (1) linker Knoten (Kindknoten) kapselt einen kleineren Wert, als der Elternknoten
		 * (2) Wurzel (Elternknoten) kapselt einen größeren Wert, als der linke Kindknoten
		 * (3) rechter Knoten (Kindknoten) kapselt einen größeren Wert, als der Elternknoten
		 */
		
		// l
		if (currentNode.left != null) // Abbruchbedingung, falls linker Knoten ein Blatt ist
			print(currentNode.left);

		// W
		System.out.print(currentNode.value + " ");

		// r
		if (currentNode.right != null) // Abbruchbedingung, falls rechter Knoten ein Blatt ist
			print(currentNode.right);
	}
	
	/**
	 * Gibt <code>true</code> zurück, wenn der gesuchte Wert im Baum vorhanden ist,
	 * andernfalls <code>false</code>.
	 * 
	 * @param value
	 * @return
	 */
	public boolean contians(int value) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Erzeugt aus dem Binärbaum eine sortierte Liste.
	 * 
	 * @return List
	 */
	public List<Integer> asSortedList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Erzeugt eine sortierte Liste, deren Elemente alle kleiner als 'value' sind.
	 * @param value
	 * @return List
	 */
	public List<Integer> elementsSmallerThan(int value) {
		// TODO Auto-generated method stub
		return null;
	}


}

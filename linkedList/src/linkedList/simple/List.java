package linkedList.simple;

import java.util.Iterator;

public class List implements Iterable<Node> {

	Node first;
	Node last;
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

	// insert
	public void insert(Integer value) {
		if (first == null)
			first = last = new Node(value);
		else {
			last.next = new Node(value);
			last = last.next;
		}
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

		boolean remove = false;

		if (!contains(value)) {
			return false;
		} else {

			Node current = first;
			Node prev = null;

			if (first.value == value) {
				first = first.next;
			} else {
				while (current != null && current.value != value) {
					prev = current;
					current = current.next;
				}
				prev.next = current.next;
			}
			size--;
			remove = true;
		}

		return remove;
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

package linkedList.simple;

public class List {

	Node first;
	Node current;
	int size = 0;

	// addNode
	public void addNode(int value) {
		if (first == null)
			first = current = new Node(value);
		else {
			current.next = new Node(value);
			current = current.next;
		}
		size++;
	}
	
	public Integer first() {
		return first == null ? null : first.value;
	}

	public Integer last() {
		return current == null ? null : current.value;
	}

	// size
	public int size() {
		return size;
	}

	// remove
	public boolean remove(int value) {
		
		boolean remove = false;
		
		if(!contains(value)) {
			return false;
		} else {
			
			Node current = first;
			Node prev = null;
			
			if(first.value == value) {
				first = first.next;
			} else {
				while(current != null && current.value != value) {
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

}

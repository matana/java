package stack;

import java.util.Iterator;

import exception.EmptyStackException;

public class Stack implements Iterable<Node> {

	private Node top;
	private int size;

	public void push(int value) {
		Node newNode = new Node(top, value);
		top = newNode;
		size++;
	}

	public Integer pop() throws EmptyStackException {

		Node toReturn = top;

		if (top == null)
			throw new EmptyStackException("Stack ist leer.");

		top = top.prev;

		size--;

		return toReturn.value;

	}

	public void print() {
		Node current = top;
		while (current != null) {
			System.out.println(current.value + " ");
			current = current.prev;
		}
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<Node> iterator() {
		Iterator<Node> iterator = new Iterator<Node>() {

			Node current = top;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Node next() {
				Node tmp = current;
				current = current.prev;
				return tmp;
			}
		};
		return iterator;
	}

}

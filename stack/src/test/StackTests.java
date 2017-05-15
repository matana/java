package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exception.EmptyStackException;
import stack.Stack;

public class StackTests {

	private Stack stack;

	@Before
	public void setup() {

		stack = new Stack();
		stack.push(3);
		stack.push(33);
		stack.push(-3);

	}

	@Test
	public void push() throws EmptyStackException {

		Assert.assertEquals(Integer.valueOf(-3), stack.pop());

	}

	@Test(expected = EmptyStackException.class)
	public void pop() throws EmptyStackException {

		Integer value = stack.pop();

		Assert.assertEquals(Integer.valueOf(-3), value);
		Assert.assertEquals(2, stack.size());

		value = stack.pop();
		value = stack.pop();
		value = stack.pop();

	}

}

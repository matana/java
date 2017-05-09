package linkedList;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import linkedList.simple.List;
import linkedList.simple.Node;

public class LinkedListTests {
	
	private List list;

	@Before
	public void init() {
		list = new List();
		list.insert(1);
		list.insert(-13);
		list.insert(99);
		list.insert(5);
		list.insert(27);
	}
	
	@Test
	public void add() {
		Assert.assertEquals(5, list.size());
		Assert.assertEquals(new Integer(27), list.last());
	}
	
	@Test
	public void contains() {
		Assert.assertTrue(list.contains(-13));
		Assert.assertFalse(list.contains(-14));
	}
	
	@Test
	public void remove() {
		Assert.assertTrue(list.contains(-13));
		Assert.assertEquals(5, list.size());
		list.remove(-13);
		Assert.assertFalse(list.contains(-13));
		Assert.assertEquals(4, list.size());
		Assert.assertEquals(new Integer(1), list.first());
		list.remove(1);
		Assert.assertFalse(list.contains(1));
		Assert.assertEquals(3, list.size());
		Assert.assertEquals(new Integer(99), list.first());
	}
	
	@Test
	public void removeAll() {
		Assert.assertEquals(5, list.size());
		Assert.assertNotNull(list.first());
		list.removeAll();
		Assert.assertNull(list.first());
		Assert.assertEquals(0, list.size());
	}
	
	@Test
	public void iterate() {
		int count = 0;
		int size = list.size();
		Iterator<Node> iterator = list.iterator();
		while(iterator.hasNext())  count++;
		Assert.assertEquals(size, count);
	}
	
	

}

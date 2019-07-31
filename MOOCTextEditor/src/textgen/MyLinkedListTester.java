/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			list1.remove(100);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		shortList.add("C");
		assertEquals("AddEnd: check element at the end of the list is correct.", "C", shortList.get(2));
		emptyList.add(0);
		assertEquals("AddEnd: check element at the end of the list is correct.", (Integer)0, emptyList.get(0));
		emptyList.remove(0);
		try {
			shortList.add(null);
			fail("Check null input");
		}
		catch(NullPointerException e) {
			
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: check longer list size.", 10, longerList.size());
		longerList.add(10);
		assertEquals("Size: check longer list size.", 11, longerList.size());
		assertEquals("Size: check empty list size.", 0, emptyList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		shortList.add(0, "a");
		assertEquals("AddEnd: check element at the index of the list is correct.", "a", shortList.get(0));
		longerList.add(10, 10);
		assertEquals("AddEnd: check element at the index of the list is correct.", (Integer)10, longerList.get(10));
		emptyList.add(0,0);
		assertEquals("AddEnd: check element at the index of the list is correct.", (Integer)0, emptyList.get(0));
		emptyList.add(0, 1);
		assertEquals("AddEnd: check element at the index of the list is correct.", (Integer)1, emptyList.get(0));
		emptyList.remove(0);
		emptyList.add(1,1);
		assertEquals("AddEnd: check element at the index of the list is correct.", (Integer)1, emptyList.get(1));
		try {
			shortList.add(-1, "d");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		try {
			shortList.add(10, "z");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			shortList.add(3, null);
			fail("Check null input");
		}
		catch(NullPointerException e) {
			
		}
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		shortList.set(0, "a");
		assertEquals("AddEnd: check set method.", "a", shortList.get(0));
		shortList.set(1, "b");
		assertEquals("AddEnd: check set method.", "b", shortList.get(1));
		try {
			shortList.set(10, "c");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}

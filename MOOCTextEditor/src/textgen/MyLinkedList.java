package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Null pointer exception.");
		}
		LLNode<E> aNode = new LLNode<E>(element);
		if(head == null) {
			head = aNode;
			tail = aNode;
		}
		else {
			aNode.prev = tail;
			tail.next = aNode;
			tail = aNode;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index>=size || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index +"is out of bounds.");
		}
		int curr = 0;
		LLNode<E> target = head;
		while(index != curr) {
			target = target.next;
			curr++;
		}
		// TODO: Implement this method.
		return target.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Null pointer exception.");
		}
		if(index >= 0 && index <= size) {
			LLNode<E> aNode = new LLNode<E>(element);
			if(head == null) {
				head = aNode;
				tail = aNode;
			}
			if(index == 0) {
				aNode.next = head;
				head.prev = aNode;
				head = aNode;
			}
			else if(index == size) {
				aNode.prev = tail;
				tail.next = aNode;
				tail = aNode;
			}
			else {
				int curr = 0;
				LLNode<E> target = head;
				while(curr != index) {
					target = target.next;
					curr++;
				}
				LLNode<E> prev = target.prev;
				prev.next = aNode;
				aNode.prev = prev;
				aNode.next = target;
				target.prev = aNode;
			}
			size++;
		}
		else {
			throw new IndexOutOfBoundsException("Index " + index + "is out of bounds.");
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + "is out of bounds.");
		}
		int curr = 0;
		E val;
		LLNode<E> target;
		if(index == 0) {
			target = head;
			val = target.data;
			if(head.next == null) {
				head = null;
				tail = null;
			}
			else {
				head = head.next;
				head.prev = null;
				
			}
		}
		else if(index == size-1) {
			target = tail;
			val = target.data;
			tail = tail.prev;
			tail.next = null;
		}
		else {
			target = head;
			while(curr != index) {
				target = target.next;
				curr++;
			}
			val = target.data;
			target.prev.next = target.next;
			target.next.prev = target.prev;
			
		}
		size--;
		// TODO: Implement this method
		return val;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + "is out of bounds.");
		}
		if(element == null) {
			throw new NullPointerException("Null pointer exception.");
		}
		int curr = 0;
		LLNode<E> target = head;
		while(index != curr) {
			target = target.next;
			curr++;
		}
		E replaced = target.data;
		target.data = element;
		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}

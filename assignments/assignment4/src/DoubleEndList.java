/**
 * @author Sarah Pham
 * @version 10/9/19
 * 
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleEndList <T> implements DoubleEndedList<T>{

	private Node first;
	private Node last;
	private int length;
	
	public DoubleEndList() {
		
		this.first = null;
		this.length = 0;
		
	}
	
	
	private class Node{
		
		private T element;
		private Node next;
		
		public Node(T data) {
			this.element = data;
		}
		
		public Node(T data, Node node) {
			this.element = data;
			this.next = node;
		}
		
	}
	
	private class iterate implements Iterator<T>{

		private Node temp = first;
		
		@Override
		public boolean hasNext() {
			
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	
	@Override
	public int size() {
		
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		
		return (this.length == 0);
	}

	@Override
	public Iterator<T> iterator() {
		
		return new iterate();
	}

	@Override
	public void addFirst(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

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
			
			return temp != null;
		}

		@Override
		public T next() {
			
			if(!hasNext()) {
				
				throw new NoSuchElementException();
			}
			
			T result = this.temp.element;
			this.temp = this.temp.next;
			
			return result;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
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
		
		if(element == null) {
			throw new IllegalArgumentException();
		}
		
		Node temp = new Node(element);
		
		if(size() == 0) {
			
			this.first = temp;
			this.last = temp;
			
		}
		else {
			
			temp.next = this.first;
			this.first = temp;
		}
		
		this.length++;
		
	}

	@Override
	public void addLast(T element) {
		if(element == null) {
			throw new IllegalArgumentException();
		}
		
		Node temp = new Node(element);
		temp.element = element;
		
		if(this.length == 0) {
			this.first = temp;
			this.last = temp;
		}
		else {
			this.last.next = temp;
			this.last = temp;
		}
		
		this.length++;
		
	}

	@Override
	public T removeFirst() {
	
		if(this.length == 0) {
			return null;
		}
		
		T temp = this.first.element;
		this.first = this.first.next;
		this.length --;
		
		return temp;
	}

	@Override
	public T removeLast() {
	
		if(this.length == 0) {
			return null;
		}
		
		else if(this.length == 1) {
			T temp = this.first.element;
			this.first = null;
			this.last = null;
			this.length--;
			
			return temp;	
		}
		else {
			Node temp = this.first;
			
			while(temp.next.next != null) {
				temp = temp.next;
			}
			
			
			T delete = temp.next.element;
			temp.next = null;
			this.last = temp;
			this.length--;
			
			return delete;
			
		}

	}
	
	
	

}

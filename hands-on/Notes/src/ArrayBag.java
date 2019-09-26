import java.util.Iterator;

public class ArrayBag <T> implements Bag<T>{

	// default_capacity = 1, will keep bag 25%
	
	//Iterator method
	private T[] elements;
	private int size;
	
	public ArrayBag() {};
	public ArrayBag(int capacity) {
		
		elements = (T[]) new Object[capacity];
		size = 0;
	}
	
	public boolean add(T element) {
		elements[size] = element;
		size++;
		return true;
		
		// if it's full then ignore
	}
	
	public boolean remove (T element) {
		int i = 0;
		while((i < size) && (!elements[i].equals(element))){	i++;	};
		// This while loop is O(N) where N is number of elements in the bag
		
		// we can also refactor:
		// int i = location(element);
		// if (i < 0) return false;
		
		if(i >= size) return false;
		
		elements[i] = elements[--size];
		elements[size] = null;
		return true;
		
	 /* now there is a gap in the bag, three choices: 
			set to null
			shift to left
			replace with last  <- you should use this one
			
			
	 */
	}
	
	
	@Override
	public boolean contains(T element) {

		for(int i = 0; i < size; i++) {
			if(elements[i].equals(element)) return true;
		}
	
		return false;
	}
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator(elements, size);
	}
	
	
	
	
}

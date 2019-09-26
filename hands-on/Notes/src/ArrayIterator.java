import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T>{
		
		private T[] items;	// array of elements to be iterated over
		private int count;	// number of elements in array
		private int current;	// current position in the iteration
		
		public ArrayIterator(T[] elements, int size) {
			items = elements;		// creates an alias, not a copy
			count = size;
			current = 0; 
		}

		@Override
		public boolean hasNext() { return (current < count); }

		@Override
		public T next() {
		
			if(!hasNext()) throw new NoSuchElementException();
			
			return items[current++];
		}
		
		public void remove() {  // This remove method is optional 
			throw new UnsupportedOperationException();
		}
		
	}



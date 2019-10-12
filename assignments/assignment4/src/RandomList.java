import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomList <T> implements RandomizedList<T>{

	private static final int DEFAULT_LENGTH = 1;
	private T[] element;
	private int length;
	
	private class Iterate implements Iterator<T>{

		private T[] data;
		private int i;
		private int temp;
		
		public Iterate(T[] array, int amount) {
			
			temp = 0;
			data = array;
			i = amount;
		}
		
		
		@Override
		public boolean hasNext() {
			
			return (temp < size());
		}

		@Override
		public T next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			return data[temp++];
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
	
		Iterate iterate = new Iterate(element, size());
		return null;
	}

	@Override
	public void add(T element) {
		
		if(element == null) {
			throw new IllegalArgumentException();
		}
		
		if(this.length == this.element.length) {
			
		}
		
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T sample() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

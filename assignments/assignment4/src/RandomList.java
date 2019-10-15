import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomList <T> implements RandomizedList<T>{

	private static final int DEFAULT_LENGTH = 1;
	private T[] element;
	private int length;
	
	public RandomList() {
		
		this.length = 0;
		element = (T[]) new Object[DEFAULT_LENGTH];
	}
	
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
	
	public void resize(int size) {
		
		T[] temp = (T[]) new Object[size];
		
		for(int i = 0; i < size(); i++){
			temp[i] = element[i];
		}
		
		this.element = temp;
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
			resize(this.element.length * 2);
		}
		
	}

	@Override
	public T remove() {
		
		throw new UnsupportedOperationException();
	}

	@Override
	public T sample() {
		
		if(this.length == 0) {
			return null;
		}
		
		int random = new Random().nextInt(size());
		
		return this.element[random];
	}
	

}

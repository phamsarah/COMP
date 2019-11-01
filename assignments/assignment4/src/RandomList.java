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
		private int dataSize;
		private int temp;
		
		public Iterate(T[] array, int amount) {
			
			data = array;
			dataSize = amount;
			temp = 0;
			
			}

		@Override
		public boolean hasNext() {
			return (dataSize > 0);
		}

		@Override
		public T next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			Random rand = new Random();
			temp = rand.nextInt(dataSize);
			T next = data[temp];
			
			if(temp != (dataSize - 1)) {
				
				data[temp] = data[dataSize - 1];
				data[dataSize - 1] = next;
				
			}
			
			dataSize--;
			
			return next;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
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
	
		Iterate iterate = new Iterate(this.element, size());
		
		return iterate;
	}

	@Override
	public void add(T element) {
		
		if(element == null) {
			throw new IllegalArgumentException();
		}
		
		this.element[size()] = element;
	    this.length++;
		
		if(this.length == this.element.length) {
			resize(this.element.length * 2);
		}
		
		
	}

	@Override
	public T remove() {
		
		if(size() == 0) {
			return null;
		}
		
		int temp = new Random().nextInt(size());
		
		T remove = this.element[temp];
		this.element[temp] = element[size() - 1];
		this.element[size() - 1] = null;
		this.length--;
		
		if(size() > 0 && size() < this.element.length / 4) {
			resize(this.element.length / 2);
		}
		
		return remove;
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

import java.util.Iterator;

public class dynamic_array_resizing <T> implements Bag<T>{

	private int[] element;
	private int size;
	
	@Override
	public boolean add(T element) {
		// TODO Auto-generated method stub
		if(isFull()) {
			
			resize(elements.length * 2);
		}
		
		// TIME COMPLEXITY: O(N)  OR  O(1) amortized 
		
		elements[size] = element;
		
		return false;
	}
	
	private void resize(int cpaacity)
	{
		T[a] = (T[]) new Object[capacity];
		
		System.arraycopy(elements, 0, a, 0, elements.length);
		
		elements = a;
		
		// or
		
		T[] a = Arrays.<T>copyOf(elements, capacity);
		
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		
		int i  = locate(element);
		if(i < 0)
			return false
		
		return false;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectorTest {

	@Test
	public void test() {
		int[] a = {-3, 3, 9, 7, 0};
		//Selector.max(a);
		//int[] array = Selector.range(a, 3, 7);
		/*for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}*/
		
		int result = Selector.ceiling(a, 9);
		System.out.println(result);
	}

}

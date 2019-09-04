import static org.junit.Assert.*;

import org.junit.Test;

public class SelectorTest {

	@Test
	public void test() {
		int[] a = {2, 8, 8, 7, 3, 3, 4};
		
		int result = Selector.kmin(a, 3);
		System.out.println("minimum: " + result);
	}

}

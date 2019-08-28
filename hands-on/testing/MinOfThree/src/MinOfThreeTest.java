import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinOfThreeTest {

   /** Test case for the search method. */
   @Test
   public void testSearch1() {
      int actual = MinOfThree.min1(1, 2, 3);
      int expected = 1;
      assertEquals(expected, actual);
   }
   
   @Test
   public void testSearch2() {
      int actual = MinOfThree.min2(1, 2, 3);
      int expected = 1;
      assertEquals(expected, actual);
   }
   
   @Test
   public void testSearch3() {
      int actual = MinOfThree.min2(10, 1, 1);
      int expected = 1;
      assertEquals(expected, actual);
   }
   
   @Test
   public void testSearch4() {
      int actual = MinOfThree.min2(1, 202, -1);
      int expected = -1;
      assertEquals(expected, actual);
   }
   
   @Test
   public void testSearch5() {
      int actual = MinOfThree.min1(1, 1, 5);
      int expected = 1;
      assertEquals(expected, actual);
   }
   
   @Test
   public void testSearch6() {
      int actual = MinOfThree.min1(5, 5, 0);
      int expected = 0;
      assertEquals(expected, actual);
   }
   

}


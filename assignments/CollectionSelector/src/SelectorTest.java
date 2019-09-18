import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.Test;

public class SelectorTest {

	static Comparator<Integer> ascendingInt = new Comparator<Integer>() {
	      @Override
	      public int compare(Integer a, Integer b) {
	         if (a < b) {
	            return -1;
	         }
	         else if (a == b) {
	            return 0;
	         }
	         else {
	            return 1;
	         }
	      }
	   };
	   static Comparator<Character> ascendingChar = new Comparator<Character>() {
	      @Override
	      public int compare(Character a, Character b) {
	         if (a < b) {
	            return -1;
	         }
	         else if (a == b) {
	            return 0;
	         }
	         else {
	            return 1;
	         }
	      }
	   };
	   static Comparator<String> ascendingString = new Comparator<String>() {
	      @Override
	      public int compare(String a, String b) {
	         return a.compareTo(b);
	      }
	   };
	   public static void main(String[] args) {
	      ArrayList<Integer> arr = new ArrayList<Integer>();
	      arr.add(1);
	      arr.add(8);
	      arr.add(1);
	      arr.add(2);
	      arr.add(3);
	      System.out.println(Selector.kmax(arr, 9, ascendingInt));
	   }
	}



//import java.io.File;
//import java.util.HashMap;
//import java.io.IOException;
//import java.util.Random;
//import java.util.Scanner;
//import java.util.Set;
//
///**
// * MarkovModel.java Creates an order K Markov model of the supplied source
// * text. The value of K determines the size of the "kgrams" used to generate
// * the model. A kgram is a sequence of k consecutive characters in the source
// * text.
// *
// * @author     Sarah Pham (slp0042@auburn.edu)
// * @author     Dean Hendrix (dh@auburn.edu)
// * @version    2018-04-17
// *
// */
//public class MarkovModel {
//
//   // Map of <kgram, chars following> pairs that stores the Markov model.
//   private HashMap<String, String> model;
//
//   // add other fields as you need them ...
//
//   private String sourceText = "";
//   private int K;
//   private int length;
//
//   /**
//    * Reads the contents of the file sourceText into a string, then calls
//    * buildModel to construct the order K model.
//    *
//    * DO NOT CHANGE THIS CONSTRUCTOR.
//    *
//    */
//   public MarkovModel(int K, File sourceText) {
//      model = new HashMap<>();
//      try {
//         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
//         buildModel(K, text);
//      }
//      catch (IOException e) {
//         System.out.println("Error loading source text: " + e);
//      }
//   }
//
//
//   /**
//    * Calls buildModel to construct the order K model of the string sourceText.
//    *
//    * DO NOT CHANGE THIS CONSTRUCTOR.
//    *
//    */
//   public MarkovModel(int K, String sourceText) {
//      model = new HashMap<>();
//      buildModel(K, sourceText);
//   }
//
//
//   /**
//    * Builds an order K Markov model of the string sourceText.
//    */
//   private void buildModel(int K, String sourceText) {
//	   this.sourceText = sourceText;
//	   this.K = K;
//	   this.length = sourceText.length();
//
//	   
//	   for(int i = 0; i < length-K; i++){
//		   String key = sourceText.substring(i, i + K);
//		   
//		   String value = model.getOrDefault(key, "").concat(sourceText.substring(i+K, i+K+1));
//		   
//		   model.put(key, value);
//	   }
//   }
//
//
//   /** Returns the first kgram found in the source text. */
//   public String getFirstKgram() {
//	   return sourceText.substring(0, K);
//   }
//
//
//   /** Returns a kgram chosen at random from the source text. */
//   public String getRandomKgram() {
//      
//	  Random rnd = new Random();
//      int index = rnd.nextInt(this.length - K + 1);
//      
//	  return sourceText.substring(index, index + this.K);
//   }
//
//
//   /**
//    * Returns the set of kgrams in the source text.
//    *
//    * DO NOT CHANGE THIS METHOD.
//    *
//    */
//    public Set<String> getAllKgrams() {
//      return model.keySet();
//   }
//
//
//   /**
//    * Returns a single character that follows the given kgram in the source
//    * text. This method selects the character according to the probability
//    * distribution of all characters that follow the given kgram in the source
//    * text.
//    */
//   public char getNextChar(String kgram) {
//	   
//	   Random rnd = new Random();
//	   String value = model.get(kgram);
//
//	   while (value == null) {
//		   value = model.get(this.getRandomKgram());
//	   }
//
//	   int valueLen = value.length();
//	   
//	   char character = value.charAt(rnd.nextInt(valueLen));
//	    	
//	   return character;
//	
//   }
//
//
//   /**
//    * Returns a string representation of the model.
//    * This is not part of the provided shell for the assignment.
//    *
//    * DO NOT CHANGE THIS METHOD.
//    *
//    */
//    @Override
//    public String toString() {
//      return model.toString();
//   }
//
//}

import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Sarah Pham (slp0042@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2018-04-17
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;

   // add other fields as you need them ...

   private String sourceText = "";
   private int K;
   private int length;

   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
	   this.sourceText = sourceText;
	   this.K = K;
	   this.length = sourceText.length();

	   
	   for(int i = 0; i < length-K; i++){
		   String key = sourceText.substring(i, i + K);
		   
		   String value = model.getOrDefault(key, "").concat(sourceText.substring(i+K, i+K+1));
		   
		   model.put(key, value);
	   }
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
	   return sourceText.substring(0, K);
   }


   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      
	  Random rnd = new Random();
      int index = rnd.nextInt(this.length - K + 1);
      
	  return sourceText.substring(index, index + this.K);
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
	   
	   Random rnd = new Random();
	   String value = model.get(kgram);
       
       while(value == null){
           value = model.get(this.getRandomKgram());   
       }
	   
	   int valueLen = value.length();
	   
	   return value.charAt(rnd.nextInt(valueLen));
	
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    @Override
    public String toString() {
      return model.toString();
   }

}

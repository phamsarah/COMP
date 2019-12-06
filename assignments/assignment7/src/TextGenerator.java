//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
///**
// * TextGenerator.java. Creates an order K Markov model of the supplied source
// * text, and then outputs M characters generated according to the model.
// *
// * @author     Sarah Pham (slp0042@auburn.edu)
// * @author     Dean Hendrix (dh@auburn.edu)
// * @version    2018-04-17
// *
// */
//public class TextGenerator {
//
//   /** Drives execution. */
//   public static void main(String[] args) {
//	   
//	  /*
//      if (args.length < 3) {
//         System.out.println("Usage: java TextGenerator k length input");
//         return;
//      }
//
//      // No error checking! You may want some, but it's not necessary.
//      int K = Integer.parseInt(args[0]);
//      int M = Integer.parseInt(args[1]);
//      if ((K < 0) || (M < 0)) {
//         System.out.println("Error: Both K and M must be non-negative.");
//         return;
//      }
//
//      File text;
//      try {
//         text = new File(args[2]);
//         if (!text.canRead()) {
//            throw new Exception();
//         }
//         if(text.length() <= K) {
//        	 System.out.println("error: source not enough characters");
//        	throw new Exception();
//         }
//      }
//      catch (Exception e) {
//         System.out.println("Error: Could not open " + args[2] + ".");
//         return;
//      }
//      */
//      File input = new File("/home/sarah/Downloads/input_files/input_files/LM_input4.txt");
//	   
//	  //String input = "ABCDE\n";
//      // instantiate a MarkovModel with the supplied parameters and
//      // generate sample output text ...	
//	  int K = 1;
//	  int M = 1000;
//      MarkovModel model = new MarkovModel(K, input);
//      String kgram = model.getRandomKgram();
//      String sampleText = kgram;
//      
//      //for(int i = 0; i < M; i++) {
//      while(sampleText.length() < M) {
//    	  char nextChar = model.getNextChar(kgram);
//    	  sampleText = sampleText + nextChar;
//    	  
//    	  while (nextChar == 0) {
//    		  kgram = model.getRandomKgram();
//    		  sampleText = sampleText + kgram;
//    		  nextChar = model.getNextChar(kgram);
//    	  }
//    	  
//    	  kgram = sampleText.substring(sampleText.length() - K, sampleText.length());
//      }
//      
//
//	  System.out.println("Sample text: " + sampleText);
//
//   }
//}

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * TextGenerator.java. Creates an order K Markov model of the supplied source
 * text, and then outputs M characters generated according to the model.
 *
 * @author     Sarah Pham (slp0042@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2018-04-17
 *
 */
public class TextGenerator {

   /** Drives execution. */
   public static void main(String[] args) {
	   

      if (args.length < 3) {
         System.out.println("Usage: java TextGenerator k length input");
         return;
      }

      // No error checking! You may want some, but it's not necessary.
      int K = Integer.parseInt(args[0]);
      int M = Integer.parseInt(args[1]);
      if ((K < 0) || (M < 0)) {
         System.out.println("Error: Both K and M must be non-negative.");
         return;
      }

      File text;
      try {
         text = new File(args[2]);
         if (!text.canRead()) {
            throw new Exception();
         }
         if(text.length() <= K) {
        	 System.out.println("error: source not enough characters");
        	throw new Exception();
         }
      }
      catch (Exception e) {
         System.out.println("Error: Could not open " + args[2] + ".");
         return;
      }


      // instantiate a MarkovModel with the supplied parameters and
      // generate sample output text ...

      MarkovModel model = new MarkovModel(K, text);
      String kgram = model.getRandomKgram();
      String sampleText = kgram;
      
       /**
      for(int i = 0; i < M; i++) {
    	  sampleText = sampleText + model.getNextChar(kgram);
    	  kgram = sampleText.substring(sampleText.length() - K, sampleText.length());
      }
      **/
       
       while(sampleText.length()
 < M){
        char nextChar = model.getNextChar(kgram);
           
           while(nextChar == 0){
             kgram = model.getRandomKgram();
               sampleText = sampleText + kgram;
               nextChar = model.getNextChar(kgram);
           
           }
           
           sampleText = sampleText + nextChar;
           kgram = sampleText.substring(sampleText.length() - K, sampleText.length());
       }
      System.out.println(sampleText);

   }
}

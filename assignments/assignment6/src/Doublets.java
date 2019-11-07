import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;



/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Sarah Pham (slp0042@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-11-5
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////
	
	List<String> empty = new ArrayList();
	TreeSet <String> lexicon;
	int count;

    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {
        	
        	lexicon = new TreeSet<String>();
        	
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                lexicon.add(str.toLowerCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }

    //////////////////////////////////////////////////////////////
    // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
    //////////////////////////////////////////////////////////////

    
    
    
    @Override
	public int getHammingDistance(String str1, String str2) {
		
    	int temp = 0;
    	
    	if(str1.length() != str2.length()){
    		return -1;
    	}
    	
    	char[] firstString = str1.toCharArray();
    	char[] secondString = str2.toCharArray();
    	
    	for(int i = 0; i < str1.length(); i++) {
    		if(firstString[i] != secondString[i]) {
    			temp++;
    		}
    	}
    	
		return temp;
	}

    
    
	@Override
	public List<String> getMinLadder(String start, String end) {
		
		start = start.toLowerCase();
		end = end.toLowerCase();
		
		ArrayList<String> reverse = new ArrayList<String>();
		List<String> minimum = new ArrayList<String>();
		
		if(start.equals(end)) {
			minimum.add(start);
			return minimum;
		}
		
		if(getHammingDistance(start,end) == -1) {
			return empty;
		}
		
		if(isWord(start) && isWord(end)) {
			reverse = search(start, end);
		}
		
		
		for(int i = reverse.size() - 1; i >= 0; i--) {
			minimum.add(reverse.get(i));
		}
		
		
		return minimum;
	}

	
	@Override
	public List<String> getNeighbors(String word) {
	
		List<String> neighbors = new ArrayList<String>();
		Iterator <String> iterate = lexicon.iterator();
		
		while(iterate.hasNext()) {
			String temp = iterate.next();
			
			if(getHammingDistance(word,temp) == 1) {
				neighbors.add(temp);
			}
		}
		
		return neighbors;
		
	}

	
	
	@Override
	public int getWordCount() {
	
		return lexicon.size();
	}

	
	
	@Override
	public boolean isWord(String str) {
		
		if(lexicon.contains(str)) {
			return true;
		}
		
		return false;
	}

	
	
	@Override
	public boolean isWordLadder(List<String> sequence) {
		
		if(sequence.isEmpty()) {
			return false;
		}
		
		for(int i = 0; i < sequence.size() - 1; i++) {
			if(getHammingDistance(sequence.get(i), sequence.get(i + 1)) != 1) {
				return false;
			}
		}
		
		for(int j = 0; j < sequence.size(); j++) {
			if(!lexicon.contains(sequence.get(j))) {
				return false;
			}
				
		}
		
		return true;
	}
	
	
	
	private ArrayList<String> search(String start, String end){
		
		Deque<Node> lineQueue = new ArrayDeque<Node>();
		HashSet<String> taken = new HashSet<String>();
		ArrayList<String> reverse = new ArrayList<String>();
		
		taken.add(start);
		lineQueue.addLast(new Node(start,null));
		
		Node lastNode = new Node(end, null);
		
		
		outerloop:
			while(!lineQueue.isEmpty()) {
				
				Node temp = lineQueue.removeFirst();
				String word = temp.data;
				
				List<String> neighbors = getNeighbors(word);
				
				for(String neighbor : neighbors){
					
					if(!taken.contains(neighbors)) {
						taken.add(neighbor);
						lineQueue.addLast(new Node(neighbor, temp));
						
						if(neighbor.equals(end)) {
							lastNode.previous = temp;
							break outerloop;
						}
					}
				}
			}
		
		
		if(lastNode.previous == null) {
			return reverse;
		}
		
		Node temp = lastNode;
		
		while(temp != null) {
			reverse.add(temp.data);
			temp = temp.previous;
		}
		
		return reverse;
	}
	
	
	
	private class Node{
		String data;
		Node previous;
		
		public Node(String data, Node previous) {
			this.data = data;
			this.previous = previous;
		}
	}
	
}


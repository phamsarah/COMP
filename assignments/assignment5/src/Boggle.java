import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.FileReader;
import java.util.Scanner;

public class Boggle implements WordSearchGame {

	private TreeSet <String> lexicon;  
	private String[][] board;  
	private SortedSet<String> validWord;
	private List<Integer> pathway;  // path
	private List<Integer> resultPathway;  // actualPath
	private Boolean[][] taken; // visited
	private int minimumLen; // minLength
	private boolean loadLexicon;  //lexiconLoaded
	private int size;
	
	
	public Boggle(){
		
		validWord = new TreeSet <String>();
		resultPathway = new ArrayList<Integer>();
		pathway = new ArrayList<Integer>();
		lexicon = new TreeSet<String>();
		
	}
	
	
	
	@Override
	public void loadLexicon(String fileName) {
		if(fileName == null) {
			throw new IllegalArgumentException();
		}
		
		
		try {
			
			Scanner file = new Scanner(new FileReader(fileName));
			
			while(file.hasNext()){
				
				String line = file.nextLine();
				
				Scanner lineScn = new Scanner(line);
				lineScn.useDelimiter(" ");
				
				while(lineScn.hasNext()) {	
					lexicon.add(lineScn.next().toLowerCase());
				}
			
			}
			
		}
		catch(Exception e) {
			throw new IllegalArgumentException();
		}
		
		loadLexicon = true;	
	}

	
	
	@Override
	public void setBoard(String[] letterArray) {
		
		if((letterArray == null)){
			throw new IllegalArgumentException();
		}
		
		double perfectSquare = Math.sqrt(letterArray.length);
		
		if(perfectSquare % 1 > 0){
			throw new IllegalArgumentException();
		}
		else {
			size = (int) perfectSquare;
			board = new String[size][size];
			taken = new Boolean[size][size];
			
			int k = 0;
			
			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++) {
					taken[i][j] = false;
					board[i][j] =  letterArray[k].toLowerCase();
					k++;
				}
			}
		}
		
		
	}

	
	
	@Override
	public String getBoard() {
		
		String boardToString = "";
		
		for(String[] string : board) {
			for(String secondString : string) {
				boardToString = boardToString + secondString;
			}
		}
			
		return boardToString;
	}

	
	
	@Override
	public SortedSet<String> getAllValidWords(int minimumWordLength) {
		
		minimumLen = minimumWordLength;
		
		if(minimumLen < 1){
			throw new IllegalArgumentException();
		}
		
		validWord.clear();
		
		checkException();
		
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				findWord(board[i][j], i , j);
			}
		}
		
		return validWord;
	}

	
	
	
	@Override
	public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
		
		checkException();
		
		if(minimumWordLength < 1) {
			throw new IllegalStateException();
		}
		
		int result = 0;
		
		for(String word : words){
			
			int length = word.length();
			result += 1 + (length - minimumWordLength);
		}
		
		
		return result;
	}

	
	@Override
	public boolean isValidWord(String wordToCheck) {
		
		checkException();
		
		if(wordToCheck == null){
			throw new IllegalArgumentException();
		}
		
		return (lexicon.contains((wordToCheck).toLowerCase()));
	}

	
	@Override
	public boolean isValidPrefix(String prefixToCheck) {
		
		checkException();
		
		if(prefixToCheck == null){
			throw new IllegalArgumentException();
		}
		
		return lexicon.ceiling(prefixToCheck).startsWith(prefixToCheck);
	}

	
	@Override
	public List<Integer> isOnBoard(String wordToCheck) {
		
		checkException();
		
		if(wordToCheck == null){
			throw new IllegalArgumentException();
		}
		
		pathway.clear();
		resultPathway.clear();
		
		for(int i = 0; i < (int) size; i++) {
			for(int j = 0; j < size; j++) {
				if(Character.toUpperCase(board[i][j].charAt(0)) == Character.toUpperCase(wordToCheck.charAt(0))) {
					int temp = j + (i * size);
					pathway.add(temp);
					repeat(wordToCheck, board[i][j], i, j);
				
					if(!resultPathway.isEmpty()) {
						return resultPathway;
					}
					
					pathway.clear();
					resultPathway.clear();
				}
			}
		}
		
		return pathway;
	}
	
	
	
	public void findWord(String word, int x, int y){
		if(!isValidPrefix(word)) { return; }
		
		taken[x][y] = true;
		
		if(isValidWord(word) && word.length() >= minimumLen){
			validWord.add(word.toUpperCase());
		}
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if((x + i) <= ((int) size - 1) && (y + j) <= ((int) size - 1) && (x + i) >= 0 && (y + j) >= 0 && !taken[x + i][y + j]) {
					taken[x + i][y + j] = true;
					findWord(word + board[x + i][y + j], x + i, y + j);
					taken[x + i][y + j] = false;
				}
			}
		}
	
		
		taken[x][y] = false;
	
	}
	
	
	
	public void repeat(String wordToCheck, String temp, int x, int y) {
		taken[x][y] = true;
		if(!(isValidPrefix(temp))) { return; }
		
		if(temp.toUpperCase().equals(wordToCheck.toUpperCase())) {
			resultPathway = new ArrayList(pathway);
			return;
		}
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(temp.equals(wordToCheck)){
					return;
				}
				
				if((x + i) <= (size - 1) && (y + j) <= (size - 1) && (x + i) >= 0 && (y + j) >= 0 && !taken[x + i][y + j]) {
					taken[x + i][y + j] = true;
					int value = (x + i) * size + y + j;
					pathway.add(value);
					repeat(wordToCheck, temp + board[x + i][y + j], x + i, y + j);
					taken[x + i][y + j] = false;
					pathway.remove(pathway.size() - 1);
					
				}
				
			}
		}
		
		
		taken[x][y] = false;
		return;
		
	}
	
	
	
	public void checkException(){
		
		if(!loadLexicon){
			throw new IllegalStateException();
		}
	}

}

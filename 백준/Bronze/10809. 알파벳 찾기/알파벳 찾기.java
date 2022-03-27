import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Map<Character, Integer> map = new TreeMap<Character, Integer>();
    	String word = bfr.readLine();
    	
    	for (int i = 97; i < 123; i++) {
    		map.put((char)i, -1);
    	}
    	Loop : for (int i = 0; i < word.length(); i++) {
    		for (int j = 0; j < i; j++) {
    			if (word.charAt(i) == word.charAt(j)) {
    				continue Loop;
    			}
    		}
    		map.put(word.charAt(i), i);
    	}
    	for (int i = 97; i < 123; i++) {
    		bfw.write(map.get((char)i) + " ");
    	}
    	bfw.flush();
    	bfw.close();
    }
}
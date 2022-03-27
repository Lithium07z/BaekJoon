import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	Set<Character> st = new TreeSet<Character>();
    	Map<Character, Integer> mp = new HashMap<Character, Integer>();
    	
    	String word = bfr.readLine();
    	char[] arr = new char[word.length()];
    	
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = word.charAt(i);
    		if (arr[i] > 96 && arr[i] < 123) {
    			char upper = (char)(arr[i] - 32);
    			if (st.add(upper) == false) {
        			mp.put(upper, mp.get(upper) + 1);
        		} else {
        			st.add(upper);
        			mp.put(upper, 1);
        		}
    		} else {
    			if (st.add(arr[i]) == false) {
    				mp.put(arr[i], mp.get(arr[i]) + 1);
    			} else {
    				st.add(arr[i]);
    				mp.put(arr[i], 1);
    			}   			
    		}
    	}
    	int max = 0;
    	char value = 0;;
    	char key;
    	for (char loop : st) {
    		key = loop;
    		if (max < mp.get(key)) {
    			max = mp.get(key);
    			value = key;
    		} else if (max == mp.get(key)) {
    			value = '?';
    		}
    	}
    	bfw.write(value);
    	bfw.flush();
    	bfw.close();
    }
}
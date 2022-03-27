import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String loop = bfr.readLine();
    	int count = 0;
    	
    	Loop: for (int i = 0; i < Integer.parseInt(loop); i++) {
    		Set<Character> st = new LinkedHashSet<Character>();
    		String s = bfr.readLine();
    		char[] arr = new char[s.length()];
    		for (int j = 0; j < s.length(); j++) {
    			arr[j] = s.charAt(j);
    			if (st.add(s.charAt(j)) == false && arr[j] != arr[j-1]) {
    				continue Loop;
    			}
    		}
    		st.clear();
    		count += 1;
    	}
    	bfw.write(String.valueOf(count));
    	bfw.flush();
    	bfw.close();
    }
}
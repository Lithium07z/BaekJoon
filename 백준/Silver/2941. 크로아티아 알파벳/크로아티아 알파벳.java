import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String s = bfr.readLine();
    	char[] arr = new char[s.length()];
    	int count = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = s.charAt(i);
    		if (i - 1 >= 0 && arr[i] == 'j' && (arr[i-1] == 'l' || arr[i-1] == 'n')) {
    			continue;
    		} else if (i - 2 >= 0 && arr[i] == '=' && arr[i-1] == 'z' && arr[i-2] == 'd') {
    			count -= 1;
    		} else if (i - 1 >= 0 && arr[i] == '-' && (arr[i-1] == 'c' || arr[i-1] == 'd')) {
    			continue;
    		} else if (i - 1 >= 0 && arr[i] == '=' && (arr[i-1] == 'c' || arr[i-1] == 's' || arr[i-1] == 'z')) {
    			continue;
    		} else {
    			count += 1;
    		}
    	}
    	bfw.write(String.valueOf(count));
    	bfw.flush();
    	bfw.close();
    }
}
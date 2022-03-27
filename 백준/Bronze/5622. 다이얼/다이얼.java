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
    	int sum = 0;
    	
    	for (int i = 0; i < s.length(); i++) {
    		arr[i] = s.charAt(i); 
    		if (arr[i] > 64 && arr[i] < 68) {
    			sum += 3;
    		} else if (arr[i] > 67 && arr[i] < 71) {
    			sum += 4;
    		} else if (arr[i] > 70 && arr[i] < 74) {
    			sum += 5;
    		} else if (arr[i] > 73 && arr[i] < 77) {
    			sum += 6;
    		} else if (arr[i] > 76 && arr[i] < 80) {
    			sum += 7;
    		} else if (arr[i] > 79 && arr[i] < 84) {
    			sum += 8;
    		} else if (arr[i] > 82 && arr[i] < 87) {
    			sum += 9;
    		} else if (arr[i] > 86 && arr[i] < 91) {
    			sum += 10;
    		}
     	}
    	bfw.write(String.valueOf(sum));
    	bfw.flush();
    	bfw.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String value = bfr.readLine(); 
    	int sum = 99;
    	
    	if (Integer.parseInt(value) < 100) {
    		System.out.println(value);
    	} else {
    		for (int i = 110; i <= Integer.parseInt(value); i++) {
    			if (((String.valueOf(i).charAt(1) - '0') - (String.valueOf(i).charAt(0) - '0')) + (String.valueOf(i).charAt(1) - '0')
    					== (String.valueOf(i).charAt(2) - '0')) {
    				sum += 1;
    			}
    		}
    		bfw.write(String.valueOf(sum));
    		bfw.flush();
    		bfw.close();
    	}
    }
}
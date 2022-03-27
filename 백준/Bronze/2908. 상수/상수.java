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
    	String[] arr = s.split(" ");
    	String[] sum = {"", ""};
    	
    	for (int i = 0; i < 2; i++) {
    		for (int j = 2; j >= 0; j--) {
    			sum[i] += arr[i].charAt(j);
    		}
    	}
    	if (Integer.parseInt(sum[0]) > Integer.parseInt(sum[1])) {
    		bfw.write(String.valueOf(sum[0]));
    	} else {
    		bfw.write(String.valueOf(sum[1]));
    	}
    	bfw.flush();
    	bfw.close();
    }
}
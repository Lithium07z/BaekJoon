import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int total = Integer.parseInt(bfr.readLine());
    	String[] st = new String[total];
    	
    	for (int i = 0; i < total; i++) {
    		st[i] = bfr.readLine();
    	}
    	
    	for (int i = 0; i < total; i++) {
    		int loop = st[i].charAt(0) - '0';
    		int count = 2;
    		for (int j = 0; j < st[i].length() - 2; j++) {
    			for (int k = 0; k < loop; k++) {
    				bfw.write(String.valueOf(st[i].charAt(count)));
    			}
    			count += 1;
    		}
    		bfw.write("\n");
    	}
    	bfw.flush();
    	bfw.close();
    }
}
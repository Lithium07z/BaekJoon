import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int loop = Integer.parseInt(bfr.readLine());
    	String num = bfr.readLine();
    	int sum = 0;
    	
    	for (int i = 0; i < loop; i++) {
    		sum += num.charAt(i) - '0';
    	}
    	bfw.write(String.valueOf(sum));
    	bfw.flush();
    	bfw.close();
    }
}
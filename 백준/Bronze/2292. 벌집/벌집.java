import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int value = Integer.parseInt(bfr.readLine());
    	int max = 7;
    	int min = 2;
    	int count = 2;
    	int loop = 6;
    	
    	while(true) {
    		if (value >= min && value <= max) {
    			bfw.write(String.valueOf(count));
    			bfw.flush();
    			bfw.close();
    			break;
    		} else if (value == 1) {
    			bfw.write("1");
    			bfw.flush();
    			bfw.close();
    			break;
    		} else {
    			min += loop * (count - 1);
    			max += loop * count;
    			count += 1;
    		}
    	}
    }
}
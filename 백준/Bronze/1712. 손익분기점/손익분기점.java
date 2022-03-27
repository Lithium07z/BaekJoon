import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");
    	int[] arr = new int[st.countTokens()];
    	
    	for (int i = 0; i < arr.length; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	long fix = arr[0];
    	long profit = 0;
    	int count = 0;
    	while(true) {
    		if (arr[2] > arr[1] && profit <= fix) {
    			fix += arr[1];
    			profit += arr[2];
    			count += 1;
    		} else if (profit > fix) { 
    			bfw.write(String.valueOf(count));
    			break;
    		} else {
    			bfw.write("-1");
    			break;
    		}
    	}
    	bfw.flush();
    	bfw.close();
    }
}
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
    	String s = bfr.readLine();
    	StringTokenizer st = new StringTokenizer(s, " ");
    	int count = 0;
    	while (st.hasMoreTokens()) {
    		st.nextToken();
    		count += 1;
    	}
    	bfw.write(String.valueOf(count));
    	bfw.flush();
    	bfw.close();
    }
}
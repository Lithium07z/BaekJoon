import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {		
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());                                   
        
		BigInteger bigNum1 = new BigInteger(st.nextToken());
		BigInteger bigNum2 = new BigInteger(st.nextToken());

		System.out.println(bigNum1.add(bigNum2));
	}
}
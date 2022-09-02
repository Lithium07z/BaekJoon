import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger bigNumN = new BigInteger("1");
		BigInteger bigNumM = new BigInteger("1");
		BigInteger bigNumNM = new BigInteger("1");
		
		for (int i = 1; i <= N; i++) {
			bigNumN  = bigNumN.multiply(new BigInteger(String.valueOf(i)));
		}
		
		for (int i = 1; i <= M; i++) {
			bigNumM  = bigNumM.multiply(new BigInteger(String.valueOf(i)));
		}
		
		for (int i = 1; i <= N - M; i++) {
			bigNumNM  = bigNumNM.multiply(new BigInteger(String.valueOf(i)));
		}
		
		BigInteger bigNumResult = bigNumN.divide(bigNumM.multiply(bigNumNM));
		bfw.write(String.valueOf(bigNumResult));
		bfw.flush();
		bfw.close();
	}
}
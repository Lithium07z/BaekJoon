import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int numN = Integer.parseInt(st.nextToken());
		int numK = Integer.parseInt(st.nextToken());
		
		bfw.write(String.valueOf(factorial(numN) / (factorial(numK) * factorial(numN - numK))));
		bfw.flush();
		bfw.close();
	}
	
	public static int factorial(int numN) {
		if (numN == 1 || numN == 0) {
			return 1;
		}
		return numN * factorial(numN - 1);
	}
}
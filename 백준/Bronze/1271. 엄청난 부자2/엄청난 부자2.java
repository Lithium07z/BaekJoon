import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		BigInteger num1 = new BigInteger(st.nextToken());
		BigInteger num2 = new BigInteger(st.nextToken());
		bfw.write(num1.divide(num2).toString() + "\n" + num1.remainder(num2).toString());
		bfw.flush();
		bfw.close();
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String temp = bfr.readLine();
		
		BigInteger a = new BigInteger(bfr.readLine());
		BigInteger b = new BigInteger(bfr.readLine());
		
		System.out.println(a.multiply(b));
	}
}
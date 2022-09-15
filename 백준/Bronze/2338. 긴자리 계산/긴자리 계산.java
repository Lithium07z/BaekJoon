import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		BigInteger bigNum1 = new BigInteger(bfr.readLine());
		BigInteger bigNum2 = new BigInteger(bfr.readLine());
		
		sb.append(bigNum1.add(bigNum2)).append("\n");
		sb.append(bigNum1.subtract(bigNum2)).append("\n");
		sb.append(bigNum1.multiply(bigNum2));
		System.out.println(sb);
	}
}
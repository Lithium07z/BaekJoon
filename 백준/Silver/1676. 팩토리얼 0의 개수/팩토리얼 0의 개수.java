import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger sum = new BigInteger("1");
		BigInteger bigNum = null;
		int count = 0;
		
		int num = Integer.parseInt(bfr.readLine());
		
		for (int i = 0; i < num; i++) {
			bigNum = BigInteger.valueOf(num - i);
			sum = sum.multiply(bigNum);
		}
		
		String temp = sum.toString();
		for (int i = temp.length() - 1; i >= 0; i--) {
			if (temp.charAt(i) != '0') {
				break;
			}
			count++;
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}
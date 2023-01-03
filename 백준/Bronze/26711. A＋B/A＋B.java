import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger v1 = new BigInteger(bfr.readLine());
		BigInteger v2 = new BigInteger(bfr.readLine());
		BigInteger result = v1.add(v2);
		bfw.write(result.toString());
		bfw.flush();
		bfw.close();
	}
}
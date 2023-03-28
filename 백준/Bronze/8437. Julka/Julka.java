import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger N = new BigInteger(br.readLine());
		BigInteger M = new BigInteger(br.readLine());
		BigInteger T = new BigInteger("2");
		bw.write((N.add(M)).divide(T) + "\n" + (N.subtract(M)).divide(T));
		bw.flush();
		bw.close();
	}
}
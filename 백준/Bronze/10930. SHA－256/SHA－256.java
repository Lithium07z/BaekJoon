import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(br.readLine().getBytes());
		bw.write(String.format("%064x", new BigInteger(1, md.digest())));
		bw.flush();
		bw.close();
	}
}
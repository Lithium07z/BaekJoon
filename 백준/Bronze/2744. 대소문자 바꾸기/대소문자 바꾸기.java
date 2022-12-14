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
		StringBuilder sb = new StringBuilder(bfr.readLine());
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) < 95) {
				sb.setCharAt(i, (char) (sb.charAt(i) + 32));
			} else {
				sb.setCharAt(i, (char) (sb.charAt(i) - 32));
			}
		}
		bfw.write(sb.toString());
		bfw.flush();
		bfw.close();
	}
}
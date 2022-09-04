import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = bfr.readLine();
		long temp = 0;
		
		for (int i = 0; i < N.length(); i++) {
			temp = (temp * 10 + (N.charAt(i) - '0')) % 20000303;
		}
		bfw.write(String.valueOf(temp));
		bfw.flush();
		bfw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		
		if (N.contains("10")) {
			N = N.replaceFirst("10", "");
			bw.write(Integer.parseInt(N) + 10 + "\n");
		} else {
			bw.write(N.charAt(0) - '0' + N.charAt(1) - '0' + "\n");
		}
		bw.flush();
		bw.close();
		return;
	}
}
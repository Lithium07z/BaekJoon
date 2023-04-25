import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Long N = Long.parseLong(br.readLine());
		
		long t = (long)Math.sqrt(N);
		
		bw.write((t * t < N)? (t + 1) + "\n" : t + "\n");
		bw.flush();
		bw.close();
	}
}

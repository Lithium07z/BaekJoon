import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(br.readLine());
		long DP[] = new long[10000001];
		
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 3;
		for (int i = 4; i < DP.length; i++) {
			DP[i] = DP[i - 3] + i / 2 + 1;
		}
		for (int i = 0; i < loop; i++) {
			bw.write(DP[Integer.parseInt(br.readLine())]+ "\n");
		}
		bw.flush();
		bw.close();
	}
}
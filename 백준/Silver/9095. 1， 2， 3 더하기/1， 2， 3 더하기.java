import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

		int loop = Integer.parseInt(bfr.readLine());
		int DP[] = new int[11];
		
		DP[0] = 1;
		DP[1] = 2;
		DP[2] = 4;
		for (int i = 3; i < DP.length; i++) {
			DP[i] = DP[i - 1] + DP[i - 2] + DP[i -3];
		}
		for (int i = 0; i < loop; i++) {
			bfw.write(String.valueOf(DP[Integer.parseInt(bfr.readLine()) - 1]) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
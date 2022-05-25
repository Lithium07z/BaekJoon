import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int E1 = 1;
		int S1 = 1;
		int M1 = 1;
		int E2 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());
		int cnt = 1;
		
		while (!(E1 == E2 && S1 == S2 && M1 == M2)) {
			E1 += 1;
			if (E1 == 16) {
				E1 = 1;
			}
			S1 += 1;
			if (S1 == 29) {
				S1 = 1;
			}
			M1 += 1;
			if (M1 == 20) {
				M1 = 1;
			}
			cnt++;
		}
		bfw.write(String.valueOf(cnt));
		bfw.flush();
		bfw.close();
	}
}
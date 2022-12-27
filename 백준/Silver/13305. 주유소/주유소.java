import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(bfr.readLine());
		long dist[] = new long[N - 1];
		long gas[] = new long[N];
		long sum = 0;
		long min;
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < N; i++) {
			gas[i] = Integer.parseInt(st.nextToken());
		}
		
		min = gas[0];
		for (int i = 0; i < N - 1; i++) {
			if (gas[i] < min) {
				min = gas[i];
			}
			sum += min * dist[i];
		}
		
		bfw.write(String.valueOf(sum));
		bfw.flush();
		bfw.close();
	}
}
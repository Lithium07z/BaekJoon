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
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int graph[][] = new int[node + 1][node + 1];
		String result = "Small World!";
		
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j) {
					graph[i][j] = 1000000000;
				}
			}
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = graph[B][A] = 1;
		}
		
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k<= node; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		Loop : for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if ((i != j && graph[i][j] == 1000000000) || graph[i][j] > 6) {
					result = "Big World!";
					break Loop;
				}
			}
		}
		bfw.write(result);
		bfw.flush();
		bfw.close();
	}
}
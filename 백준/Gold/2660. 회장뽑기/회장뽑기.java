import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int graph[][] = new int[N][N];
		int INF = 987654321;
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			if (s + e == -4) {
				break;
			}
			
			graph[s][e] = graph[e][s] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (graph[j][k] > graph[j][i] + graph[i][k]) {
						graph[j][k] = graph[j][i] + graph[i][k];
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < N; j++) {
				max = Math.max(graph[i][j], max);
			}
			if (max < min) {
				min = max;
				cnt = 1;
				sb.setLength(0);
				sb.append(i + 1).append(" ");
			} else if (max == min) {
				cnt++;
				sb.append(i + 1).append(" ");
			}
		}
		
		bw.write(min + " " + cnt + "\n" + sb.toString());
		bw.flush();
		bw.close();
	}
}
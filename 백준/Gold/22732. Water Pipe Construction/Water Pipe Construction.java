import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int g1 = Integer.parseInt(st.nextToken()) - 1;
			int g2 = Integer.parseInt(st.nextToken()) - 1;
			int graph[][] = new int[n][n];
			int min = INF;
			
			if (n == 0 && m == 0 && s == -1 && g1 == -1 && g2 == -1) {
				break;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i != j) {
						graph[i][j] = INF;
					}
				}
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				graph[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (i != j && j != k && i != k) {
							graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
						}
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				if (graph[s][i] != INF && graph[i][g1] != INF && graph[i][g2] != INF) {
					min = Math.min(min, graph[s][i] + graph[i][g1] + graph[i][g2]);
				}
			}
			
			bw.write(min + "\n");
		}

		bw.flush();
		bw.close();
	}
}
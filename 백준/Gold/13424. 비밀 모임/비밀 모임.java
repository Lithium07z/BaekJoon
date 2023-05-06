import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int INF = 987654321;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int graph[][] = new int[N][N];
			int min = Integer.MAX_VALUE;
			int idx = 0;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j != k) {
						graph[j][k] = INF;
					}
				}
			}
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				graph[a][b] = graph[b][a] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						graph[k][l] = Math.min(graph[k][l], graph[k][j] + graph[j][l]);
					}
				}
			}
			
			int K = Integer.parseInt(br.readLine());
			int position[] = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < position.length; j++) {
				position[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int k = 0; k < position.length; k++) {
					sum += graph[position[k]][j];
				}
				if (sum < min) {
					min = sum;
					idx = j;
				} else if (sum == min) {
					idx = Math.min(idx, j);
				}
			}
			bw.write(idx + 1 + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
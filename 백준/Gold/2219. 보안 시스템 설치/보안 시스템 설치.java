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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][N];
		int INF = 987654321;
		int min = Integer.MAX_VALUE;
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph[A][B] = graph[B][A] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += graph[i][j];
			}
			if (sum < min) {
				min = sum;
				idx = i;
			} else if (sum == min) {
				idx = Math.min(idx, i);
			}
		}
		
		bw.write(idx + 1 + "\n");
		bw.flush();
		bw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int graph[][] = new int[N][N];
		int max[] = new int[N];
		int min = Integer.MAX_VALUE;
		int INF = 987654321;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (graph[i][j] == INF) {
//					System.out.print("0 ");
//				} else {
//					System.out.print(graph[i][j] + " ");
//				}
//			}
//			System.out.println();
//		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int city[] = new int[st.countTokens()];
		
		for (int i = 0; i < K; i++) {
			city[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				max[i] = Math.max(max[i], graph[city[j]][i] + graph[i][city[j]]);
			}
			min = Math.min(max[i], min);
		}
		
		for (int i = 0; i < max.length; i++) { 
			if (min == max[i]) {
				bw.write(i + 1 + " ");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int graph[][] = new int[N][N];
			int INF = 987654321;
			int max = Integer.MIN_VALUE;
			boolean flag = true;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j != k) {
						graph[j][k] = INF;
					}
				}
			}
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				graph[A][B] = graph[B][A] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						graph[k][l] = Math.min(graph[k][l], graph[k][j] + graph[j][l]);
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					max = Math.max(max, graph[j][k]);
					if (j != k && graph[j][k] == INF) {
						flag = false;
					}
				}
			}
			
			if (flag) {
				bw.write("Nejvetsi vzdalenost je " + max + ".\n");
			} else {
				bw.write("Bez spojeni neni veleni!\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}

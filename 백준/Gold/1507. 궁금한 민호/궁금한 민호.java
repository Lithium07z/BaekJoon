import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int graph[][] = new int[N][N];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (graph[j][k] != INF && (graph[j][k] > graph[j][i] + graph[i][k])) {
						bw.write("-1");
						bw.flush();
						bw.close();
						return;
					}
					if ((graph[j][k] == graph[j][i] + graph[i][k]) && (j != i) && (i != k)) {
						graph[j][k] = INF;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (graph[i][j] != INF) {
					sum += graph[i][j];
				}
			}
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}
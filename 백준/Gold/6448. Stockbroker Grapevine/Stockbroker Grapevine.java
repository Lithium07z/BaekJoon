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
		while (true) {
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0) {	
				bw.flush();
				bw.close();
				return;
			}
			
			int graph[][] = new int[N][N];
			int INF = 987654321;
			int idx = 0;
			int min = Integer.MAX_VALUE;
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						graph[i][j] = INF;
					}
				}
			}
			
			for (int i = 0; i < N; i++) { 
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int M = Integer.parseInt(st.nextToken().trim());
				for (int j = 0; j < M; j++) {
					graph[i][Integer.parseInt(st.nextToken().trim()) - 1] = Integer.parseInt(st.nextToken().trim()); 
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				int max = Integer.MIN_VALUE;
				boolean temp = true;
				
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == INF) {
						temp = false;
						break;
					}
					max = Math.max(max, graph[i][j]);
				}
				
				if (max < min && temp) {
					idx = i;
					min = max;
					flag = true;
				}
			}	
			
			if (flag) {
				bw.write(idx + 1 + " " + min + "\n");
			} else {
				bw.write("disjoint");
			}
		}
	}
}
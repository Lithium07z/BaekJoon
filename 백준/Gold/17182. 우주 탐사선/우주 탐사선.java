import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int graph[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) { 
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		DFS(K, 0);
		visited[0] = true;
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int idx, int time) {
		boolean flag = true;
		
		for (int i = 0; i < graph[idx].length; i++) {
			if (!visited[i]) { 
				flag = false;
				visited[i] = true;
				DFS(i, time + graph[idx][i]);
				visited[i] = false;
			}
		}

		if (flag) { 
			min = Math.min(min, time);
		}
	}
}
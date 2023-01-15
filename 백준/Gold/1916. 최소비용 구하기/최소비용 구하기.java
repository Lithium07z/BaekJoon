import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1000000000;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		int graph[][] = new int[node + 1][node + 1];
		int dist[] = new int[node + 1];
		boolean visited[] = new boolean[node + 1];
		
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				graph[i][j] = -1;
			}
		}
		
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (graph[A][B] == -1) {
				graph[A][B] = C;
			} else if (graph[A][B] > C) {
				graph[A][B] = C;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Arrays.fill(dist, INF);

		dist[start] = 0;
		for (int i = 1; i <= node; i++) {
			int minVertex = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= node; j++) {
				if ((!visited[j]) && (dist[j] < min)) {
					min = dist[j];
					minVertex = j;
				}
			}
			
			visited[minVertex] = true;
			for (int j = 1; j <= node; j++) {
				if (!visited[j] && graph[minVertex][j] != -1 && dist[minVertex] + graph[minVertex][j] < dist[j]) {
					dist[j] = dist[minVertex] + graph[minVertex][j];
				}
			}
		}
		
		bw.write(String.valueOf(dist[end]));
		bw.flush();
		bw.close();
	}
}
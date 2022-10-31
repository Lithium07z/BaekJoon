import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	static int graph[][];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int count = 0;
		graph = new int[node + 1][node + 1];		
		visited = new boolean[node + 1];
		
		for (int i = 1; i <= edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[v][u] = graph[u][v] = 1;
		}
		
		for (int i = 1; i <= node; i++) {
			if (visited[i] != true) {
				DFS(i);
				count++;
			}
		}
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
	
	public static void DFS(int s) {
		visited[s] = true;
		for (int i = 1; i < graph.length; i++) {
			if (graph[s][i] == 1 && visited[i] == false) {
				DFS(i);
			}
		}
	}
}
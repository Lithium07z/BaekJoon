import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int graph[][];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		graph = new int[node + 1][node + 1];
		visited = new boolean[node + 1];

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = 0; j < edge; j++) {
				graph[a][b] = 1;
				graph[b][a] = graph[a][b];
			}
		}
		
		DFS(start);
		visitedClear();
		System.out.println();
		BFS(start);
	}

	public static void visitedClear() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}
	
	public static void DFS(int s) {
		visited[s] = true;
		System.out.print(s + " ");
		for (int i = 0; i < graph.length; i++) {
			if (graph[s][i] == 1 && visited[i] == false) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		int n = graph.length - 1;
		
		q.add(s);
		visited[s] = true;
		
		while (!q.isEmpty()) {
			s = q.poll();
			System.out.print(s + " ");
			for (int i = 0; i < graph.length; i++) {
				if (graph[s][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
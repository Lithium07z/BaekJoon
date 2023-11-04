import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int parent[];
	static int graph[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Edge> list = new ArrayList<Edge>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int idx = 1;
		int c = 0;
		int e = 0;
		parent = new int[7];
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 1; i < 7; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) { 
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { 
				if (graph[i][j] != 0 && !visited[i][j]) {
					BFS(i, j, idx++);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) { 
				if (graph[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
								
						if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || graph[nextX][nextY] != 0) {
							continue;
						}

						while (true) {
							if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || graph[nextX][nextY] == graph[i][j]) {
								break;
							}
							
							if (graph[nextX][nextY] != 0) {
								if (Math.abs(nextX - i) + Math.abs(nextY - j) - 1 > 1) {
									list.add(new Edge(graph[i][j], graph[nextX][nextY], Math.abs(nextX - i) + Math.abs(nextY - j) - 1));
								}
								break;
							}
							
							nextX += dx[k];
							nextY += dy[k];
						}
					}
				}
			}
		}
		
		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c - o2.c;
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			
			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				c += edge.c;
				e++;
			}
		}
		
		bw.write(e != idx - 2 ? "-1" : c + "\n");
		bw.flush();
		bw.close();
	}

	public static void BFS(int x, int y, int idx) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] { x, y });
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int crt[] = q.poll();
			int nowX = crt[0];
			int nowY = crt[1];
			graph[nowX][nowY] = idx;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
						
				if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length || visited[nextX][nextY] || graph[nextX][nextY] == 0) {
					continue;
				}
				
				visited[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY });
			}
		}
	}
	
	public static int root(int i) {
		while (i != parent[i]) {
			parent[i] = parent[parent[i]];
			i = parent[i];
		}
		return i;
	}

	public static boolean find(int p, int q) {
		return root(p) == root(q);
	}

	public static void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i > j) {
			parent[i] = j;
		} else {
			parent[j] = i;
		}
	}
}

class Edge {
	int s, e, c;

	public Edge(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
}
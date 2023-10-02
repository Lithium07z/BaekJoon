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

class Main {
	public static int cost[][];
	public static int parent[];
	public static ArrayList<Edge> list;
	public static ArrayList<Edge> path[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int c = 0;
		cost = new int[N + 1][N + 1];
		parent = new int[N + 1];
		path = new ArrayList[N + 1];
		list = new ArrayList<Edge>();

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
			path[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(A, B, C));
		}
		
		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c - o2.c;
			}
		});

		for (int j = 0; j < list.size(); j++) {
			Edge edge = list.get(j);

			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				c += edge.c;
				
				path[edge.s].add(new Edge(edge.e, edge.s, edge.c));
				path[edge.e].add(new Edge(edge.s, edge.e, edge.c));
			}
		}

		int Q = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			BFS(i, N);
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(c - cost[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
		}

		bw.flush();
		bw.close();
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
	
	public static void BFS(int s, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[n + 1];
		
		q.add(s);
		visited[s] = true;
		
		while (!q.isEmpty()) {
			int crt = q.poll();
			
			for (Edge edge : path[crt]) {
				if (!visited[edge.s]) {
					q.add(edge.s);
					visited[edge.s] = true;
					cost[s][edge.s] = Math.max(Math.max(cost[s][edge.s], edge.c), cost[s][crt]);
				}
			}
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static int max;
	public static int start;
	public static int parent[];
	public static boolean visited[];
	public static ArrayList<Edge> list;
	public static ArrayList<Edge> path[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int c = 0;
		parent = new int[N];
		path = new ArrayList[N];
		list = new ArrayList<Edge>();

		for (int i = 0; i < N; i++) {
			parent[i] = i;
			path[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.c, o2.c);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				c += edge.c;
			    path[edge.s].add(new Edge(edge.e, edge.s, edge.c));
                path[edge.e].add(new Edge(edge.s, edge.e, edge.c));
			}
		}
		
		max = Integer.MIN_VALUE;
        visited = new boolean[N];
        DFS(0, 0);
        
        max = Integer.MIN_VALUE;
        visited = new boolean[N];
        DFS(start, 0);

		bw.write(c + "\n" + max);
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

	public static void DFS(int idx, int dist) {
		visited[idx] = true;

		if (max < dist) {
			max = dist;
			start = idx;
		}

		for (Edge edge : path[idx]) {
			if (!visited[edge.s]) {
				DFS(edge.s, dist + edge.c);
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
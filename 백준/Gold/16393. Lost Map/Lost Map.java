import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static int parent[];
	public static ArrayList<Edge> list;
	public static ArrayList<Integer> path[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		parent = new int[N];
		path = new ArrayList[N];
		list = new ArrayList<Edge>();

		for (int i = 0; i < N; i++) {
			parent[i] = i;
			path[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			// for (int j = i + 1; j < N; j++)
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				
				if (j < i + 1) {
					continue;
				} else {
					list.add(new Edge(i, j, v));
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
				bw.write((edge.s + 1) + " " + (edge.e + 1) + "\n");
			}
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
}

class Edge {
	int s, e, c;

	public Edge(int s, int e, int c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
}
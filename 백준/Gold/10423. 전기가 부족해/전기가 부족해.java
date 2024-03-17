import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static int parent[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Edge> list = new ArrayList<Edge>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		int t = 0;

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			parent[Integer.parseInt(st.nextToken())] = -1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c - o2.c;
			}
		});

		for (int i = 0; i < M; i++) {
			Edge edge = list.get(i);

			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);
				t += edge.c;
			}
		}

		bw.write(t + "\n");
		bw.flush();
		bw.close();
	}

	public static int find(int i) {
		if (parent[i] == -1) { 
			return -1;
		}

		if (i == parent[i]) {
			return i;
		} else {
			return find(parent[i]);
		}
	}

	public static void union(int p, int q) {
		int i = find(p);
		int j = find(q);

		if (i != j) {
			if (i == -1) {
				parent[j] = i;
			} else if (j == -1) {
				parent[i] = j;
			} else {
				if (i > j) { 
					parent[i] = j;
				} else {
					parent[j] = i;
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
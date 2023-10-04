import java.awt.Point;
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
		int X = Integer.MIN_VALUE;
		Point arr[] = new Point[N];
		parent = new int[25001];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				list.add(new Edge(i, j, Math.pow(arr[i].x - arr[j].x, 2) + Math.pow(arr[i].y - arr[j].y, 2)));
			}
		}

		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.c, o2.c);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);

			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				X = (int) Math.max(X, edge.c);
			}
		}

		bw.write(X + "\n");
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
	int s, e;
	double c;

	public Edge(int s, int e, double c) {
		this.s = s;
		this.e = e;
		this.c = c;
	}
}
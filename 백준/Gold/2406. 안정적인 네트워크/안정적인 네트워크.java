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
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Edge> list = new ArrayList<Edge>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = 0;
		int K = 0;
		int T = N - 2;
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		} 

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (!find(x, y)) {
				union(x, y);
				T--;
			}
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int v = Integer.parseInt(st.nextToken());
				
				if (j > i) {
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
		
		for (int i = 0; i < list.size() && T != 0; i++) {
			Edge edge = list.get(i);

			if (!find(edge.s, edge.e) && (edge.s != 1 && edge.e != 1)) {
				union(edge.e, edge.s);
				points.add(new Point(edge.e, edge.s));
				X += edge.c;
				K++;
				T--;
			}
		}
		
		bw.write(X + " " + K + "\n");
		
		for (Point pt : points) {
			bw.write(pt.x + " " + pt.y + "\n");
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
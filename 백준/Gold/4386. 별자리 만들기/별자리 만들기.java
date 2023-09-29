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
	public static ArrayList<Edge> list;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Point arr[] = new Point[N];
		double c = 0;
		parent = new int[N + 1];
		list = new ArrayList<Edge>();

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				list.add(new Edge(i, j, Math.sqrt(Math.pow(arr[j].x - arr[i].x, 2) + Math.pow(arr[j].y - arr[i].y, 2))));
			}
		}

		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c > o2.c? 1 : -1;
			}
		});
		
		for (int j = 0; j < list.size(); j++) {
			Edge edge = list.get(j);

			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				c += edge.c;
			}
		}
		
		bw.write(String.format("%.2f", c) + "\n");
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

class Point {
	double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
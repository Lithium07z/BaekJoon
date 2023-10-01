import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static int parent[];
	public static Point arr[];
	public static ArrayList<Edge> list;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int z = 0;
		arr = new Point[N];
		parent = new int[N];
		list = new ArrayList<Edge>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), i);
			parent[i] = i;
		}

		sortX(N);
		sortY(N);
		sortZ(N);

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
				z += edge.c;
			}
		}

		bw.write(z + "\n");
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

	public static void sortX(int N) {
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
		});

		for (int i = 0; i < N - 1; i++) {
			list.add(new Edge(arr[i].s, arr[i + 1].s, Math.abs(arr[i].x - arr[i + 1].x)));
		}
	}

	public static void sortY(int N) {
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.y - o2.y;
			}
		});

		for (int i = 0; i < N - 1; i++) {
			list.add(new Edge(arr[i].s, arr[i + 1].s, Math.abs(arr[i].y - arr[i + 1].y)));
		}
	}

	public static void sortZ(int N) {
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.z - o2.z;
			}
		});

		for (int i = 0; i < N - 1; i++) {
			list.add(new Edge(arr[i].s, arr[i + 1].s, Math.abs(arr[i].z - arr[i + 1].z)));
		}
	}
}

class Point {
	int x, y, z, s;

	public Point(int x, int y, int z, int s) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.s = s;
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
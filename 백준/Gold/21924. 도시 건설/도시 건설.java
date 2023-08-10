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
		parent = new int[N + 1];
		long s = 0;
		long t = 0;
		int k = 0;

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new Edge(a, b, c));
			list.add(new Edge(b, a, c));
			t += c;
		}

		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.c, o2.c);
			}
		});

		for (int i = 0; i < M * 2; i++) {
			Edge temp = list.get(i);
			if (!find(temp.s, temp.e)) {
				union(temp.s, temp.e);
				s += temp.c;
				k++;
			}
		}

		bw.write((k == N - 1)? t - s + "\n" : "-1");
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
		parent[i] = j;
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
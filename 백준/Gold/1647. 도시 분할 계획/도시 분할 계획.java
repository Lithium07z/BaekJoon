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
		ArrayList<Edge> MST = new ArrayList<Edge>();
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		int m = 0;

		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < e; i++) {
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

		for (int i = 0; i < e; i++) {
			Edge temp = list.get(i);
			if (!find(temp.s, temp.e)) {
				union(temp.s, temp.e);
				MST.add(temp);
			}
		}
		
//		for (Edge a : MST) {
//			System.out.println(a.s + " " + a.e + " " + a.c);
//		}

		for (int i = 0; i < MST.size() - 1; i++) {
			m += MST.get(i).c;
		}

		bw.write(m + "\n");
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
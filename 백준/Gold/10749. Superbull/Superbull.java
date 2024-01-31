import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

class Main {
	public static int parent[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Edge> list = new ArrayList<Edge>();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		long r = 0;
		
		parent = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		} 
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				list.add(new Edge(i, j, arr[i] ^ arr[j]));
			}
		}

		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o2.c, o1.c);
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);

			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				r += edge.c;
			}
		}

		bw.write(r + "\n");
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
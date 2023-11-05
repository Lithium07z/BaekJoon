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
		while (true) { 
			ArrayList<Edge> list = new ArrayList<Edge>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int r = 0;
			parent = new int[N];

			if (N == 0) { 
				break;
			}
			
			for (int j = 0; j < N; j++) {
				parent[j] = j;
			}

			for (int j = 0; j < N - 1; j++) {
				st = new StringTokenizer(br.readLine());
				int s = st.nextToken().toCharArray()[0] - 65;
				int t = Integer.parseInt(st.nextToken());
				for (int k = 0; k < t; k++) {
					list.add(new Edge(s, st.nextToken().toCharArray()[0] - 65, Integer.parseInt(st.nextToken())));
				}
			}

			list.sort(new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return o1.c - o2.c;
				}
			});
			
			for (int j = 0; j < list.size(); j++) {
				Edge edge = list.get(j);

				if (!find(edge.s, edge.e)) {
					union(edge.e, edge.s);
					r += edge.c;
				}
			}
		
			bw.write(r + "\n");
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
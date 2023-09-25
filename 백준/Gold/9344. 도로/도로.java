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
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			boolean flag = true;
			parent = new int[N + 1];
			list = new ArrayList<Edge>();

			for (int j = 1; j <= N; j++) {
				parent[j] = j;
			}

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
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
					union(edge.s, edge.e);
					
					if (edge.s == p && edge.e == q) { 
						flag = false;
					}
				}
			}
			
			bw.write(flag ? "NO\n" : "YES\n");
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
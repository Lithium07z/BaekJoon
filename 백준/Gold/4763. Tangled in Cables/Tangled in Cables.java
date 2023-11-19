import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int parent[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Edge> list = new ArrayList<Edge>();
		double L = Double.parseDouble(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int idx = 0;
		double c = 0;
		parent = new int[N];
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, idx++);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Edge(map.get(st.nextToken()), map.get(st.nextToken()), Double.parseDouble(st.nextToken())));
		}
		
		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.c, o2.c);
			}
		});
		
		for (int k = 0; k < list.size(); k++) {
			Edge edge = list.get(k);

			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				c += edge.c;
			}
		}
		
		bw.write(c > L ? "Not enough cable" : "Need " + String.format("%.1f", c) + " miles of cable");
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
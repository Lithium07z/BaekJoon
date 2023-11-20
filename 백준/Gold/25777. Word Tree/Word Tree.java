import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static int parent[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Edge> list = new ArrayList<Edge>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int c = Integer.MIN_VALUE;
		String arr[] = new String[N];
		parent = new int[N];
		
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			arr[i] = br.readLine();
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int temp = 0;
				
				for (int k = 0; k < M; k++) {
					temp += Math.abs(arr[i].charAt(k) - arr[j].charAt(k));
				}
				
				list.add(new Edge(i, j, temp));
			}
		}
		
		list.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.c - o2.c;
			}
		});
		
		for (int k = 0; k < list.size(); k++) {
			Edge edge = list.get(k);

			if (!find(edge.s, edge.e)) {
				union(edge.s, edge.e);
				c = Math.max(c, edge.c);
			}
		}
		
		bw.write(c + "\n");
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
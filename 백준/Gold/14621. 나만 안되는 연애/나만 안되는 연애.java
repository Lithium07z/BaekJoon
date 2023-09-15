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
		String s[] = new String[N];
		parent = new int[N + 1];
		int t = 0;
		int c = 0;
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = st.nextToken();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (!s[u - 1].equals(s[v - 1])) {
				list.add(new Edge(u, v, Integer.parseInt(st.nextToken())));
			}
		}

		list.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.c, o2.c);
            }
        });
		
		for (int i = 0; i < list.size(); i++) {
			Edge temp = list.get(i);
			if (!find(temp.s, temp.e)) {
				union(temp.s, temp.e);
				t += temp.c;
				c++;
			}
		}
		
		bw.write(c == N - 1 ? t + "\n" : "-1");
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
		this.s = s; this.e = e; this.c = c;
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		UnionFind uf = new UnionFind(n + 1);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("0")) {
				uf.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			} else {
				bw.write((uf.find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))? "YES\n" : "NO\n");
			}
		}
		bw.flush();
		bw.close();
	}
}

class UnionFind {
    int [] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) 
            parent[i] = i;        
    }

    private int root(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];  
            i = parent[i];
        }
        return i;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        parent[i] = j;
    }
}
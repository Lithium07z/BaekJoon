import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public static int parent[];
    public static int solution(int n, int[][] costs) {
		ArrayList<Edge> list = new ArrayList<Edge>();
		int INF = 987654321;
		int result = 0;
		parent = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < costs.length; i++) {
			list.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
		}
		
		list.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.c, o2.c);
            }
        });
		
		for (int i = 0; i < costs.length; i++) {
			Edge temp = list.get(i);
			if (!find(temp.s, temp.e)) {
				union(temp.s, temp.e);
				result += temp.c;
			}
		}
		
		return result;
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
		this.s = s; this.e = e; this.c = c;
	}
}
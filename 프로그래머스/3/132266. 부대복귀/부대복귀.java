import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static int INF = 987654321;
	static ArrayList<Node> graph[];
	static int dist[];
   
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int res[] = new int[sources.length];
		dist = new int[n];
		graph = new ArrayList[n];

		Arrays.fill(dist, INF);
		
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < roads.length; i++) { 
			graph[roads[i][0] - 1].add(new Node(roads[i][1] - 1, 1));
			graph[roads[i][1] - 1].add(new Node(roads[i][0] - 1, 1));
		}
		
		Dijkstra(destination - 1);
		
		for (int i = 0; i < res.length; i++) {
			res[i] = dist[sources[i] - 1] == INF ? -1 : dist[sources[i] - 1];
		}
        
        return res;
    }
    
    public static void Dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean visited[] = new boolean[graph.length];

		dist[s] = 0;
		pq.offer(new Node(s, 0));

		while (!pq.isEmpty()) {
			int crt = pq.poll().x;

			if (visited[crt]) {
				continue;
			}

			visited[crt] = true;

			for (Node next : graph[crt]) {
				if (dist[next.x] > dist[crt] + next.y) {
					dist[next.x] = dist[crt] + next.y;
					pq.offer(new Node(next.x, dist[next.x]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.y, o.y);
	}
}
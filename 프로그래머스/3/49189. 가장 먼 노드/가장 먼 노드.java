import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean graph[][];
	static boolean visited[];
	public static int solution(int n, int[][] edge) {
		graph = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < edge.length; i++) {
			graph[edge[i][0]][edge[i][1]] = graph[edge[i][1]][edge[i][0]] = true;
		}
		
		return BFS(1);
    }
	
	public static int BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		int dist[] = new int[graph.length];
		int result = 0;
		
		q.add(s);
		visited[s] = true;
		
		while (!q.isEmpty()) {
			s = q.poll();
			
			for (int i = 0; i < graph.length; i++) {
				if (graph[s][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
					dist[i] = dist[s] + 1;
				}
			}
		}
		
		Arrays.sort(dist);
		
		for (int i = dist.length - 1; i >= 0; i--) {
			if (dist[i] == dist[dist.length - 1]) {
				result++;
			}
		}
		
		return result;
	}
}
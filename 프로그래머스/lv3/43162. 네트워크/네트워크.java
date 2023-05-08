class Solution {
    static boolean visited[];
    static boolean flag;
	public static int solution(int n, int[][] computers) {
		visited = new boolean[n];
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			flag = true;
			DFS(i, computers, visited);
			if (!flag) {
				cnt++;
			}
		}
		
        return cnt;
    }
	
	public static void DFS(int s, int[][] graph, boolean visited[]) {
		if (!visited[s]) {
			flag = false;
		}
		visited[s] = true;
		for (int i = 0; i < graph.length; i++) {
			if (graph[s][i] == 1 && !visited[i]) {
				DFS(i, graph, visited);
			}
		}
	}
}
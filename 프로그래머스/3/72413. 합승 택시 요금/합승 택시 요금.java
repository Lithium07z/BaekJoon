class Solution {
    static int INF = 987654321;
    
    public static int solution(int n, int s, int a, int b, int[][] fares) {
		int graph[][] = new int[n][n];
		int min = INF;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < fares.length; i++) {
			graph[fares[i][0] - 1][fares[i][1] - 1] = graph[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i != j && j != k && i != k) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (graph[s - 1][i] != INF && graph[i][a - 1] != INF && graph[i][b - 1] != INF) {
				min = Math.min(min, graph[s - 1][i] + graph[i][a - 1] + graph[i][b - 1]);
			}
		}
		
		return min;
	}
}
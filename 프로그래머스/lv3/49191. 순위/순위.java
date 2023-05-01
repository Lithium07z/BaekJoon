class Solution {
    public int solution(int n, int[][] results) {
		int INF = 987654321;
		int graph[][] = new int[n][n];
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					graph[i][j] = INF;
				}
			}
		}
		
		for (int temp[] : results) {
			graph[temp[0] - 1][temp[1] - 1] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) { 
					if (graph[j][k] > graph[j][i] + graph[i][k]) {
						graph[j][k] = graph[j][i] + graph[i][k];
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (graph[i][j] != 0 && graph[i][j] != INF) {
					count++;
				}
				if (graph[j][i] != 0 && graph[j][i] != INF) {
					count++;
				}
			}
			if (count == n - 1) {
				result++;
			}
		}
		
		return result;
    }
}
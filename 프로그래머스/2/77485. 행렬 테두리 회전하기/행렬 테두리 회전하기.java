class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
		int arr[][] = new int[rows][columns];
		int result[] = new int[queries.length];
		int value = 1;
		int idx = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = value++;
			}
		}

		for (int[] query : queries) {
			int x1 = query[0] - 1;
			int y1 = query[1] - 1;
			int x2 = query[2] - 1;
			int y2 = query[3] - 1;
			int del = arr[x1][y2];
			int min = del;

			for (int i = y2 - 1; i >= y1; i--) {
				min = Math.min(min, arr[x1][i]);
				arr[x1][i + 1] = arr[x1][i];
			}
			
			for (int i = x1 + 1; i <= x2; i++) {
				min = Math.min(min, arr[i][y1]);
				arr[i - 1][y1] = arr[i][y1];
			}

			for (int i = y1 + 1; i <= y2; i++) {
				min = Math.min(min, arr[x2][i]);
				arr[x2][i - 1] = arr[x2][i];
			}
			
			for (int i = x2 - 1; i >= x1; i--) {
				min = Math.min(min, arr[i][y2]);
				arr[i + 1][y2] = arr[i][y2];
			}

			arr[x1 + 1][y2] = del;
			result[idx++] = min;
		}
		
		return result;
	}
}
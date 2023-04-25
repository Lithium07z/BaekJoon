class Solution {
    public int solution(int[][] triangle) {
		int max = 0;
		
		for (int i = 0; i < triangle.length; i++) {
			boolean flag = true;
			for (int j = 0; j < i + 2 && j < triangle[i].length; j++) {
				if (flag && i + 1 < triangle.length) {
					triangle[i + 1][j] += triangle[i][j];
				} else {
					flag = true;
				}
				
				if (j + 1 < triangle[i].length && triangle[i][j] < triangle[i][j + 1]) {
					continue;
				} else {
					if (i + 1 < triangle.length && j + 1 < triangle[i + 1].length) {
						triangle[i + 1][j + 1] += triangle[i][j];
						flag = false;
					}
				}
			}
		}
		
		for (int i = 0; i < triangle.length; i++) {
			max = Math.max(triangle[triangle.length - 1][i], max);
		}
		
		return max;
	}
}
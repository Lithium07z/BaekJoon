import java.util.Arrays;
import java.util.Comparator;

class Solution {
   public static int solution(int[][] routes) {
		int cnt = 1;

		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				return o1[1] - o2[1];
			}
		});

		int end = routes[0][1];
		for (int i = 1; i < routes.length; i++) {
			if (routes[i][0] > end) {
				end = routes[i][1];
				cnt++;
			}
		}

		return cnt;
	}
}

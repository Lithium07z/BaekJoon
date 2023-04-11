import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
		long min = Long.MAX_VALUE;
		long mid = 0;
		
		Arrays.sort(times);
		
		long s = times[0]; 
		long e = times[times.length - 1] * (long)n; // 주의
		
		while (s <= e) {
			mid = (s + e) / 2;
			
			long sum = 0;
			for (int t : times) {
				sum += mid / t;
			}
			
			if (sum >= n) {
				min = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			} 
		}
		
		return min;
    }
}
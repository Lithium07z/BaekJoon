class Solution {
    public static int[] solution(int brown, int yellow) {
		int result[] = new int[2];
		int sum = brown + yellow;
		
		for (int i = 2; i < sum; i++) {
			int temp = 0;
			if (sum % i == 0) {
				temp = sum / i;
				
				if (temp * 2 + i * 2 - 4 == brown) {
					result[0] = Math.max(temp, i);
					result[1] = Math.min(temp, i);
				}
			}
		}
		
		return result;
    }
}
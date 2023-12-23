class Solution {
    public int solution(int[] money) {
		int dp1[] = new int[money.length];
		int dp2[] = new int[money.length];
		
		for (int i = 0; i < money.length; i++) {
			dp1[i] = dp2[i] = money[i];
		}
		
		dp1[1] = dp2[0] = -1;
		dp1[2] += dp1[0];
		for (int i = 3; i < money.length; i++) {
			dp1[i] += Math.max(dp1[i - 2], dp1[i - 3]);
			dp2[i] += Math.max(dp2[i - 2], dp2[i - 3]);
		}
		
		return Math.max(Math.max(dp1[dp1.length - 2], dp1[dp1.length - 3]), Math.max(dp2[dp2.length - 1], dp2[dp2.length - 2]));
    }
}
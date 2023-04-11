import java.util.HashMap;

class Solution {
    public static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int sum = 1;

		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
		}

		for (int t : map.values()) {
			sum *= t;
		}

		return sum - 1;
	}
}
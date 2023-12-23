class Solution {
    public int[] solution(String[][] places) {
		int[] result = new int[places.length];

		for (int i = 0; i < places.length; i++) {
			String[] map = places[i];
			boolean flag = false;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (map[j].charAt(k) == 'P') {
						if (check(j, k, map)) {
                            result[i] = 0;
							flag = true;
							break;
						}
					}
				}
			}
			if (!flag) {
				result[i] = 1;
			}
		}

		return result;
	}

	public static boolean check(int i, int j, String[] map) {
		int[] xp1 = { 0, 0, 1, -1 };
		int[] yp1 = { 1, -1, 0, 0 };
		for (int k = 0; k < 4; k++) {
			int ti = i + xp1[k];
			int tj = j + yp1[k];
			if (ti < 0 || ti >= 5 || tj < 0 || tj >= 5) {
				continue;
			}
			if (map[ti].charAt(tj) == 'P') {
				return true;
			}
		}

		int[] xp2 = { 0, 0, 2, -2 };
		int[] yp2 = { 2, -2, 0, 0 };
		for (int k = 0; k < 4; k++) {
			int ti = i + xp2[k];
			int tj = j + yp2[k];
			if (ti < 0 || ti >= 5 || tj < 0 || tj >= 5) {
				continue;
			}
			if (map[ti].charAt(tj) == 'P') {
				if (map[(i + ti) / 2].charAt((j + tj) / 2) != 'X') {
					return true;
				}
			}
		}

		int[] xp3 = { 1, 1, -1, -1 };
		int[] yp3 = { 1, -1, 1, -1 };
		for (int k = 0; k < 4; k++) {
			int ti = i + xp3[k];
			int tj = j + yp3[k];
			if (ti < 0 || ti >= 5 || tj < 0 || tj >= 5) {
				continue;
			}
			if (map[ti].charAt(tj) == 'P') {
				if (!(map[i].charAt(tj) == 'X' && map[ti].charAt(j) == 'X')) {
					return true;
				}
			}
		}

		return false;
	}
}
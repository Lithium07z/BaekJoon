import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] info, String[] query) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		int result[] = new int[query.length];

		for (int i = 0; i < info.length; i++) {
			String temp[] = info[i].split(" ");
			String bruteforce[][] = { 
					{ temp[0], "-" }, 
					{ temp[1], "-" }, 
					{ temp[2], "-" }, 
					{ temp[3], "-" }, 
			};

			for (String t : bruteforce[0]) {
				for (String l : bruteforce[1]) {
					for (String c : bruteforce[2]) {
						for (String f : bruteforce[3]) {
							StringBuilder sb = new StringBuilder();
							sb.append(t).append(l).append(c).append(f);
							if (map.containsKey(sb.toString())) {
								map.get(sb.toString()).add(Integer.parseInt(temp[4]));
							} else {
								ArrayList<Integer> list = new ArrayList<Integer>();
								list.add(Integer.parseInt(temp[4]));
								map.put(sb.toString(), list);
							}
						}
					}
				}
			}
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			StringBuilder sb = new StringBuilder();
			String querys[] = query[i].replaceAll(" and ", " ").split(" ");
			sb.append(querys[0]).append(querys[1]).append(querys[2]).append(querys[3]);
			int t = Integer.parseInt(querys[4]);

			if (map.containsKey(sb.toString())) { // 키가 존재함
				if (map.get(sb.toString()).size() == 1) { // 키 값과 일치하는 사람이 1명
					if (t <= map.get(sb.toString()).get(0)) {
						result[i] = 1;
					}
				} else { // 이분 탐색으로 t값 이상인 사람을 탐색
					int s = 0;
					int e = map.get(sb.toString()).size() - 1;

					while (s <= e) {
						int mid = (s + e) / 2;
						if (map.get(sb.toString()).get(mid) < t) {
							s = mid + 1;
						} else {
							e = mid - 1;
						}
					}
					result[i] = map.get(sb.toString()).size() - s;
				}
			}
		}

		return result;
	}
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, TreeMap<Integer, ArrayList<Integer>>> mmap = new HashMap<String, TreeMap<Integer, ArrayList<Integer>>>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < plays.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
			if (!mmap.containsKey(genres[i])) {
				mmap.put(genres[i], new TreeMap<Integer, ArrayList<Integer>>(Collections.reverseOrder()));
			}
			if (!mmap.get(genres[i]).containsKey(plays[i])) {
				mmap.get(genres[i]).put(plays[i], new ArrayList<Integer>());
			}
			mmap.get(genres[i]).get(plays[i]).add(i);
		}

		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

		for (String key : keySet) {
			int c = 0;
			for (ArrayList<Integer> idx : mmap.get(key).values()) {
				if (c > 1) {
					break;
				}
				int c2 = 0;
				for (int t : idx) {
					if (c2 > 1) {
						break;
					}
					list.add(t);
					c2++;
				}
				if (c2 == 2) {
					break;
				}
				c++;
			}
		}
		
		int result[] = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}
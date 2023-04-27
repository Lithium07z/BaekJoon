import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		
		for (int i = 0; i < 9; i++) {
			list.add(new HashSet<Integer>());
		}
		
		list.get(1).add(N);
		
		for (int i = 2; i < 9; i++) {
			HashSet<Integer> set = list.get(i);
			
			for (int j = 1; j <= i; j++) {
				HashSet<Integer> s = list.get(j);
				HashSet<Integer> e = list.get(i - j);
				
				for (int t1 : s) {
					for (int t2 : e) {
						set.add(t1 + t2);
						set.add(t1 - t2);
						set.add(t1 * t2);
						
						if (t1 != 0 && t2 != 0) {
							set.add(t1 / t2);
						}
					}
				}
			}
			set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
		}
		
		for (HashSet<Integer> r : list) {
			if (r.contains(number)) {
				return list.indexOf(r);
			}
		}
		
		return -1;
    }
}
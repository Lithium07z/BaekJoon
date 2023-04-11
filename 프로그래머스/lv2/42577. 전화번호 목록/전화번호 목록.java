import java.util.HashSet;

class Solution {
    public static boolean solution(String[] phone_book) {
		HashSet<String> set = new HashSet<String>();
		
		for (String t : phone_book) {
			set.add(t);
		}
		
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				if (set.contains(phone_book[i].substring(0, j))) {
					return false;
				}
			}
		}
		return true;
	}
}
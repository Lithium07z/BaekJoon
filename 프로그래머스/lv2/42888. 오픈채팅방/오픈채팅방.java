import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < record.length; i++) {
			String arr[] = record[i].split(" ");
			
			if (arr.length > 2) {
				map.put(arr[1], arr[2]);
			}
		}
		
		for (int i = 0; i < record.length; i++) {
			String arr[] = record[i].split(" ");
			if (arr[0].equals("Enter")) {
				list.add(map.get(arr[1]) + "님이 들어왔습니다.");
			} else if (arr[0].equals("Leave")) {
				list.add(map.get(arr[1]) + "님이 나갔습니다.");
			}
		}
		
		String result[] = new String[list.size()];
		list.toArray(result);
		
		return result;
	}
}
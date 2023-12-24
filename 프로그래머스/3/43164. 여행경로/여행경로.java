import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    static String result = "";
    public static String[] solution(String[][] tickets) {
        ArrayList<String> list = new ArrayList<>();
        boolean visited[] = new boolean[tickets.length];
        
        DFS("ICN", "ICN", tickets, 0, visited, list);

        return result.split(" ");
    }
	
	public static void DFS(String start, String value, String tickets[][], int idx, boolean visited[], ArrayList<String> list) {
		if (idx == tickets.length) {
			if (result.length() == 0) {
				result = value;
			} else {
				if (result.compareTo(value) > 1) {
					result = value;
				}
			}
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (start.equals(tickets[i][0]) && !visited[i]) {
				visited[i] = true;
				DFS(tickets[i][1], value + " " + tickets[i][1], tickets, idx + 1, visited, list);
				visited[i] = false;
			}
		}
	}
}
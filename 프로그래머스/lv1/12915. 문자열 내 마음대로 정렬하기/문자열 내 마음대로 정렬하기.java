import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        String arr[] = new String[strings.length];
		
		for (int i = 0; i < strings.length; i++) {
			StringBuilder sb = new StringBuilder();
			arr[i] = sb.append(strings[i].charAt(n)).append(strings[i]).toString();
		}
		
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(1);
		}
		
		return arr;
    }
}
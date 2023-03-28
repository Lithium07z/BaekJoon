import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> tset = new TreeSet<Integer>();
		
		for (int i = 0; i < numbers.length - 1; i++) { 
			for (int j = i + 1; j < numbers.length; j++) {
				tset.add(numbers[i] + numbers[j]);
			}
		}
		
		int arr[] = new int[tset.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = tset.pollFirst();
		}
		
		return arr;
    }
}
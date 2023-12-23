class Solution {
    public static int[] solution(int[] answers) {
		int per1[] = {1, 2, 3, 4, 5};
		int per2[] = {2, 1, 2, 3, 2, 4, 2, 5};
		int per3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int temp[] = new int[3];
		int max = 0;
		int size = 0;
    	int idx = 0;
    	int cnt1 = 0;
    	int cnt2 = 0;
    	int cnt3 = 0;
        
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == per1[idx++ % 5]) {
				cnt1++;
			}
        }
		
		max = Math.max(max, cnt1);
		temp[0] = cnt1;
		idx = 0;
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == per2[idx++ % 8]) {
				cnt2++;
			}
        }
		
		max = Math.max(max, cnt2);
		temp[1] = cnt2;
		idx = 0;
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == per3[idx++ % 10]) {
				cnt3++;
			}
        }
		
		max = Math.max(max, cnt3);
		temp[2] = cnt3;
		idx = 0;
		
		for (int i = 0; i < 3; i++) {
			if (max != 0 && temp[i] == max) {
				size++;
			}
		}
		
		int result[] = new int[size];
		for (int i = 0; i < 3; i++) {
			if (max != 0 && temp[i] == max) {
				result[idx++] = i + 1;
			}
		}
		
		return result;
    }
}
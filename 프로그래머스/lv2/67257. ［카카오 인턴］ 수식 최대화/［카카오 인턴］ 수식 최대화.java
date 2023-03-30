import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

class Solution {
    public long solution(String expression) {
		String T[][] = { 
				{ "-", "+", "*" },
				{ "-", "*", "+" },
				{ "*", "+", "-" }, 
				{ "*", "-", "+" }, 
				{ "+", "*", "-" }, 
				{ "+", "-", "*" }	 };
		long max = Long.MIN_VALUE;

		for (int i = 0; i < T.length; i++) {
			StringTokenizer st1 = new StringTokenizer(expression, T[i][0]);
			Deque<Long> dq1 = new LinkedList<Long>();
			int cnt = st1.countTokens();
			
			for (int k = 0; k < cnt; k++) {
				StringTokenizer st2 = new StringTokenizer(st1.nextToken(), T[i][1]);
				Deque<Long> dq2 = new LinkedList<Long>();
				
				while (st2.hasMoreTokens()) {
					String temp = st2.nextToken();
					if (temp.contains(T[i][2])) {
						StringTokenizer st3 = new StringTokenizer(temp, T[i][2]);
						Deque<Long> dq3 = new LinkedList<Long>();
						
						while (st3.hasMoreTokens()) {
							dq3.add(Long.parseLong(st3.nextToken()));
						}
						
						while (dq3.size() > 1) {
							if (T[i][2].equals("*")) {
								dq3.addFirst(dq3.pollFirst() * dq3.pollFirst());
							} else if (T[i][2].equals("+")) {
								dq3.addFirst(dq3.pollFirst() + dq3.pollFirst());
							} else if (T[i][2].equals("-")) {
								dq3.addFirst(dq3.pollFirst() - dq3.pollFirst());
							}
						}
						dq2.add(dq3.poll());
					} else {
						dq2.add(Long.parseLong(temp));
					}
				}
				
				while (dq2.size() > 1) {
					if (T[i][1].equals("*")) {
						dq2.addFirst(dq2.pollFirst() * dq2.pollFirst());
					} else if (T[i][1].equals("+")) {
						dq2.addFirst(dq2.pollFirst() + dq2.pollFirst());
					} else if (T[i][1].equals("-")) {
						dq2.addFirst(dq2.pollFirst() - dq2.pollFirst());
					}
				}
				
				dq1.add(dq2.poll());
			}
			
			while (dq1.size() > 1) {
				if (T[i][0].equals("*")) {
					dq1.addFirst(dq1.pollFirst() * dq1.pollFirst());
				} else if (T[i][0].equals("+")) {
					dq1.addFirst(dq1.pollFirst() + dq1.pollFirst());
				} else if (T[i][0].equals("-")) {
					dq1.addFirst(dq1.pollFirst() - dq1.pollFirst());
				}
			}

			max = Math.max(max, Math.abs(dq1.poll()));
		}
		return max;
	}
}
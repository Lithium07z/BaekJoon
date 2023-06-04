import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.nextLong()).reverse();
            pq.add(Long.parseLong(sb.toString()));
        }

        while(!pq.isEmpty()) {
        	System.out.println(pq.poll());
        }
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<Integer>();
		int num = Integer.parseInt(bfr.readLine());
		
		for (int i = 1; i <= num; i++) {
			queue.add(i);
		}
		for (int i = 1; i < num; i++) {
			queue.poll();
			queue.add(queue.poll());
		}
		bfw.write(String.valueOf(queue.peek()));
		bfw.flush();
		bfw.close();		
	}
}
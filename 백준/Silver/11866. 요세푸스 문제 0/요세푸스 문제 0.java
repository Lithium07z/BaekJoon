import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int size = Integer.parseInt(st.nextToken());
		int check = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= size; i++) {
			queue.add(i);
		}
		
		bfw.write("<");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < check; j++) {
				int value = queue.poll();
				if (j == check - 1) {
					bfw.write(String.valueOf(value));
					if (i < size - 1) {
						bfw.write(", ");
					}
					continue;
				}
				queue.add(value);
			}
		}
		bfw.write(">");
		bfw.flush();
		bfw.close();
	}
}
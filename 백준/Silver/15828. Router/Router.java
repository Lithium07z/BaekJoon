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
		
		int size = Integer.parseInt(bfr.readLine());
		
		while (true) {
			int num = Integer.parseInt(bfr.readLine());
			if (num == -1) {
				break;
			} else if (num == 0) {
				queue.remove();
			} else if (size == queue.size()) {
				continue;
			} else {
				queue.add(num);
			}
		}
		
		if (queue.size() == 0) {
			bfw.write("empty");
		} else {
			int fixedSize = queue.size();
			for (int i = 0; i < fixedSize; i++) {
				bfw.write(String.valueOf(queue.poll()) + " ");
			}
		}
		bfw.flush();
		bfw.close();
	}
}
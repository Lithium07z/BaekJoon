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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = Integer.parseInt(st.nextToken());
		int delete = Integer.parseInt(st.nextToken());
		int arr[] = new int[size];
		
		for (int i = 1; i <= size; i++) {
			queue.add(i);
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < delete; j++) {
				int temp;
				if (j != delete - 1) {
					temp = queue.poll();
					queue.add(temp);
				} else {
					arr[i] = queue.poll();
				}
			}
		}
		bfw.write("<");
		for (int i = 0; i < size; i++) {
			bfw.write(String.valueOf(arr[i]));
			if (i != size - 1) {
				bfw.write(", ");
			}
		}
		bfw.write(">");
		bfw.flush();
		bfw.close();
	}
}
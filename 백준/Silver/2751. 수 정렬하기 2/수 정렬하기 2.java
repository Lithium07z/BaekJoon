import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		int value = Integer.parseInt(bfr.readLine());
		int arr[] = new int [value];
		
		for (int i = 0; i < value; i++) {
			heap.add(Integer.parseInt(bfr.readLine()));
		}
		for (int i = 0; i < value; i++) {
			bfw.write(String.valueOf(heap.poll()) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int length = Integer.parseInt(bfr.readLine());
		int count = 0;
		
		for (int i = 0; i < length; i++) {
			map.put(bfr.readLine(), i);
		}
		
		int arr[] = new int[length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = map.get(bfr.readLine());
		}
		
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (arr[i] > arr[j]) {
					count++;
					break;
				}
			}
		}
		
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}
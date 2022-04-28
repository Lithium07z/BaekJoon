import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		int arr[] = new int [loop];
		
		for (int i = 0; i < loop; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		
		for (int i = 0; i < loop - 1; i++) {
			for (int j = i + 1; j < loop; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int value : arr) {
			bfw.write(String.valueOf(value) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}

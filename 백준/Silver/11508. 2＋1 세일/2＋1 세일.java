import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		Integer[] arr = new Integer[loop];
		int count = 0;
		int sum = 0;
		
		for (int i = 0; i < loop; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 1; i <= loop; i++) {
			if (i % 3 == 0) {
				continue;
			}
			sum += arr[i - 1];
		}
		System.out.println(sum);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(bfr.readLine());
		int arr[] = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		
		Arrays.sort(arr);
		
		for (int result : arr) {
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
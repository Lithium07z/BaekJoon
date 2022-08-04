import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bfr.readLine());
		int arr[] = new int[num];
		int max = 0;

		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < num; i++) {
			max = Math.max(max, arr[i] * (num - i));
		}
		bfw.write(String.valueOf(max));
		bfw.flush();
		bfw.close();
	}
}
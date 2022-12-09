import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		int arr[] = new int[10];
		StringTokenizer st;
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(bfr.readLine());
			for (int j = 0; j < 10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			bfw.write(String.valueOf(arr[7]) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
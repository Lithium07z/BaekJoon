import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int value = Integer.parseInt(bfr.readLine());
		int arr[] = new int[value];
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < value; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		bfw.write(String.valueOf(arr[0] * arr[value - 1]));
		bfw.flush();
		bfw.close();
	}
}
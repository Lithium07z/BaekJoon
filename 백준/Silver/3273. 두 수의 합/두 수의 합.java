import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int total = Integer.parseInt(bfr.readLine());
		int arr[] = new int[size];
		int s = 0;
		int e = size - 1;
		int count = 0;
		int sum = 0;

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		while(true) {
			if (s >= e) {
				break;
			}
			sum = arr[s] + arr[e];
			if (sum == total) {
				s++;
				e--;
				count++;
			} else if (sum > total) {
				e--;
			} else {
				s++;
			}
		}
		
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}
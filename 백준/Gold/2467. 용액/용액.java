import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int arr[] = new int[size];
		int min = Integer.MAX_VALUE;
		int s = 0;
		int e = size - 1;
		int sum = -1;
		int result1 = 0;
		int result2 = 0;
		
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			if (s >= e) {
				break;
			}
			sum = arr[s] + arr[e];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				result1 = Math.min(arr[s], arr[e]);
				result2 = Math.max(arr[s], arr[e]);
			}
			if (sum == 0) {
				break;
			} else if (sum > 0) {
				e--;
			} else {
				s++;
			}
		}
		bfw.write(String.valueOf(result1) + " " + String.valueOf(result2));
		bfw.flush();
		bfw.close();
	}
}
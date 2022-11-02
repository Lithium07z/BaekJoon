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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int size = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		int arr[] = new int[size];
		int s = 0;
		int e = 0;
		int count = 0;
		int sum = 0;

		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while(true) {
			if (sum >= total) {
				sum -= arr[s++];
			} else if (e == size) {
				break;
			} else {
				sum += arr[e++];
			}
			if (sum == total) {
				count++;
			}
		}
		
		bfw.write(String.valueOf(count));
		bfw.flush();
		bfw.close();
	}
}
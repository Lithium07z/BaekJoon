import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int s = 0;
		int e = 0;
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		 
		while (e < N) {
			if (sum == N) {
				count++;
			}
			if (sum >= N) {
				sum -= arr[s++];
			} else {
				sum += arr[e++];
			}
		}
		
		bw.write(count + 1 + "\n");
		bw.flush();
		bw.close();
	}
}
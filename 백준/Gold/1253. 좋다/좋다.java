import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			int s = 0;
			int e = arr.length - 1;
			while (s < e) {
				if (arr[s] + arr[e] == arr[i]) {
					if (s == i) {
						s++;
					} else if (e == i) {
						e--;
					} else {
						count++;
						break;
					}
				} else if (arr[s] + arr[e] < arr[i]) {
					s++;
				} else if (arr[s] + arr[e] > arr[i]) {
					e--;
				}
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}
}
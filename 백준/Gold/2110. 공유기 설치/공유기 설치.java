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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int s = 1;
		int e = arr[N - 1] - arr[0] + 1;
		while (s < e) {
			int mid = (s + e) / 2;
			
			if (C > countHouse(mid, arr, N)) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		
		
		bw.write(e - 1 + "\n");
		bw.flush();
		bw.close();
	}
	
	public static int countHouse(int mid, int arr[], int N) {
		int s = 0;
		int e = 0;
		int cnt = 1;
		
		while (e < N) {
			if (arr[e] - arr[s] >= mid) {
				s = e;
				cnt++;
			}
			e++;
		}
		
		return cnt;
	}
}
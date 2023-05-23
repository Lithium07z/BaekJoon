import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String str = br.readLine();
			if (str == null || str.isBlank()) {
				break;
			}
			
			int x = Integer.parseInt(str) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(arr);
			
			String temp = binarySearch(arr, 0, n - 1, x);
			if (temp.isEmpty()) {
				bw.write("danger\n");
			} else {
				bw.write("yes " + temp + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static String binarySearch(int arr[], int s, int e, int t) {
		while (s < e) {
			int mid = arr[s] + arr[e];
		
			if (mid > t) {
				e--;
			} else if (mid < t) {
				s++;
			} else {
				return arr[s] + " " + arr[e];
			}
		}
		
		return "";
	}
}
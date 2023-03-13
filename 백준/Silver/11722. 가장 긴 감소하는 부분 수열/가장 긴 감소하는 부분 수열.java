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
		int N = Integer.parseInt(br.readLine());
		int[] size = new int[N];
		int[] arr = new int[N];
		int min;
		Arrays.fill(arr, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			min = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (size[i] < size[j]) {
					if (min < arr[j]) {
						min = arr[j];
					}
				}
			}
			arr[i] += min;
		}
		
		Arrays.sort(arr);			
		bw.write(arr[arr.length - 1] + "\n");
		bw.flush();
		bw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bfr.readLine());
		int arr[] = new int[N];
		double sum = 0;
		int appear[] = new int[8001];
		int max = -1;
		int min = 4001;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
			appear[arr[i] + 4000]++;
		}
		
		Arrays.sort(arr);
		for (int temp : arr) {
			sum += temp;
		}

		bfw.write(String.valueOf(Math.round(sum / (double)arr.length)) + "\n");
		bfw.write(String.valueOf(arr[arr.length / 2]) + "\n");
		
		for (int i = 0; i < appear.length; i++) {
			if (appear[i] > max) {
				max = appear[i];
			}
		}
		
		for (int i = 0; i < appear.length; i++) {
			if (count == 2) {
				break;
			}
			if (appear[i] == max && i - 4000 < min) {
				min = i;
				count++;
			}
		}
		
		bfw.write(String.valueOf(min - 4000) + "\n");
		bfw.write(String.valueOf(arr[arr.length - 1] - arr[0]));
		bfw.flush();
		bfw.close();
	}
}
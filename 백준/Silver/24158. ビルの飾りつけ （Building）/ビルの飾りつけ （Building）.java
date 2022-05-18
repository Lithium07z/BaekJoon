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
		int caseNum = Integer.parseInt(bfr.readLine());
		int[] height = new int[caseNum];
		int[] arr = new int[caseNum];
		int max;
		Arrays.fill(arr, 1);
		
		for (int i = 0; i < caseNum; i++) {
			height[i] = Integer.parseInt(bfr.readLine());
		}
		
		for (int i = 1; i < caseNum; i++) {
			max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (height[i] > height[j]) {
					if (max < arr[j]) {
						max = arr[j];
					}
				}
			}
			arr[i] += max;
		}
		
		Arrays.sort(arr);
		bfw.write(String.valueOf(arr[arr.length - 1]));
		bfw.flush();
		bfw.close();
	}
}
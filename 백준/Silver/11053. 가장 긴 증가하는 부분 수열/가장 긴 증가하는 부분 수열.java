import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int caseNum = Integer.parseInt(bfr.readLine());
		int[] size = new int[caseNum];
		int[] arr = new int[caseNum];
		int max;
		Arrays.fill(arr, 1);
		
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		for (int i = 0; i < caseNum; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < caseNum; i++) {
			max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (size[i] > size[j]) {
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
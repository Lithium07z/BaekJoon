import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int loop = Integer.parseInt(bfr.readLine());
		int arr[][] = new int[loop][2];
		int arrM[] = new int[loop];
		
		for (int i = 0; i < loop; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arrM[i] = 1;
		}
		
		for (int i = 0; i < loop; i++) {
			for (int j = 0; j < loop; j++) {
				if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
					arrM[j]++;
				}
			}
		}
		
		for (int value : arrM) {
			bfw.write(String.valueOf(value) + " ");
		}
		bfw.flush();
		bfw.close();
	}
}
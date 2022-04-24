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
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(bfr.readLine());
		int[] arr = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int min = 0;
		for (int i = 0; i < cnt; i++) {
			for (int j = i + 1; j < cnt; j++) {
				for (int k = j + 1; k < cnt; k++) {
					if (arr[i] + arr[j] + arr[k] > min && arr[i] + arr[j] + arr[k] <= max) {
						min = arr[i] + arr[j] + arr[k];
					}
				}
			}
		}
		bfw.write(String.valueOf(min));
		bfw.flush();
		bfw.close();
	}
}
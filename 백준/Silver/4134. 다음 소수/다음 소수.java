import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int caseNum = Integer.parseInt(bfr.readLine());
		Long arr[] = new Long[caseNum];

		for (int i = 0; i < caseNum; i++) {
			arr[i] = Long.parseLong(bfr.readLine());
			if (arr[i] == 0 || arr[i] == 1) {
				arr[i] = (long) 2;
			}
			for (int j = 2; j < (int) Math.sqrt(arr[i]) + 1;) {
				if (arr[i] % j == 0) {
					arr[i] = arr[i] + 1;
					j = 2;
					continue;
				}
				j++;
			}
		}
		for (Long value : arr) {
			bfw.write(String.valueOf(value) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int [5];
		int minH = 10000;
		int minD = 10000;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
			if (i < 3) {
				if (arr[i] < minH) {
					minH = arr[i];
				}
			} else {
				if (arr[i] < minD) {
					minD = arr[i];
				}
			}
		}
		bfw.write(String.valueOf(minH + minD - 50));
		bfw.flush();
		bfw.close();
	}
}
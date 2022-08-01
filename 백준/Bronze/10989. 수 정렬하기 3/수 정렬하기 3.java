import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int range = Integer.parseInt(bfr.readLine());
		int arr[] = new int[range];
		int counting[] = new int[10001];
		int result[] = new int[range];
		int count = 0;

		for (int i = 0; i < range; i++) { // 원본 배열 생성
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		
		for (int i = 0; i < range; i++) { // counting 배열 생성
			if (count < arr[i]) {
				count = arr[i];
			}
			counting[arr[i]]++;
		}
		
		for (int i = 0; i < count; i++) { // 누적합 배열로 변경
			counting[i + 1] += counting[i];
		}
		
		for (int i = range - 1; i >= 0; i--) {
			result[counting[arr[i]] - 1] = arr[i];
			counting[arr[i]] -= 1;
		}
		
		for (int a : result) {
			bfw.write(String.valueOf(a) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
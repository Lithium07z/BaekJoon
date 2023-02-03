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
		int size = Integer.parseInt(br.readLine());
		int A[] = new int[size];
		int B[] = new int[size];
		String result = "0";

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		if (Arrays.equals(A, B)) {
			result = "1";
		} else {
			for (int i = size; i > 1; i--) {
				for (int j = 0; j < i - 1; j++) {
					if (A[j] > A[j + 1]) {
						int temp = A[j];
						A[j] = A[j + 1];
						A[j + 1] = temp;
						if (A[j] == B[j]) {
							if (Arrays.equals(A, B)) {
								result = "1";
								break;
							}
						}
					}
				}
			}
		}
		bw.write(result);
		bw.flush();
		bw.close();
	}
}
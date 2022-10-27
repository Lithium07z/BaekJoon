import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int arr[][] = new int[node + 1][node + 1];
		int min = Integer.MAX_VALUE;
		int person = Integer.MAX_VALUE;
		
		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				if (i != j) {
					arr[i][j] = 1000000000;
				}
			}
		}

		for (int i = 1; i <= edge; i++) {
			st = new StringTokenizer(bfr.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A][B] = 1;
			arr[B][A] = 1;
		}

		for (int i = 1; i <= node; i++) {
			for (int j = 1; j <= node; j++) {
				for (int k = 1; k <= node; k++) {
					if (arr[j][k] > arr[j][i] + arr[i][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}

		for (int i = 1; i <= node; i++) {
			int temp = 0;
			for (int j = 1; j <= node; j++) {
				temp += arr[i][j];
			}
			if (min > temp) {
				min = temp;
				person = i;
			} else if (min == temp && person > i) {
				person = i;
			}
		}

		bfw.write(String.valueOf(person));
		bfw.flush();
		bfw.close();
	}
}
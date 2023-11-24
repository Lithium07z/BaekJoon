import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		DFS("", N);

		bw.flush();
		bw.close();
	}

	public static void DFS(String str, int N) {
		if (str.length() == N) {
			System.out.println(str);
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			if (Check(str + i)) {
				DFS(str + i, N);
			}
		}
	}

	public static boolean Check(String str) {
		for (int i = 1; i <= str.length() / 2; i++) {
			if (str.substring(str.length() - 2 * i, str.length() - i)
					.equals(str.substring(str.length() - i, str.length()))) {
				return false;
			}
		}
		return true;
	}
}
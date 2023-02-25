import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int idx[] = new int[N - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N - 1; i++) {
			idx[i] = i;
		}
		
		if (N * (N - 1) / 2 < K) {
			bw.write("-1");
			bw.flush();
			bw.close();
			return;
		}
		
		while (idx.length > 0) {
			int tempIdx[] = new int[idx.length];
			int p = 0;
			
			for (int idxP : idx) {
				if (A[idxP] > A[idxP + 1]) {
					int temp = A[idxP];
					A[idxP] = A[idxP + 1];
					A[idxP + 1] = temp;
					if (--K == 0) {
						bw.write(A[idxP] + " " + A[idxP + 1]);
						bw.flush();
						bw.close();
						return;
					}
					if (idxP > 0) {
						tempIdx[p++] = idxP - 1;
					}
				}
			}
			
			idx = new int[p];
			for (int i = 0; i < p; i++) {
				idx[i] = tempIdx[i];
			}
		}
		bw.write("-1");
		bw.flush();
		bw.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int inorder[];
	static int postorder[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		inorder = new int[N];
		postorder = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		buildPreOrder(0, N - 1, 0, N - 1);
		bw.flush();
		bw.close();
	}

	public static void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
		if (inStart <= inEnd && postStart <= postEnd) {
			bw.write(postorder[postEnd] + " ");
			
			int root = inStart;
			for (int i = inStart; i <= inEnd; i++) {
				if (inorder[i] == postorder[postEnd]) {
					root = i;
					break;
				}
			}
			buildPreOrder(inStart, root - 1, postStart, postStart + root - inStart - 1);
			buildPreOrder(root + 1, inEnd, postStart + root - inStart, postEnd - 1);
		}
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int nFibCount = 1;
	static int dpFibCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int size = Integer.parseInt(bfr.readLine());
		int arr[] = new int[size + 1];
		
		nomalFib(size);
		dpFib(size, arr);
		System.out.println(nFibCount + " " + dpFibCount);
	}
	
	public static int nomalFib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			nFibCount++;
			return nomalFib(n - 1) + nomalFib(n - 2);
		}
	}
	
	public static int dpFib(int n, int arr[]) {
		arr[1] = arr[2] = 1;
		for (int i = 3; i <= n; i++) {
			dpFibCount++;
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}
}
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		short n = Short.parseShort(st.nextToken());
		short l = Short.parseShort(st.nextToken());
		short a[] = new short[n];
		st = new StringTokenizer(br.readLine());
		for (short i = 0; i < n; i++) {
			a[i] = Short.parseShort(st.nextToken());
		}
		Arrays.sort(a);
		bw.write(a[n - l] + "\n");
		bw.flush();
		bw.close();
	}
}
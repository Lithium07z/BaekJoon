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
		long max = Long.parseLong(st.nextToken());
		long min = Long.parseLong(st.nextToken());
		long mp = max * min;
		
		if (max < min) {
			long temp = min;
			min = max;
			max = temp;
		}
		
		while (min != 0) {
			long t = max % min;
			max = min;
			min = t;
		}
		
		bw.write(mp / max + "\n");
		bw.flush();
		bw.close();
	}
}
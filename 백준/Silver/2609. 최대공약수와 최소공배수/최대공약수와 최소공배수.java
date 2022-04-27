import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int max = Integer.parseInt(st.nextToken());
		int min = Integer.parseInt(st.nextToken());
		int multipli = max * min;
		if (max < min) {
			int temp = min;
			min = max;
			max = temp;
		}
		
		while (min != 0) {
			int temp = max % min;
			max = min;
			min = temp;
		}
		bfw.write(String.valueOf(max) + "\n");
		bfw.write(String.valueOf(multipli / max));
		bfw.flush();
		bfw.close();
	}
}
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
		int value = Integer.parseInt(bfr.readLine());
		String arr[] = new String[value];
		
		for (int i = 0; i < value; i++) {
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
			arr[i] = String.valueOf(multipli / max);
		}
		
		for (int i = 0; i < value; i++) {
			bfw.write(arr[i] + "\n");
		}	
		bfw.flush();
		bfw.close();
	}
}
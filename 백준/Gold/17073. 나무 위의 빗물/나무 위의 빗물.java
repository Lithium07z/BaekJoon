import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		int count = Integer.parseInt(st.nextToken());
		double water = Double.parseDouble(st.nextToken());
		int arr[] = new int[count + 1];
		double leaf = 0;
		
		for (int i = 0; i < count - 1; i++) {
			st = new StringTokenizer(bfr.readLine());
			arr[Integer.parseInt(st.nextToken())] += 1;
			arr[Integer.parseInt(st.nextToken())] += 1;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i != 1 && arr[i] == 1) {
				leaf += 1;
			}
		}
		
		bfw.write(String.valueOf(water / leaf));
		bfw.flush();
		bfw.close();
	}
}
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
		int[] arrX = new int[3];
		int[] arrY = new int[3];
		int checker = 0;
		int checker2 = 0;
		int count = 0;
		int count2 = 0;
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			arrX[i] = Integer.parseInt(st.nextToken());
			arrY[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 3; i++) {
			if (arrX[i] != arrX[0]) {
				checker = arrX[i];
			} else {
				count++;
			} 
			if (arrY[i] != arrY[0]) {
				checker2 = arrY[i];
			} else {
				count2++;
			}
		}
		if (count == 1) {
			x = arrX[0];
		} else {
			x = checker;
		}
		if (count2 == 1) {
			y = arrY[0];
		} else {
			y = checker2;
		}
		System.out.println(x + " " + y);
	} 
}
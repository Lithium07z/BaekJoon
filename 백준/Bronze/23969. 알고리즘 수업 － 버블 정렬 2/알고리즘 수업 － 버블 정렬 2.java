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
		
		int arr[] = new int[Integer.parseInt(st.nextToken())];
		int checkNum = Integer.parseInt(st.nextToken());
		int countNum = 0;
		
		st = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Loop1 :
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					countNum++;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				if (countNum == checkNum) {
					for (int result : arr) {
						bfw.write(result + " ");
					}
					break Loop1; 
				}
			}
		}
		if (countNum < checkNum) {
			bfw.write("-1");
		}
		bfw.flush();
		bfw.close();
	}
}
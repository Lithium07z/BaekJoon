import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bfr.readLine());
		String[][] arr = new String[num][2];
		
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] str1, String[] str2) {
				return Integer.parseInt(str1[0]) - Integer.parseInt(str2[0]);
			}
		});
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 2; j++) {
				bfw.write(arr[i][j] + " ");
			}
			bfw.write("\n");	
		}
		bfw.flush();
		bfw.close();	
	}
}
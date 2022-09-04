import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(bfr.readLine());
		int arr[] = new int[size];
		int index = 0;
		int last = 0;
		
		for (int i = 0; i < size; i++) {
			int value = Integer.parseInt(bfr.readLine());
			if (value > last) {
				for (int j = last + 1; j <= value; j++) {
					arr[index++] = j;
					sb.append("+").append("\n");
				}
				last = value;
			} else if (arr[index - 1] != value) {
				System.out.println("NO");
				return;
			}
			index--;
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}
}
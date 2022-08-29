import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = bfr.readLine();
		
		int arr[] = new int[26];
		
		for (int i = 0; i < word.length(); i++) {
			arr[word.charAt(i) - 'a']++;
		}
		
		for (int result : arr) {
			System.out.print(result + " ");
		}
	}
}
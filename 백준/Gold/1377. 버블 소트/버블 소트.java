import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
			map1.put(arr[i], i);
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			map2.put(arr[i], i);
		}
		
		for (int i = 0; i < N; i++) {
			if (map1.get(arr[i]) - map2.get(arr[i]) > max) {
				max = map1.get(arr[i]) - map2.get(arr[i]);
			}
		}
		bw.write(++max + "\n");
		bw.flush();
		bw.close();
	}
}
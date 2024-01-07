import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Homework homework[] = new Homework[N];
		int arr[] = new int[1000];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			homework[i] = new Homework(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(homework);
		
		for (int i = 0; i < N; i++) {
			for (int j = homework[i].d; j >= 0; j--) {
				if (arr[j] == 0) {
					arr[j] = homework[i].w;
					break;
				}
			}
		}
		
		for (int t : arr) { 
			sum += t;
		}
		
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}

class Homework implements Comparable<Homework> {
	int d;
	int w;
	
	public Homework (int d, int w) { 
		this.d = d;
		this.w = w;
	}
	
	@Override
	public int compareTo(Homework o) {
		return o.w - this.w;
	}
}

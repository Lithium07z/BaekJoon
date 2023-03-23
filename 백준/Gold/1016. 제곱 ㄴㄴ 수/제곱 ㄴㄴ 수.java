import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		int arr[] = new int[1000001];
		long count = 0;
		
		for (long i = 2; i <= Math.sqrt(max); i++) {
			long snum = i * i; 
			for (long j = (long) (Math.ceil((double)min / snum) * snum); j <= max; j += snum) {
				// min이 제곱수로 나뉘어 지는 수라면 Math.ceil(min / snum) * snum == min
				// min이 제곱수로 나뉘어지지 않는 수라면 Math.ceil(min / snum) * snum > min
				arr[(int) (j - min)] = 1;
				// 제곱수로 나뉘어 지는 모든 수를 1로 변경
			}
		}
		
		for (long i = min; i <= max; i++) {
			if (arr[(int) (i - min)] == 1) {
				count++;
			}
		}
		
		bw.write(max - min - count + 1 + "\n");
		bw.flush();
		bw.close();
	}
}
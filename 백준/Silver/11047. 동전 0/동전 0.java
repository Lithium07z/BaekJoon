import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bfr.readLine());
		
		int[] arr = new int[Integer.parseInt(st.nextToken())];
		int value = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(bfr.readLine());
		}
		calc(arr.length, value, arr);
	}
	
	public static void calc(int size, int value, int[] arr) throws IOException {
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		int fixedValue = value; // 나눠야 할 값을 저장할 변수
		
		for (int i = size - 1; i >= 0; i--) {
			if (value % arr[i] == value) { // 나누려는 돈이 더 큰 경우
				continue; // 스킵
			} else { // 입력값과 같은 자릿수의 돈인 경우
				count += value / arr[i];
				value = value % arr[i];
			}
		}
		if (value != 0) { // value가 0이 아니면 잘못된 값으로 나눈 것이므로 
			calc(size - 1, fixedValue, arr); // 한단계 아래 크기의 돈으로 다시 나눠봄 
		} else {
			bfw.write(String.valueOf(count)); // 아니면 출력 
			bfw.flush();
			bfw.close();
		}
	}
}

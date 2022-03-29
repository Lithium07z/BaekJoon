import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine()); // 배열 사이즈
		int arr[] = new int[size]; // 배열 생성
		StringTokenizer st = new StringTokenizer(bfr.readLine()); // 받은 입력값을 토큰으로 쪼갬

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // int형 변환시켜서 배열에 삽입
		}
		int sum = 0;
		int count = 0;
		Arrays.sort(arr);
		for (int k = 0; k < arr.length; k++) {
			for (int j = 0; j <= k; j++) {
				sum += arr[j];
			}
		}
		System.out.println(sum);
	}
}
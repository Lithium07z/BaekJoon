import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int before = Integer.parseInt(bfr.readLine());
		int after = Integer.parseInt(bfr.readLine());
		int sum = 0; // 누적합
		int min = after; // 범위 내 소수 최솟값
		int count = 0; // 소수 판별용 숫자

		while (before <= after) { // before를 1씩 증가시키면서 검사하고 after까지오면 종료
			for (int i = 2; i <= before - 1; i++) { // 소수는 1과 자기자신 이외의 수로 나뉘어지면 안되니까
				if (before % i == 0) { // 나눠지면 소수가 아닌경우
					count++; // 카운트 증가로 소수임을 판별
					break;
				}
			}
			if (count == 0 && before > 1) { // 카운트가 0일 때(소수일 때), before가 1 이상일 때(1일때 통과못하게)
				if (before <= min) { // min보다 before가 작으면
					min = before; // min값 갱신 
				}
				sum += before; // sum에 소수값 누적 
			}
			count = 0; // 카운트 초기화
			before++; // before 증가
		}
		if (sum == 0) { // 1인 경우 
			bfw.write("-1"); // -1
			bfw.flush();
			bfw.close();
		} else {
			bfw.write(String.valueOf(sum) + "\n" + String.valueOf(min));
			bfw.flush();
			bfw.close();
		}
	}
}
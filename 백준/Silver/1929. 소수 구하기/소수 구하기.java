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
		int before = Integer.parseInt(st.nextToken());
		int after = Integer.parseInt(st.nextToken());
		int count = 0;

		while (before <= after) { // before를 1씩 증가시키면서 검사하고 after까지오면 종료
			if (before == 2) { // 2인경우
				bfw.write("2\n"); // 2출력 
			} else if (before == 3) { // 3인경우
				bfw.write("3\n"); //3출력
			}
			for (int i = 2; i <= (int) Math.sqrt(before); i++) { //에라토스테네스의 체를 이용해서 범위를 끝 값의 제곱근으로 축소
				if (before % i == 0) { // 나눠지면 소수가 아닌경우
					break;
				} else if (i == (int) Math.sqrt(before)) { // 같으면 나눠지지 않고 i가 before크기까지 +되었다는 거니까 소수임
					bfw.write(before + "\n"); // 출력
					count++;
				}
			}
			count = 0; // 카운트 초기화
			before++; // before 증가
		}
		bfw.flush();
		bfw.close();
	}
}
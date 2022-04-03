import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> lt = new ArrayList<Integer>(); // 0이 들어올 때 까지 값을 저장할 가변적인 저장공간이 필요

		while (true) { // 계속 받는다
			int num = Integer.parseInt(bfr.readLine());
			if (num == 0) { // 입력값으로 0이 들어올 때 까지
				break; // 들어오면 끝
			} else { // 아니면 계속 받기
				lt.add(num); // 마지막 0을 제외한 입력값들을 리스트에 넣음 
			}
		}
		for (int i = 0; i < lt.size(); i++) {
			cal(lt.get(i)); // cal 메소드에 리스트값 하나씩 전달
		}
		bfw.close();
	}

	public static void cal(int value) throws IOException {
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int before = value + 1; // 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고
		int after = value * 2; // 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
		int sum = 0; // 누적값 저장
		
		while (before <= after) { // before를 1씩 증가시키면서 검사하고 after까지오면 종료
			if (before == 2) { // 2인경우
				sum += 1;
			} else if (before == 3) { // 3인경우
				sum += 1;
			}
			for (int i = 2; i <= (int) Math.sqrt(before); i++) { // 에라토스테네스의 체를 이용해서 범위를 끝 값의 제곱근으로 축소
				if (before % i == 0) { // 나눠지면 소수가 아닌경우
					break;
				} else if (i == (int) Math.sqrt(before)) { // 같으면 나눠지지 않고 i가 before크기까지 +되었다는 거니까 소수임
					sum += 1;
				}
			}
			before++; // before 증가
		}
		bfw.write(String.valueOf(sum) + "\n");
		bfw.flush();
	}
}
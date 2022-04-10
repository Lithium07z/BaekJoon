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
		int loop = Integer.parseInt(bfr.readLine());
		int[] prt = new int [loop];
		int x1;
		int x2;
		int y1;
		int y2;
		int r1;
		int r2;
		
		for (int i = 0; i < loop; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			if (x1 == x2 && y1 == y2 && r1 == r2) { // 두 원이 완벽히 겹쳐져 접점이 무한한 경우
				prt[i] = -1;
				continue;
			} else if ((x1 - x2) * (x1 - x2) + (y1- y2) * (y1 - y2) > (r1 + r2) * (r1 + r2)) { // 두 원의 중점사이의 거리가 두 점의 반지름의 합보다 커서 접점이 없는 경우
				prt[i] = 0;
				continue;
			} else if ((x1 - x2) * (x1 - x2) + (y1- y2) * (y1 - y2) < (r1 - r2) * (r1 - r2)) { // 한 원이 다른 원의 내부에 있어 접점이 없는 경우
				prt[i] = 0;
				continue;
			} else if ((x1 - x2) * (x1 - x2) + (y1- y2) * (y1 - y2) == (r1 - r2) * (r1 - r2)) { // 한 원이 다른 원의 내부에서 내접하는 경우
				prt[i] = 1;
				continue;
			} else if ((x1 - x2) * (x1 - x2) + (y1- y2) * (y1 - y2) == (r1 + r2) * (r1 + r2)) { // 두 원이 외접하는 경우 
				prt[i] = 1;
				continue;
			} else { // 점접이 2개인 경우 
				prt[i] = 2;
				continue;
			}
 		}
		for (int a : prt) {
			bfw.write(String.valueOf(a) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}
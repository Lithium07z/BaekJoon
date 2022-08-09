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
		int num = Integer.parseInt(bfr.readLine());

		Point[] ptarr = new Point[num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(bfr.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ptarr[i] = new Point(x, y);

		}
		Arrays.sort(ptarr);
		
		for (int i = 0; i < num; i++) {
			bfw.write(String.valueOf(ptarr[i].x) + " " + String.valueOf(ptarr[i].y) + "\n");
		}
		bfw.flush();
		bfw.close();
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point pt) {
		if (this.x > pt.x) {
			return 1;
		} else if (this.x == pt.x) {
			if (this.y > pt.y) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
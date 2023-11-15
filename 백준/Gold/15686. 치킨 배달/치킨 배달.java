import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Point> home = new LinkedList<Point>();
	static LinkedList<Point> chicken = new LinkedList<Point>();
	static LinkedList<Point> position = new LinkedList<Point>();
	static int result = Integer.MAX_VALUE;
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				
				if (v == 1) {
					home.add(new Point(i, j));
				} else if (v == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		
		Select(M, 0);
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}
	
	public static void Select(int M, int cnt) {
		if (position.size() == M) {
			int t = 0;
			
			for (Point pt1 : home) {
				int c = Integer.MAX_VALUE;
				
				for (Point pt2 : position) {
					c = Math.min(c, Math.abs(pt2.x - pt1.x) + Math.abs(pt2.y - pt1.y));
				}
				
				t += c;
			}
			
			result = Math.min(t, result);
			return;
		}
		
		for (int i = cnt; i < chicken.size(); i++) {
			position.add(chicken.get(i));
			Select(M, i + 1);
			position.removeLast();
		}
	}
}
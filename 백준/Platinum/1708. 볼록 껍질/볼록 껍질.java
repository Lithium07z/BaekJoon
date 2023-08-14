import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static final double PI = 3.141592;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stk = new Stack<Integer>();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int nxt = 2;
		Point[] arr = new Point[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(arr, (o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);
		
		arr[0].ang = 0;
		
		for (int i = 1; i < N; i++) { 
			arr[i].ang = Angle(arr[i].x - arr[0].x, arr[i].y - arr[0].y);
		}
		
		Arrays.sort(arr, (o1, o2) -> (o1.ang - o2.ang == 0)? 0 : ((o1.ang - o2.ang > 0)? 1 : -1));
		
		stk.add(0);
		stk.add(1);
		
		while (nxt < N) { 
			while (stk.size() >= 2) {
				int first = stk.pop();
				int second = stk.peek();
				
				if (CCW(arr[second], arr[first], arr[nxt]) > 0) {
					stk.add(first);
					break;
				}
			}
			
			stk.add(nxt++);
		}
		
		bw.write(stk.size() + "\n");
		bw.flush();
		bw.close();
	}
	
	public static double Angle(int dx, int dy) {
		double radian;
		
		if (dx == 0 && dy == 0) {
			return 0;
		}
		
		if (dy == 0) {
			if (dx > 0) {
				return 0;
			} else {
				return 180;
			}
		}
		
		if (dx == 0) {
			if (dy > 0) {
				return 90.0;
			} else {
				return 270.0;
			}
		}
		
		if (dx > 0) {
			if (dy > 0) {
				radian = Math.atan((double)dy / dx);
				return (radian * 180.0) / PI;
			} else {
				radian = Math.atan((double)dy / dx) + (2 * PI);
				return (radian * 180.0) / PI;
			}
		} else {
			radian = Math.atan((double)dy / dx) + PI;
			return (radian * 180.0) / PI;
		}
	}
	
	public static int CCW(Point A, Point B, Point C) {
		Point v1 = new Point(B.x - A.x, B.y - A.y);
		Point v2 = new Point(C.x - A.x, C.y - A.y);
	
		long CP = (v1.x * v2.y) - (v1.y * v2.x);
		
		return Long.compare(CP, 0);
	}
}

class Point {
	int x;
	int y;
	double ang;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
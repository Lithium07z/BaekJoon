import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		BigInteger BAx = new BigInteger(String.valueOf(x1 - x2));
		BigInteger BAy = new BigInteger(String.valueOf(y1 - y2));
		BigInteger ACx = new BigInteger(String.valueOf(x3 - x1));
		BigInteger ACy = new BigInteger(String.valueOf(y3 - y1));
		BigInteger ADx = new BigInteger(String.valueOf(x4 - x1));
		BigInteger ADy = new BigInteger(String.valueOf(y4 - y1));
		BigInteger CDx = new BigInteger(String.valueOf(x4 - x3));
		BigInteger CDy = new BigInteger(String.valueOf(y4 - y3));
		BigInteger DAx = new BigInteger(String.valueOf(x1 - x4));
		BigInteger DAy = new BigInteger(String.valueOf(y1 - y4));
		BigInteger DBx = new BigInteger(String.valueOf(x2 - x4));
		BigInteger DBy = new BigInteger(String.valueOf(y2 - y4));
		BigInteger zero = new BigInteger("0");
		
		if (((BAx.multiply(ACy)).subtract(BAy.multiply(ACx))).multiply((BAx.multiply(ADy)).subtract(BAy.multiply(ADx))).compareTo(zero) == -1 &&
				((CDx.multiply(DAy)).subtract(CDy.multiply(DAx))).multiply((CDx.multiply(DBy)).subtract(CDy.multiply(DBx))).compareTo(zero) == -1) {
			bw.write("1");
		} else {
			bw.write("0");
		}
		
		bw.flush();
		bw.close();
	}
}
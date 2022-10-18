import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		Heap h = new Heap(size);
		
		for (int i = 0; i < size; i++) {
			int temp = Integer.parseInt(bfr.readLine()); 
			if (temp == 0) {
				if (h.getSize() == 0) {
					bfw.write("0\n");
				} else {
					bfw.write(String.valueOf(h.delete()) + "\n");
				}
			} else {
				h.insert(temp);
			}
		}
		bfw.flush();
		bfw.close();
	}
}

class Heap {
	private int count;
	private int size;
	private int[] itemArray;

	public Heap(int size) {
		count = 0;
		this.size = size;
		itemArray = new int[size];
	}
	
	public int getSize() {
		return this.size;
	}

	public void insert(int newItem) {
		count += 1;
		int i = count;
		
		while(true) {
			if (i == 1) {
				itemArray[1] = newItem;
				break;
			}
			if (newItem <= itemArray[i / 2]) {
				itemArray[i] = newItem;
				break;
			} else {
				itemArray[i] = itemArray[i / 2];
			}
			i /= 2;
		}
		itemArray[i] = newItem;
	}

	public int delete() {
		if (count == 0) {
			return 0;
		}
		int item = itemArray[1];
		int temp = itemArray[count];
		count -= 1;
		
		int i = 1;
		int j = 2;
		
		while (j <= count) {
			if (j < count && itemArray[j] < itemArray[j + 1]) {
				j += 1;
			}
			if (temp >= itemArray[j]) {
				break;
			} 
			itemArray[i] = itemArray[j];
			i = j;
			j *= 2;
		}
		itemArray[i] = temp;
		return item;
	}
}
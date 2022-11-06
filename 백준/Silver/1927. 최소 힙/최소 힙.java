import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(bfr.readLine());
		MinHeap mh = new MinHeap(size);

		for (int i = 0; i < size; i++) {
			int temp = Integer.parseInt(bfr.readLine());
			if (temp == 0) {
				bfw.write(String.valueOf(mh.delete()) + "\n");
			} else {
				mh.insert(temp);
			}
		}
		bfw.flush();
		bfw.close();
	}
}

class MinHeap {
	private int count;
	private int size;
	private int[] itemArray;

	public MinHeap(int size) {
		count = 0;
		this.size = size;
		itemArray = new int[size];
	}

	public MinHeap(int[] origArray) {
		count = origArray.length - 1;
		size = count + 1;
		itemArray = origArray;
		int childLoc;
		int currentLoc;
		for (currentLoc = count / 2; currentLoc > 0; currentLoc--) {
			childLoc = currentLoc * 2;
			while (childLoc <= count) {
				if (childLoc < count) {
					if (itemArray[childLoc + 1] < itemArray[childLoc])
						childLoc++;
				}
				if (itemArray[currentLoc] <= itemArray[childLoc])
					break; // ??
				else {
					int temp = itemArray[currentLoc];
					itemArray[currentLoc] = itemArray[childLoc];
					itemArray[childLoc] = temp;
					currentLoc = childLoc;
					childLoc = currentLoc * 2;
				} // else
			} // while
		} // for
	}

	public void insert(int newItem) {
		if (count >= size - 1) {
			System.out.println();
			return;
		}
		count++;
		int childLoc = count;
		int parentLoc = childLoc / 2;
		while (parentLoc != 0) {
			if (newItem >= itemArray[parentLoc]) {
				itemArray[childLoc] = newItem;
				return;
			} else {
				itemArray[childLoc] = itemArray[parentLoc];
				childLoc = parentLoc;
				parentLoc = childLoc / 2;
			}
		}
		itemArray[childLoc] = newItem;
	}

	public int delete() {
		if (count == 0) {
			return 0;
		} else {
			int currentLoc;
			int childLoc;
			int itemToMove;
			int deletedItem;
			deletedItem = itemArray[1];
			itemToMove = itemArray[count--];
			currentLoc = 1;
			childLoc = 2 * currentLoc;
			while (childLoc <= count) {
				if (childLoc < count) {
					if (itemArray[childLoc + 1] < itemArray[childLoc])
						childLoc++;
				}
				if (itemArray[childLoc] < itemToMove) {
					itemArray[currentLoc] = itemArray[childLoc];
					currentLoc = childLoc;
					childLoc = 2 * currentLoc;
				} else {
					itemArray[currentLoc] = itemToMove;
					return deletedItem;
				}
			} // while
			itemArray[currentLoc] = itemToMove;
			return deletedItem;
		} // else
	}
}
class Solution {
    public String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		long[] arr = new long[numbers.length];
		long[] result = new long[numbers.length];
		
		for (int i = 0; i < arr.length; i++) {
			result[i] = numbers[i];
			sb.append(result[i]);
			while (sb.length() < 10) {
				sb.append(sb);
			}
			arr[i] = Long.parseLong(sb.substring(0, 10));
			sb.setLength(0);
		}
		
		quickSort(arr, result);
		
		for (long temp : result) {
			sb.append(temp);
		}
		 
		if (sb.charAt(0) == '0') {
			return "0";
		} else {
			return sb.toString();
		}
	}
	
	public static void quickSort(long[] a, long[] b) {
		theQuickSort(a, b, 0, a.length - 1);
	}
	
	private static void theQuickSort(long[] a, long[] b, int left, int right) {
		int p;
		if (left > right) {
			return;
		}
		p = partition(a, b, left, right);
		theQuickSort(a, b, left, p - 1);
		theQuickSort(a, b, p + 1, right);
	}
	
	private static int partition(long[] a, long[] b, int i, int j) {
		int middle = (i + j) / 2;
		long pivot = a[middle];
		int p;
		swap(a, middle, i);
		swap(b, middle, i);
		p = i;
		for (int k = i + 1; k <= j; k++) {
			if (a[k] > pivot) {
				p++;
				swap(a, p, k);
				swap(b, p ,k);
			}
		}
		swap(a, i, p);
		swap(b, i, p);
		return p;
	}
	
	private static void swap(long[] a, int j, int k) {
		long temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}
}


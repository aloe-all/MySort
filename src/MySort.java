import java.util.Arrays;

public class MySort {

	public static void main(String[] args) {
		int[] numbers = {70,8,22,60,26};
//		insertionSort(numbers);
//		Arrays.sort(numbers);
//		bubbleSort(numbers);
		selectionSort(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println("=======================");
//		System.out.println(binarySearch(numbers, 8));
		System.out.println(binarySearchRecursion(numbers, 8, 0, (numbers.length - 1)));
	}
	
//	/**
//	 *  插入排序
//	 * @param numbers
//	 */
//	private static void insertionSort(int[] numbers){
//		int size = numbers.length;
//		int tem = 0;
//		int j = 0;
//		for (int i = 0; i < size; i++) {
//			tem = numbers[i];
//			for(j = i; j > 0 && numbers[j] < numbers[j - 1]; j--){
//				numbers[j] = numbers[j - 1];
//			}
//			numbers[j] = tem;
//		}
//	}
//	
//	/**
//	 *  冒泡排序
//	 * @param numbers
//	 */
//	private static void bubbleSort(int[] numbers){
//			for (int i = 0; i < numbers.length -1; i++) {
//				for (int j = i; j < numbers.length - i - 1; j++) {
//					if (numbers[j] > numbers[j + 1]) {
//						int tem = numbers[j + 1];
//						numbers[j + 1] = numbers[j];
//						numbers[j] = tem;
//					}
//				}
//			}
//		}
	
	private static void insertionSort(int[] numbers){
		for (int i = 0; i < numbers.length; i++) {
			int tem = numbers[i];
			int j = 0;
			for (j = i; j > 0 && numbers[j] < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = tem;
		}
	}
	
	private static void bubbleSort(int[] numbers){
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int tem = numbers[j + 1];
					numbers[j + 1] = numbers[j];
					numbers[j] = tem;
				}
			}
		}
	}
	
	/**
	 *  选择排序
	 * @param numbers
	 */
	private static void selectionSort(int[] numbers){
		for (int i = 0; i < numbers.length; i++) {
			
			//最小值下标
			int min = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[min] > numbers[j]) {
					min = j;
				}
			}
			if (min != i) {
				int tem = numbers[i];
				numbers[i] = numbers[min];
				numbers[min] = tem;
			}
		}
	}
	
	/**
	 *  二分法查找 循环实现
	 * @param numbers
	 * @param x
	 * @return
	 */
	private static int binarySearch(int[] numbers, int x){
		int low = 0;
		int high = numbers.length - 1;
		
		
		while(low <= high){
			int middle = (low + high)/2;
			if (x == numbers[middle]) {
				return middle;
			} else if (x < numbers[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			} 
		}
		return -1;
	}
	
	/**
	 *  二分法查找 递归实现
	 * @param numbers
	 * @param x
	 * @param low
	 * @param high
	 * @return
	 */
	private static int binarySearchRecursion(int[] numbers, int x, int low, int high){
		int middle = (low + high)/2;
		if (x < numbers[low] || x > numbers[high] || low > high) {
			return -1;
		}
		if (x < numbers[middle]) {
			return binarySearchRecursion(numbers, x, low, middle - 1);
		} else if (x > numbers[middle]) {
			return binarySearchRecursion(numbers, x, middle + 1,  high);
		} else {
			return middle;
		}
	}
}

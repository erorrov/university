import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class SortingArrays {

	private static int MAX_ALLOWED_NUMBER = 99;

	public static void main(final String[] args) {
		final Scanner input = new Scanner(System.in);

		System.out.print("Array length: ");
		final int[] array = getRandomArray(input.nextInt());

		printArray("Source array", array);
		printArray("Bubble sort", bubbleSort(array));
		printArray("Selection sort", selectionSort(array));
		printArray("Insertion sort", insertionSort(array));
	}


	private static int[] getRandomArray(final int len) {
		final Random rand = new Random();
		final int[] randomArray = new int[len];

		for (int i = 0; i < randomArray.length; ++i) {
			randomArray[i] = rand.nextInt(MAX_ALLOWED_NUMBER);
		}

		return randomArray;
	}


	private static void printArray(final String caption, final int[] array) {
		System.out.print(caption + ":\t\t");

		for (final int elem : array) {
			System.out.print(elem + "\t");
		}

		System.out.println();
	}


	private static int[] bubbleSort(final int[] sArray) {
		int[] bblArray = copyOf(sArray, sArray.length);
		int tmp;

		for (int i2 = 0; i2 < bblArray.length; i2++) {
			for (int i = 0; i < bblArray.length - 1; i++) {
				if (bblArray[i] > bblArray[i + 1]) {
					tmp = bblArray[i];
					bblArray[i] = bblArray[i + 1];
					bblArray[i + 1] = tmp;
				}
			}
		}

		return bblArray;
	}


	private static int[] selectionSort(final int[] sArray){
		int[] slcArray = copyOf(sArray, sArray.length);
		int tmp, min;

		for (int i = 0; i < slcArray.length-1; i++) {
			min = i;

			for (int i2 = i+1; i2 < slcArray.length; i2++) {
				if (slcArray[i2] < slcArray[min]) { min = i2; }
			}

			tmp = slcArray[min];
			slcArray[min] = slcArray[i];
			slcArray[i] = tmp;
		}

		return slcArray;
	}


	private static int[] insertionSort(final int[] sArray) {
		int[] insArray = copyOf(sArray, sArray.length);
		int tmp;

		for (int i2 = 0; i2 < insArray.length; i2++) {
			for (int i = 0; i < insArray.length; i++) {
				if (insArray[i2] < insArray[i]) {
					tmp = insArray[i];
					insArray[i] = insArray[i2];
					insArray[i2] = tmp;
				}
			}
		}

		return insArray;
	}
}

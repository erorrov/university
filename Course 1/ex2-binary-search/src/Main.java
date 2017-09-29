import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class Main {

    private static int MAX_ALLOWED_NUMBER = 99;

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.print("Array length: ");
        final int[] array = bubbleSort(getRandomArray(input.nextInt()));
        printArray("Array", array);

        System.out.print("To find: ");
        search(array, input.nextInt());
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


    private static void search(final int[] array, final int search) {
        int startBound = 0;
        int endBound = array.length;
        int middle = 0;

        while (true) {
            middle = (endBound + startBound) / 2;
            if (array[middle] == search) {
                System.out.println("FOUND, i = " + middle);
                break;
            } else if (array[middle] < search) {
                startBound = middle;
            } else if (array[middle] > search) {
                endBound = middle;
            }
        }
    }
}
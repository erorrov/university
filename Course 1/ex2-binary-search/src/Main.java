import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class Main {

    private static int MAX_ALLOWED_NUMBER = 99;

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.print("Array length: ");
        final int[] array = getRandomArray(input.nextInt());
        System.out.println(Arrays.toString(array));

        System.out.print("To find: ");
        int result = search(array, input.nextInt());
        if (result == -1) {
            System.out.println("Nothing found");
        } else {
            System.out.println("i = " + result);
        }
    }


    private static int[] getRandomArray(final int len) {
        final Random rand = new Random();
        final int[] randomArray = new int[len];

        for (int i = 0; i < randomArray.length; ++i) {
            randomArray[i] = rand.nextInt(MAX_ALLOWED_NUMBER);
        }

        Arrays.sort(randomArray);
        return randomArray;
    }


    private static int search(final int[] array, final int search) {
        int startBound = 0;
        int endBound = array.length - 1;
        int middle = 0;

        while (endBound >= startBound) {
            middle = (endBound + startBound) / 2;
            if (array[middle] == search) {
                return middle;
            } else if (array[middle] < search) {
                startBound = middle + 1;
            } else if (array[middle] > search) {
                endBound = middle - 1;
            }
        }

        return -1;
    }
}
package ru.erorrov;

import java.util.Arrays;
import java.util.Random;

class ArrTools {
    private final Random rand = new Random();

    int[] randomArray(final int len, final int max) {
        final int[] randomArray = new int[len];

        for (int i = 0; i < randomArray.length; ++i) {
            randomArray[i] = rand.nextInt(max);
        }

        return randomArray;
    }

    void printArray(final String caption, final int[] array) {
        System.out.print(caption + ":\t");
        System.out.println(Arrays.toString(array));
    }
}

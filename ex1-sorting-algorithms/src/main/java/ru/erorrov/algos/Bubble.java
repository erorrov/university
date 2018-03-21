package ru.erorrov.algos;

import static java.util.Arrays.copyOf;

public class Bubble {

    public static int[] sort(final int[] array) {
        int[] tmpArray = copyOf(array, array.length);

        int tmp;
        for (int i2 = 0; i2 < tmpArray.length; i2++) {
            for (int i = 0; i < tmpArray.length - 1; i++) {
                if (tmpArray[i] > tmpArray[i + 1]) {
                    tmp = tmpArray[i];
                    tmpArray[i] = tmpArray[i + 1];
                    tmpArray[i + 1] = tmp;
                }
            }
        }

        return tmpArray;
    }

}

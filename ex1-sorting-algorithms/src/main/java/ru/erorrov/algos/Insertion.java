package ru.erorrov.algos;

import static java.util.Arrays.copyOf;

public class Insertion {

    public static int[] sort(final int[] array) {
        int[] tmpArray = copyOf(array, array.length);

        int tmp;
        for (int i2 = 0; i2 < tmpArray.length; i2++) {
            for (int i = 0; i < tmpArray.length; i++) {
                if (tmpArray[i2] < tmpArray[i]) {
                    tmp = tmpArray[i];
                    tmpArray[i] = tmpArray[i2];
                    tmpArray[i2] = tmp;
                }
            }
        }

        return tmpArray;
    }

}

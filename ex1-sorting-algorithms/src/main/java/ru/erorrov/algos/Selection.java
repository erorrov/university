package ru.erorrov.algos;

import static java.util.Arrays.copyOf;

public class Selection {

    public static int[] sort(final int[] array) {
        int[] tmpArray = copyOf(array, array.length);

        int min, tmp;
        for (int i = 0; i < tmpArray.length-1; i++) {
            min = i;

            for (int i2 = i+1; i2 < tmpArray.length; i2++) {
                if (tmpArray[i2] < tmpArray[min]) { min = i2; }
            }

            tmp = tmpArray[min];
            tmpArray[min] = tmpArray[i];
            tmpArray[i] = tmp;
        }

        return tmpArray;
    }

}

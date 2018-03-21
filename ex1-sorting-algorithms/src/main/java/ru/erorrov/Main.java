package ru.erorrov;

import ru.erorrov.algos.Bubble;
import ru.erorrov.algos.Insertion;
import ru.erorrov.algos.Selection;

import java.util.Scanner;

public class Main {

    private static int MAX_ALLOWED_NUMBER = 99;

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        System.out.print("Arrays length: ");
        int len = input.nextInt();

        ArrTools tools = new ArrTools();
        int[] randArray = tools.randomArray(len, MAX_ALLOWED_NUMBER);

        tools.printArray("Source array", randArray);
        System.out.print("\n");
        tools.printArray("Bubble sort", Bubble.sort(randArray));
        tools.printArray("Selection sort", Selection.sort(randArray));
        tools.printArray("Insertion sort", Insertion.sort(randArray));
    }
}

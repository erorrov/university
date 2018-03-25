#include <iostream>

int main() {
    //Исхоный массив
    int arr[] = {5, 72, 60, 16, 3, 9, 77, 10, 99};
    //Длина массива
    int arrLen = sizeof(arr) / sizeof(arr[0]);

    //Сортировка
    for (int n = 0; n < arrLen; n++) {
        //Слева направо
        for (int j = 0; j < arrLen - 1; j++) {
            if (arr[j] > arr[j+1]) {
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }

        //Справа налево
        for (int i = arrLen-1; i > 0; i--) {
            if (arr[i] < arr[i-1]) {
                int tmp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = tmp;
            }
        }
    }

    //Отображение массива
    for (int i = 0; i < arrLen; i++) {
        std::cout << arr[i] << "\t";
    }

    return 0;
}
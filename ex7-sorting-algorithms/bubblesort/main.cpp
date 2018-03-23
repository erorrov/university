#include <iostream>

int main() {
    //Исхоный массив
    int arr[] = {2, 28, 13, 37, 8, 80, 0, 55, 5, 53, 35};
    //Длина массива
    int arrLen = sizeof(arr) / sizeof(arr[0]);

    //Сортировка
    for (int i = 0; i < arrLen; i++) {
        for (int j = 0; j < arrLen - 1; j++) {
            if (arr[j] > arr[j+1]) {
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }

    //Отображение массива
    for (int i = 0; i < arrLen; i++) {
        std::cout << arr[i] << "\t";
    }

    return 0;
}
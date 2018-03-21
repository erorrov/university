#include <iostream>

int main() {
    //Исхоный массив
    int arr[] = {3, 1, 4, 15, 19, 2, 65, 35, 8, 9};
    //Длина массива
    int arrLen = sizeof(arr) / sizeof(arr[0]);

    //Сортировка
    for (int i = 0; i < arrLen; ++i) {
        if (i + 1 == arrLen) { break; }
        if (arr[i] > arr[i+1]) {
            int tmp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = tmp;
            i = 0;
        }
    }

    //Отображение массива
    for (int i = 0; i < arrLen; ++i) {
        std::cout << arr[i] << "\t";
    }

    return 0;
}
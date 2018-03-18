#include <iostream>

int main() {

    int r; //переменная со случайным числом
    srand(time(0)); //радомизация

    //Заполнение столбиков
    for (int i = 0; i < 10; i++) {
        //Заполнение строк
        for (int j = 0; j < 10; j++) {
            r = rand() % 10;
            std::cout << r << "\t";
        }
        //Перенос строки
        std::cout << std::endl;
    }

    return 0;
}

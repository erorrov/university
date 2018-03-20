#include <iostream>

int nestedLoops() {
    //Автоматическая рандомизация
    srand(time(0));

    //Вложенные циклы
    int r;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            r = rand() % 10;
            std::cout << r << "\t";
        }
        std::cout << std::endl;
    }

    return 0;
}

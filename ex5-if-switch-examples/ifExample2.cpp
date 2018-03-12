#include <iostream>
#include <cstdlib>

int main() {
    int randint = rand() % 100;
    int inpint;

    while (true) {
        std::cout << "Введите число: " << std::endl;
        std::cin >> inpint;
        if (inpint == randint) {
            std::cout << "Победа!" << std::endl;
            break;
        } else if (inpint > randint) {
            std::cout << "Загаданное число меньше, чем " << inpint << std::endl;
        } else if (inpint < randint) {
            std::cout << "Загаданное число больше, чем " << inpint << std::endl;
        }
    }

    return 0;
}
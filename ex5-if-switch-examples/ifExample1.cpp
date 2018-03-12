#include <iostream>

int main() {
    setlocale(LC_ALL, "Russian");

    int age;

    std::cout << "Сколько вам лет?" << std::endl;
    std::cin >> age;

    if (age < 18) {
        std::cout << "Вход на сайт воспрещен" << std::endl;
    } else {
        std::cout << "Добро пожаловать" << std::endl;
    }

    return 0;
}
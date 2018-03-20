#include <iostream>

int ifStatementExample() {
    //Кириллица в консоли
    setlocale(LC_ALL, "Russian");

    //Ввод возраста
    int age;
    std::cout << "Сколько вам лет?" << std::endl;
    std::cout << "Ввод: ";
    std::cin >> age;

    if (age < 18) {
        std::cout << "Вход на сайт воспрещен" << std::endl;
    } else {
        std::cout << "Добро пожаловать" << std::endl;
    }

    return 0;
}

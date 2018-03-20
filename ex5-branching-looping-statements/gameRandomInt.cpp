#include <iostream>
#include <cstdlib>
#include <random>
#include <ctime>

int gameRandomInt() {
    //Кириллица в консоли
    setlocale(LC_ALL, "Russian");

    //Отображение меню выбора сложности
    std::cout << "Необходимо выбрать сложность\n";
    std::cout << "1. Легкая (от 1 до 100)\n";
    std::cout << "2. Средняя (от 1 до 1000)\n";
    std::cout << "3. Сложная (от 1 до 10000)\n";

    //Ввод сложности с клавиатуры
    int selectedItem;
    std::cout << "Ввод: ";
    std::cin >> selectedItem;

    //Автоматическая рандомизация
    srand(time(0));

    //Установка рандомного числа в зависимости от выбранной сложности
    int randint;
    switch (selectedItem) {
        case 1:
            randint = rand() % 100;
            std::cout << "Выбрана легкая игра" << std::endl;
            break;

        case 2:
            randint = rand() % 1000;
            std::cout << "Выбрана средняя игра" << std::endl;
            break;

        case 3:
            randint = rand() % 10000;
            std::cout << "Выбрана сложная игра" << std::endl;
            break;

        default:
            std::cout << "Ты проиграл не начав игру :(" << std::endl;
            system("pause");
            return 0;
    }

    //Отгадывание числа
    int input;
    while (true) {
        std::cout << "Ввод: ";
        std::cin >> input;

        if (input == randint) {
            std::cout << "Победа!" << std::endl;
            break;
        } else if (input > randint) {
            std::cout << "Загаданное число меньше, чем " << input << std::endl;
        } else if (input < randint) {
            std::cout << "Загаданное число больше, чем " << input << std::endl;
        }
    }

    system("pause");
    return 0;
}

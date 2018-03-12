#include <iostream>
#include <cstdlib>
#include <random>
#include <ctime>

int main() {
    //Установка русского языка
    setlocale(LC_ALL, "Russian");

    //Отображение меню
    std::cout << "Необходимо выбрать сложность\n";
    std::cout << "1. Легкая (от 1 до 100)\n";
    std::cout << "2. Средняя (от 1 до 1000)\n";
    std::cout << "3. Сложная (от 1 до 10000)\n";

    int selectedItem; //выбранный пункт меню
    int randint;      //случайное число

    //Ввод уровня
    std::cout << "Ввод: ";
    std::cin >> selectedItem;

    //Автоматическая рандомизация
    srand(time(0));

    //Определение введенного уровня и генерация случайного числа
    switch (selectedItem) {

        //Если выбрана легкая игра
        case 1:
            randint = rand() % 100;
            std::cout << "Выбрана легкая игра" << std::endl;
            break;

            //Если выбрана средняя игра
        case 2:
            randint = rand() % 1000;
            std::cout << "Выбрана средняя игра" << std::endl;
            break;

            //Если выбрана сложная игра
        case 3:
            randint = rand() % 10000;
            std::cout << "Выбрана сложная игра" << std::endl;
            break;

            //Если введено что-то другое
        default:
            std::cout << "Ты проиграл не начав игру :(" << std::endl;
            return -1;
    }

    int input; //переменная с введенным числом

    //Бесконечный цикл с попыткой ввода
    while (true) {
        //Ввод числа с клавиатуры
        std::cout << "Ввод: ";
        std::cin >> input;

        //Подсказка
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

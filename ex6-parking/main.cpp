#include <iostream>

//Размеры парковки
const int xSize = 10;
const int ySize = 7;

//Массив с парковочными местами
bool places[ySize][xSize];


//Функция отображения парковочных мест
void showParking() {
    std::cout << "Таблица парковочных мест\n";

    for (int i = 0; i < ySize; i++) {
        std::cout << i + 1 << "-ый этаж:";

        for (int j = 0; j < xSize; ++j) {
            if (!places[i][j]) {
                std::cout << "\t" << j + 1 << " |";
            } else {
                std::cout << "\t" << "-" << " |";
            }
        }

        std::cout << std::endl;
    }
}


int main() {
    //Кириллица в консоли
    setlocale(LC_ALL, "Russian");

    //Отображение парковочных мест
    showParking();

    //Процесс бронирования
    int xInp, yInp;
    while (true) {
        std::cout << "Чтобы забронировать парковочное место, выберете этаж и место\n\n";
        std::cout << "Номер этажа: ";
        std::cin >> yInp;

        //Если этажа не существует
        if (yInp > ySize || yInp <= 0) {
            std::cout << "Нет такого этажа. Необходимо выбрать от 1" << " до " << ySize << "\n";
            continue;
        }

        std::cout << "Номер места: ";
        std::cin >> xInp;

        //Если места не существует
        if (xInp > xSize || xInp <= 0) {
            std::cout << "Нет такого места. Необходимо выбрать от 1" << " до " << xSize << "\n";
            continue;
        }

        //Проверка, занято ли место и само бронирование
        if (places[yInp-1][xInp-1] == 0) {
            places[yInp-1][xInp-1] = true;
            std::cout << "\nМесто успешно забронировано\n";
            std::cout << "Выбрано место #" << yInp << " на этаже " << xInp << "\n\n";

            showParking();
        } else {
            std::cout << "\nНе получилось забронировать, место уже занято\n\n";
        }

        std::cout << "Забронировать еще место? [1/0]: ";
        int exit;
        std::cin >> exit;

        if (exit != 1) {
            std::cout << "Процесс бронирования завершен";
            break;
        }
    }

    return 0;
}
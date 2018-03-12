#include <iostream>
#include <ctime>

int main() {
    setlocale(LC_ALL, "Russian");

    time_t theTime = time(NULL);
    struct tm *aTime = localtime(&theTime);

    int month = aTime->tm_mon + 1;
    std::string monthString;

    switch (month) {
        case 1:
            monthString = "Январь";
            break;
        case 2:
            monthString = "Февраль";
            break;
        case 3:
            monthString = "Март";
            break;
        case 4:
            monthString = "Апрель";
            break;
        case 5:
            monthString = "Май";
            break;
        case 6:
            monthString = "Июнь";
            break;
        case 7:
            monthString = "Июль";
            break;
        case 8:
            monthString = "Август";
            break;
        case 9:
            monthString = "Сентябрь";
            break;
        case 10:
            monthString = "Октябрь";
            break;
        case 11:
            monthString = "Ноябрь";
            break;
        case 12:
            monthString = "Декабрь";
            break;
        default:
            monthString = "Какой-то несуществующий месяц";
            break;
    }

    std::cout << "Сейчас: " << monthString << std::endl;

    return 0;
}
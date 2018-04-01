#include <iostream>
#include <iomanip>

#include "students.h"

int main() {
    Students stud[3];   //студенты
    int weaks[4];       //контрольные точки

    //Ввод недель контрольных точек
    for (int i = 0; i < 4; i++) {
        std::cout << "Введите номер недели для контрольной точки #" << i+1 << ": ";
        std::cin >> weaks[i];

        if (i > 0 && weaks[i-1] > weaks[i]) {
            std::cout << "Недели необходимо заполнять по порядку";
            return 0;
        } else if (i > 0 && weaks[i-1] == weaks[i]) {
            std::cout << "Недели контрольных точек не могут совпадать";
            return 0;
        }
    }

    //Ввод имен студентов и их оценок
    for (int i = 0; i < 3; i++) {
        std::string fname, lname;;

        std::cout << "Введите имя студента #" << i+1 << ": ";
        std::cin >> fname;
        stud[i].setFirstName(fname);

        std::cout << "Введите фамилию студента #" << i+1 << ": ";
        std::cin >> lname;
        stud[i].setLastName(lname);

        for (int weak : weaks) {
            int mark;
            std::cout << "Введите оценку студента за неделю #" << weak << ": ";
            std::cin >> mark;
            stud[i].setGrade(i+1, mark);
        }
    }

    //Вывод студентов и их средние баллы
    std::cout << "-------------------------------" << std::endl;
    std::cout << "Средний балл" << "\t" << "| Имя студента" << std::endl;
    for (auto &i : stud) {
        std::cout << i.getAverageGrade() << "\t\t\t| " << i.getFirstName() << " " << i.getLastName() << std::endl;
    }
    std::cout << "-------------------------------" << std::endl;

    return 0;
}
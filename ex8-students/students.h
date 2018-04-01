#include <string>

class Students {
    public:
        std::string firstName, lastName;

        //Задает имя студента
        void setFirstName(std::string);

        //Задает фамилию студента
        void setLastName(std::string);

        //Получает имя студента
        std::string getFirstName();

        //Получает фамилию студента
        std::string getLastName();

        //Устанавливает оценки студента
        void setGrade(int, int);

        //Получает средний балл
        double getAverageGrade();
};
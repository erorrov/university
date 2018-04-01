#include <string>
#include <iostream>
#include <numeric>
#include "students.h"

static int grades[5];   //todo

void Students::setFirstName(std::string firstName) {
    Students::firstName = firstName;
}

void Students::setLastName(std::string lastName) {
    Students::lastName = lastName;
}

std::string Students::getFirstName() {
    return Students::firstName;
}

std::string Students::getLastName() {
    return Students::lastName;
}

void Students::setGrade(int weak, int grade) {
    grades[weak] = grade;
}

//todo
double Students::getAverageGrade() {
    int n=4, i;
    float num[4], sum=0.0, average;

    for (i = 0; i < n; ++i) {
        num[i] = grades[i];
        sum += num[i];
    }

    average = sum / n;

    return average;
}
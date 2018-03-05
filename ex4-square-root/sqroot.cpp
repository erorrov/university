#include <iostream>
#include <cmath>

int main() {
    using namespace std;
    setlocale(LC_ALL, "Russian");

    double d, a, b, c;

    cout << "a = ";
    cin >> a;
    cout << "b = ";
    cin >> b;
    cout << "c = ";
    cin >> c;

    d = b * b - 4 * a * c;

    if (d < 0) {
        cout << "Уравнение не имеет корней" << endl;
    } else if (d == 0) {
        cout << "Уравнение имеет один корень" << endl;
        cout << "x = " << -b / (2 * a) << endl;
    } else {
        cout << "Уравнение имеет два корня" << endl;
        cout << "x1 = " << (-b + sqrt(d)) / (2 * a) << endl;
        cout << "x2 = " << (-b - sqrt(d)) / (2 * a) << endl;
    }

    return 0;
}
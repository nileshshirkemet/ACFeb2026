#include "interval.h"
#include <iostream>
#include <string>

using namespace std;

template<typename T> //defining a Select function-template with type-parameter T
T Select(int choice, T first, T second)
{
    if(choice % 2)
        return first;
    return second;
}

int main(void)
{
    int n;
    cout << "Selector: ";
    cin >> n;

    double d1 = 34.56, d2 = 76.54;
    cout << "Selected double value = "
         << Select<double>(n, d1, d2) //calls templated Select function with T=double
         << endl;

    string s1("saturday"), s2 = "sunday";
    cout << "Selected string value = "
         << Select<string>(n, s1, s2)
         << endl;

    Interval i1(3, 45), i2(4, 30);
    cout << "Selected string value = "
         << Select<Interval>(n, i1, i2)
         << endl;

}
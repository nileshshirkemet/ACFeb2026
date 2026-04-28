#include <iostream>
#include <string>

using namespace std;

template<typename T>
T Select(T first, T second)
{
    if(first > second)
        return first;
    return second;
}

template<> //explicit specialization of Select function template for T=string
string Select(string first, string second)
{
    if(first.size() > second.size())
        return first;
    return second;
}

int main(void)
{
    double d1 = 34.56, d2 = 76.54;
    cout << "Selected double value = "
         << Select(d1, d2) //Select<double>(d1, d2) - type inference/deduction from arguments
         << endl;

    string s1("saturday"), s2 = "sunday";
    cout << "Selected string value = "
         << Select(s1, s2)
         << endl;

}
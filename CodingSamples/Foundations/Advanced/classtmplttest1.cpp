#include <iostream>
#include <string>

using namespace std;

//defining Selector class template with type-parameter Any
template<typename Any> 
class Selector
{
public:
    Selector(Any a,  Any b) : first(a), second(b)
    {

    }

    Any Select(int choice) const
    {
        if(choice % 2)
            return first;
        return second;
    }

private:
    Any first, second;
};

int main(void)
{
    int n;
    cout << "Selector: ";
    cin >> n;

    double d1 = 34.56, d2 = 76.54;
    Selector<double> sd(d1, d2); //instantiating templated Selector class with Any=double
    cout << "Selected double value = "
         << sd.Select(n)
         << endl;

    string s1 = "saturday", s2 = "sunday";
    Selector<string> ss(s1, s2);
    cout << "Selected double value = "
         << ss.Select(n)
         << endl;

}
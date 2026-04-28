#include "interval.h"
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//supporting unary predicate as a function
bool TimeIsOdd(const Interval& check)
{
    return check.Time() % 2;
}

//supporting unary-predicate as a functor
//which is a class with an overloaded () operator
class TimeIsBetween
{
public:

    TimeIsBetween(int l, int u) : lower(l), upper(u){}

    bool operator()(const Interval& check) const
    {
        return check.Time() > lower && check.Time() < upper;
 }
private:
    int lower, upper;
};

//supporting binary-predicate as function
bool TimeComparison(const Interval& first, const Interval& second)
{
    return first.Time() < second.Time();
}

int main(void)
{
    vector<Interval> store;
    store.push_back(Interval(4, 31));
    store.push_back(Interval(6, 52));
    store.push_back(Interval(8, 23));
    store.push_back(Interval(7, 14));
    store.push_back(Interval(3, 25));
    store.push_back(Interval(5, 46));
    vector<Interval>::iterator start = store.begin(), stop = store.end();
    cout << "Original intervals in store" << endl;
    for(vector<Interval>::iterator i = start; i != stop; ++i)
        cout << *i << endl;
    cout << "Number of odd intervals = "
         << count_if(start, stop, TimeIsOdd) //requires forward-only iterators and unary-predicate
         << endl;
    int min, max;
    cout << "Minimum and Maximum time: ";
    cin >> min >> max;
    cout << "Number of intervals in range = "
         << count_if(start, stop, TimeIsBetween(min, max))
         << endl;
    //sort(start, stop, TimeComparison); //requires random-access iterator and binary predicate
    cout << "Sorted intervals in store" << endl;
    for(vector<Interval>::iterator i = start; i != stop; ++i)
        cout << *i << endl;
}
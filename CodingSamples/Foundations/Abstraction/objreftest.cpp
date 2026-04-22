#include "interval1.h"
#include <cstdio>

//a reference declared with const qualifier treats the addressed
//instance as read-only and such only const member functions
//can be called on that pointer
double Speed(double distance, const Interval& duration)
{
    //duration.Adjust(0);
    return distance / duration.Time();//duration[0].Time();
}

int main(void)
{
    Interval a(3, 70); //activating Interval on stack using parameterized constructor
    a.Print();
    printf("Speed for this Interval = %.1lf\n", Speed(600, a));
    int t;
    printf("Time: ");
    scanf("%d", &t);
    if(t >= 10)
    {
        Interval b; //activating Interval on stack using default constructor
        b.Adjust(t);
        b.Print();
        printf("Speed for this Interval = %.1lf\n", Speed(600, b));
    }//destructor is called for instance identified by b
    printf("Number of Interval instances activated = %d\n", Interval::Activated());
}//destructor is called for instance identified by a

#include "interval2.h"
#include <cstdio>


//overloading operator as a global function is allowed
//if any one operand is of class type
Interval operator*(int lhs, const Interval& rhs)
{
    int t = lhs * rhs.Time();
    return Interval(0, t);
}

int main(void)
{
    int scale(3); //int scale = 3

    Interval a(3, 45);
    a.Print();

    puts("Copying...");
    Interval b = a; //Interval b(a);
    b.Print();

    Interval c(4, 20);
    c.Print();

    puts("Adding...");
    Interval d = b + c; //b.operator+(c)
    d.Print();

    puts("Scaling...");
    Interval e = scale * d; //operator*(scale, d)
    e.Print();

    printf("Number of intervals activated = %d\n", Interval::Activated());
}

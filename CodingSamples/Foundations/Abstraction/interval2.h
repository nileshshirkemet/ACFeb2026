#include <cstdio>

class Interval
{
public:
    Interval(short m = 0, short s = 0)
    {
        min = m + s / 60;
        sec = s % 60;
        id = ++count;
    }

    //copy constructor - used for activating a new instance
    //as a copy of another instance
    Interval(const Interval& original)
    {
        min = original.min;
        sec = original.sec;
        id = ++count;
    }

    void Adjust(int t)
    {
        min = t / 60;
        sec = t % 60;
    }

    long Time() const
    {
        return 60 * min + sec;
    }

    void Print() const
    {
        printf("Interval<%d> = %hd:%02hd\n", id, min, sec);
    }

    //overloading operator as a member function is allowed
    //if first operand is of current class type so that it can
    //be passed throught 'this' argument
    Interval operator+(const Interval& rhs) const
    {
        return Interval(min + rhs.min, sec + rhs.sec);
    }

    static int Activated()
    {
        return count;
    }

private:
    short min;
    short sec;
    int id;
    //inlining definition for static field in Modern C++(17)
    inline static int count;
};


#include <iostream>

class Interval
{
public:
    Interval(short m = 0, short s = 0)
    {
        min = m + s / 60;
        sec = s % 60;
        id = ++count;
    }

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
    inline static int count;

//when a function which is not a member of a class is declared
//inside of the class with 'friend' keyword then it can access
//private members of that class 
//(such a function is defined only by the author of the class)
friend std::ostream& operator<<(std::ostream& out, const Interval& val);

};

std::ostream& operator<<(std::ostream& out, const Interval& val)
{
    out << val.min;
    if(val.sec < 10)
        out << ":0" << val.sec;
    else
        out << ":" << val.sec;
    return out;
}


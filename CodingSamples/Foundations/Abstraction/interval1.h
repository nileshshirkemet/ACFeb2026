#include <cstdio>

class Interval
{
public:
    Interval(int m = 0, int s = 0)
    {
        min = m + s / 60;
        sec = s % 60;
        id = 1;
        printf("Interval instance<%ld> initialized.\n", id);
    }

    //destructor - it is a special member function which is
    //automatically called for an instance when it is removed
    //from the memory or in case of a stack based instance
    //when its identifier goes out of scope, it is commonly
    //defined for reversing the side-effect of the constructor
    ~Interval()
    {
        printf("Interval instance<%ld> finalized.\n", id);
    }
private:
    //instance field - memory is separately assigned for the value in each instance
    int min;
    int sec;
    long id;
};

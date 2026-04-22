#include <cstdio>

class Interval
{
public:
    //parameterized constructor - constructor which accepts one or more 
    //argumenbts, it can be used as a default constructor if all the
    //parameters are optional i.e they are defined with default arguments
    Interval(short m = 0, short s = 0)
    {
        min = m + s / 60;
        sec = s % 60;
        id = ++count;
        printf("Interval instance<%d> initialized.\n", id);
    }

    //instance method - must be called on an object (using . operator)
    //so that it can reference other instance members through 'this'
    //argument which addresses the instance refered by the target object
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

    //static method - can be called on the class itself (using :: operator)
    //and as such it can only reference other static members because it
    //does not receive 'this' argument
    static int Activated()
    {
        return count;
    }

    //destructor - it is a special member function which is
    //automatically called for an instance when before is removed
    //from the memory or in case of a stack based instance
    //when its identifier goes out of scope, it is commonly
    //defined for reversing the side-effect of the constructor
    ~Interval()
    {
        printf("Interval instance<%d> finalized.\n", id);
    }
private:
    //instance field - memory is separately assigned for the value in each instance space
    short min;
    short sec;
    int id;
    //static field - memory is assigned for the value within global space by the 
    //definition so that it is shared across all the instances 
    static int count;
};

//static field declared in a class must be separately defined
int Interval::count = 0;

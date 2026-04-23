#include "interval1.h"
#include <cstdio>

int main(void)
{
    int n;
    printf("Number of Intervals: ");
    scanf("%d", &n);

    if(n == 1)
    {
        //using new operator to explicitly allocate memory for an instance of
        //a class on the heap followed by a call to the specified constructor
        Interval* a = new Interval(3, 45); //a addresses the instance activated on heap
        a->Print();
        //using delete operator to deallocate memory assigned to an instance of
        //a class on the heap after calling its destructor
        delete a;
    }
    else
    {
        //using new[] operator to explicitly allocate memory for an array of
        //instances of a class on the heap followed by a call to the default
        //constructor on each instance
        Interval* a = new Interval[n]; //a addresses first element in the array activated on heap
        for(int i = 0; i < n; ++i)
        {
            a[i].Adjust(40 * i + 255);
            a[i].Print();
        }
        //using delete[] operator to deallocate memory assigned to an array of
        //instances of a class on heap after calling destructor on each instance
        delete[] a;
    }

}

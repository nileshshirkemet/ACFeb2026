#include <cmath>

double Compute(long first, long last, float level)
{
    double result = 0;
    for(long num = first; num <= last; ++num)
    {
        result += pow(num, level);
    }
    return result;
}

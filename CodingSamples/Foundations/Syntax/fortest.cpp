#include <cstdio>

int main(void)
{
    long lower, upper;
    printf("Lower and Upper Limit: ");
    scanf("%ld%ld", &lower, &upper);

    long result = 0;
    for(long num = lower; num <= upper; ++num)
    {
        result += num * num;
    }

    printf("Computation Result = %ld\n", result);
}

#include <cstdio>
//declaration of a function linked from an external module
extern double Compute(long, long, float); 

int main(void)
{
    long lower, upper;
    printf("Lower and Upper Limit: ");
    scanf("%ld%ld", &lower, &upper);

    printf("Result of basic computation   : %lf\n", Compute(lower, upper, 1));
    printf("Result of advanced computation: %lf\n", Compute(lower, upper, 2.5));
}

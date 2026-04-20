#include <cstdio>

void Swap(double* first, double* second)
{
    double third = first[0];
    first[0] = second[0];
    second[0] = third;
}

double Average(double first, double second, double* deviation)
{
    *deviation = first > second ? (first - second) / 2 : (second - first) / 2;
    return (first + second) / 2;
}

int main(void)
{
    double x, y;
    printf("Enter any two values: ");
    scanf("%lf%lf", &x, &y);
    
    printf("Original values = %lf, %lf\n", x, y);
    puts("Swapping...");
    Swap(&x, &y);   
    printf("Swapped values = %lf, %lf\n", x, y);

    double d;
    double a = Average(x, y, &d);
    printf("Average is %lf with a deviation of %lf\n", a, d);
}

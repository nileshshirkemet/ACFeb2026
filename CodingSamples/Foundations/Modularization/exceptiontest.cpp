#include "boxing.h"
#include <cstdio>

int main(void)
{
    float a, b, c;
    printf("Box Dimensions   : ");
    scanf("%f%f%f", &a, &b, &c);
    float d;
    printf("Premium Thickness: ");
    scanf("%f", &d);
    try
    {
        printf("Capacity of regular box = %lf\n", Capacity(a, b, c));
        printf("Capacity of premium box = %lf\n", Capacity(a, b, c, d));
    }
    catch(float e)
    {
        printf("Invalid thickness: %f\n", e);
    }
    puts("Goodbye.");
}
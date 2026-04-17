#include <cstdio>

float rate = 0.85; //global variable

int main(void)
{
    float width, height; //local variables
    printf("Dimensions of Banner: ");
    scanf("%f%f", &width, &height);
    short int count;
    printf("Number of Banners   : ");
    scanf("%hd", &count);

    double payment = count * width * height * rate;
    printf("Total Payment: %.2lf\n", payment);
}

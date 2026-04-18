#include <cstdio>

int main(void)
{
    float width, height;
    printf("Dimensions of Banner: ");
    scanf("%f%f", &width, &height);
    short count;
    printf("Number of Banners   : ");
    scanf("%hd", &count);
 
    if(width > height)
    {
        double payment = count * width * height * 0.85;
        printf("Total payment for land-scape banners is %.2lf\n", payment);
    }
    else
    {
        double payment = count * (width + 1) * (height + 1) * 0.95;
        printf("Total payment for potrait banners is %.2lf\n", payment);
    }

    puts("Goodbye.");
}

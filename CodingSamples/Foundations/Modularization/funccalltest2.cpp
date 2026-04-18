#include <cstdio>

double BannerPrice(float width, float height)
{
    float rate = width > height ? 0.85 : 0.95;
    return width * height * rate;
}

//overloading above BannerPrice function
double BannerPrice(float width, float height, short layers)
{
    if(layers == 1)
        return BannerPrice(width + 1, height + 1);
    return 1.35 * width * height * layers;
}

int main(void)
{
    float w, h;
    printf("Dimensions of Banner: ");
    scanf("%f%f", &w, &h);

    int n;
    printf("Number of Banners   : ");
    scanf("%d", &n);

    printf("Total payment for regular banners: %.2lf\n", n * BannerPrice(w, h));
    printf("Total payment for premium banners: %.2lf\n", n * BannerPrice(w, h, 3));
}

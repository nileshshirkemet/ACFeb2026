#include "banners.h"
#include <cstdio>

double PurchaseBanner(const Banner& each, int copies)
{
    float rate = copies < 5 ? 0.90 : 0.85;
    //when a virtual member function of class is called on a reference/pointer
    //of that class type, dynamic-binding is used for dispatching the invocation
    return copies * rate * each.Material(); //each.vtptr->Material(each)
}

int main(void)
{
    float w, h;
    printf("Dimensions of Banner: ");
    scanf("%f%f", &w, &h);
    int n;
    printf("Number of Banners   : ");
    scanf("%d", &n);

    Banner a(w, h);
    printf("Total payment for regular banners = %.2lf\n", PurchaseBanner(a, n));

    HardBanner b(1.5);
    b.Resize(w, h); //Banner::Resize(&b, w, h) - static binding
    printf("Total payment for premium banners = %.2lf\n", PurchaseBanner(b, n));
}
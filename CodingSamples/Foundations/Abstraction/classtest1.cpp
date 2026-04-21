#include "banner1.h"
#include <cstdio>

double PurchaseBanner(Banner each, int copies)
{
	float rate = copies < 5 ? 0.90 : 0.85;
	return copies * rate * each.Area(); //Banner::Area(&each)
}

int main(void)
{
	int n;
	printf("Number of banners: ");
	scanf("%d", &n);

	Banner a; //activating Banner class with default constructor
	printf("Total payment for standard banners: %.2lf\n", PurchaseBanner(a, n));

	float w, h;
	printf("Dimensions of custom banner: ");
	scanf("%f%f", &w, &h);
	a.Resize(w, h); //Banner::Resize(&a, w, h)
	printf("Total payment for customized banners: %.2lf\n", PurchaseBanner(a, n));
}


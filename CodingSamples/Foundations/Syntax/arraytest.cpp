#include <cstdio>

//variable rate identifies an array with 5 elements each of float-type
//indexed from 0 to 4, the const qualifier indicates that the
//elements of this array are read-only (cannot be modified)
const float rate[] = {0.85, 0.95, 1.25, 1.75, 2.50};

int main(void)
{
    float width, height;
    printf("Dimensions of Banner: ");
    scanf("%f%f", &width, &height);
    short count;
    printf("Number of Banners   : ");
    scanf("%hd", &count);
    int m;
    printf("Material to Use[1-5]: ");
    scanf("%d", &m);

    double payment = count * width * height * rate[m - 1]; //indexing array element
    printf("Total Payment: %.2lf\n", payment);
}

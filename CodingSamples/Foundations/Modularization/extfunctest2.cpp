#include <cstdio>

extern "C" long lcm(long, long);

int main(void)
{
    long m, n;
    printf("Two Positive Integers: ");
    scanf("%ld%ld", &m, &n);

    printf("L.C.M = %ld\n", lcm(m, n));
}

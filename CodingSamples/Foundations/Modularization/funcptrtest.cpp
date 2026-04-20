#include <cstdio>

double Expense(int year)
{
    return 5 * year - 1;
}

double Income(int year)
{
    return year * year + 1;
}

double CommonSum(int years, double (*sequence)(int))
{
    double total = 0;
    for(int y = 1; y <= years; ++y)
    {
        total += sequence(y);
    }
    return total;
}

int main(void)
{
    int n;
    printf("Number of Years: ");
    scanf("%d", &n);

    printf("Total Expense = %.2lf\n", CommonSum(n, &Expense));
    printf("Total Income  = %.2lf\n", CommonSum(n, &Income));
}

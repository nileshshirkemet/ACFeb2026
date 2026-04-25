#include "boards1.h"
#include <iostream>

double PurchaseBoards(Ads::Signboard* each, int copies)
{
    float profit = copies < 10 ? 1.25 : 1.15;
    return copies * profit * each->Cost();
}

int main(void)
{
    float size;
    int count;
    std::cout << "Size and Number of Boards: ";
    std::cin >> size >> count;

    Ads::RectangularBoard a(0.8 * size, 0.6 * size);
    std::cout << "Total payment for rectangular boards: "
              << PurchaseBoards(&a, count)
              << std::endl;

    Ads::CircularBoard b(size);
    std::cout << "Total payment for circular boards   : "
              << PurchaseBoards(&b, count)
              << std::endl;
}
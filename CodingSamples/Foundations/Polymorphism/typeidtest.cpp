#include "boards1.h"
#include <iostream>

using namespace Ads;

double PurchaseBoards(Signboard* each, int copies)
{
    float profit = copies < 10 ? 1.25 : 1.15;
    if(typeid(*each) == typeid(RectangularBoard))
    {
        profit -= 0.05;
    }
    return copies * profit * each->Cost();
}

int main(void)
{
    using namespace std;

    float size;
    int count;
    cout << "Size and Number of Boards: ";
    cin >> size >> count;

    RectangularBoard a(0.8 * size, 0.6 * size);
    cout << "Total payment for rectangular boards: "
              << PurchaseBoards(&a, count)
              << endl;

    CircularBoard b(size);
    cout << "Total payment for circular boards   : "
              << PurchaseBoards(&b, count)
              << endl;
}
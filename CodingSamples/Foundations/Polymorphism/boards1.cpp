#include "boards1.h"
#define PI 3.14

double Ads::Signboard::Cost() const
{
    return rate * Area();
}

Ads::RectangularBoard::RectangularBoard(float width, float height)
{
    rate = 2.75;
    if(width > height)
    {
        length = width;
        breadth = height;
    }
    else
    {
        length = height;
        breadth = width;
    }
}

double Ads::RectangularBoard::Area() const
{
    return length * breadth;
}

Ads::CircularBoard::CircularBoard(float diameter)
{
    rate = 3.25;
    radius = diameter / 2;
}

double Ads::CircularBoard::Area() const
{
    return PI * radius * radius;
}

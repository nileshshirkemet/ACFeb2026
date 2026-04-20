#include "boxing.h"

double Capacity(float l, float b, float h, float t)
{
	if(l <= 2 * t || b <= 2 * t || h <= 2 * t)
	{
		throw t; //raising exception of float type
	}
	return (l - 2 * t) * (b - 2 * t) * (h - 2 * t);

}


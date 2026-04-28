//compile with -std=c++20

#include <iostream>
#include <vector>
#include <ranges>

using namespace std;

int main(void)
{
    vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    float scale = 0.5;

    auto selection = nums
        | views::filter([](int n){ return n % 2; }) //passing lambda expression
        | views::transform([scale](int n){ return scale * n * n; }) //lambda expression which captures scale
        | views::reverse;
    //for-each loop syntax
    for(float i : selection)
        cout << i << endl;
}
#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

int main(void)
{
    vector<int> nums;
    nums.push_back(471);
    nums.push_back(632);
    nums.push_back(853);
    nums.push_back(294);
    nums.push_back(765);
    nums.push_back(526);
    nums.push_back(107);
    nums.push_back(348);
    nums.push_back(471);
    cout << "Original integers in vector" << endl;
    for(int i = 0; i < nums.size(); ++i)
    {
        cout << nums.at(i) << endl;
    }

    set<string> days;
    days.insert("Monday");
    days.insert("Tuesday");
    days.insert("Wednesday");
    days.insert("Thursday");
    days.insert("Friday");
    days.insert("Saturday");
    days.insert("Monday");
    cout << "Original strings in set" << endl;
    for(set<string>::iterator i = days.begin(); i != days.end(); ++i)
    {
        cout << *i << endl;
    }
}

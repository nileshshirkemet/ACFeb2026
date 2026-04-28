#include <iostream>
#include <string>

using namespace std;

template<typename K, typename V>
class Binder
{
public:
    Binder(K k) : key(k)
    {

    }

    void Bind(V val)
    {
        value = val;
    }

    void Print()
    {
        cout << "(" << key << ") => " << value << endl;
    }
private:
    K key;
    V value;

};

template<typename K>
class Binder<K, bool> //partial specialization of Binder class template for V=bool
{
public:
    Binder(K k) : key(k)
    {

    }
    
    void Bind(bool val)
    {
        value = val;
    }

    void Print()
    {
        cout << "(" << key << ") => " << (value ? "yes" : "no")  << endl;
    }

private:
    K key;
    bool value;
};

template<>
class Binder<int, string> //full specialization of Binder class template for K=int and V=string
{
public:
    Binder()
    {
        //static local variable retains value across function calls 
        static int count = 0;
        key = ++count;
    }

    void Bind(string val)
    {
        value = val;
    }

    void Print()
    {
        cout << "[" << key << "] => " << value << endl;
    }
private:
    int key;
    string value;
};

int main(void)
{
    Binder<string, double> a("April");
    a.Bind(71.5);
    a.Print();

    Binder<double, bool> b(3.25);
    b.Bind(true);
    b.Print();

    Binder<int, string> c;
    c.Bind("Monday");
    c.Print();

    Binder<int, string> d;
    d.Bind("Tuesday");
    d.Print();
}
class Banner
{
//members in this 'access-control block' are visible outside
//the scope of this class
public: 

    //constructor - it is a member function defined without
    //any return type and a name that matches with the name
    //of the class, to activate a new instance of a class
    //its constructor must be explicitly called if this
    //constructor has any non-optional parameter otherwise
    //it is implicitly called, such a constructor is called
    //a 'default constructor' and it is automatically defined
    //by compiler for a class which does not explicitly define
    //any constructor
    Banner()
    {
        width = 20;
        height = 3;
    }

    void Resize(float w, float h) //void Banner::Resize(Banner* this, float w, float h)
    {
        width = w; //this[0].width = w
        height = h; //this[0].height = h
    }

    //a const member function does not change the state
    //of the object on which it is called
    double Area() const //double Banner::Area(const Banner* this)
    {
        return width * height; //return this[0].width * this[0].height
    }
//members in this 'access-control block' are visible only 
//within the scope of this class
private:
    float width;
    float height;

};

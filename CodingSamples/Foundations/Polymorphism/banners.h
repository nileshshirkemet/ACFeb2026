class Banner
{
public:
    //using member variable initializer syntax allowed only for constructor
    Banner(float w = 20, float h = 3) : width(w), height(h)
    {
    }

    void Resize(float w, float h)
    {
        width = w;
        height = h;
    }

    //only a member function declared with 'virtual' keyword can be
    //overridden in the derived class
    virtual double Material() const
    {
        return width * height;
    }

    //a virtual destructor indicates that this class can be
    //safely used as a base class for other classes
    virtual ~Banner() {}

private:
    float width;
    float height;
};

//defining HardBanner as a derived class of Banner (base class)
class HardBanner : public Banner
{
public:
    //the constructor of derived class must call constructor of base class
    //to initialize the base-class subobject in its own instance
    HardBanner(float t) : Banner(15, 2)
    {
        thickness = t;
    }

    //method overriding - defining a member function in a derived class
    //with a declaration that exactly matches with the declaration
    //of a virtual member function in the base class
    double Material() const
    {
        return thickness * Banner::Material();
    }

private:
    float thickness;
};

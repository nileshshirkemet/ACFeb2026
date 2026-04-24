namespace Ads
{
    //defining Signboard as an ADT
    class Signboard
    {
    public:

        double virtual Area() const = 0; //pure virtual function

        double Cost() const;

        virtual ~Signboard() {}

    //members in this access control block are visible to derived classes
    protected:
        float rate;
    };

    class RectangularBoard : public Signboard
    {
    public:

        RectangularBoard(float width, float height);

        double Area() const;

    private:
        float length, breadth;
    };

    class CircularBoard : public Signboard
    {
    public:

        CircularBoard(float diameter);

        double Area() const;

    private:
        float radius;
    };
}

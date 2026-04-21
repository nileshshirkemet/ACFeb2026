enum Geometry {Rectangular, Triangular, Hexagonal};

class Banner
{
public:
	Banner()
	{
		region = 20 * 3;
		shape = Geometry::Rectangular;
	}

	void Resize(float w, float h)
	{
		region = w * h;
	}

	void Reshape(Geometry s)
	{
		shape = s;
	}

	double Area() const
	{
		float portion;
		switch(shape)
		{
			case Geometry::Triangular:
				portion = 0.5;
				break;
			case Geometry::Hexagonal:
				portion = 0.75;
				break;
			default:
				portion = 1;
		}
		return portion * region;
	}
private:
	double region;
	Geometry shape;
};


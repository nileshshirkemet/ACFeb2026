namespace DemoApp.Services;

public sealed class UniversalCounter : IHitCounter, IDisposable
{
    private int current;

    public UniversalCounter()
    {
        try
        {
            using var reader = new BinaryReader(new FileStream("count.dat", FileMode.Open));
            current = reader.ReadInt32();
        }
        catch
        {
            current = 0;
        }
    }

    public int CountNext(string id)
    {
        return Interlocked.Increment(ref current);
    }

    public void Dispose()
    {
        using var writer = new BinaryWriter(new FileStream("count.dat", FileMode.Create));
        writer.Write(current);
    }
}
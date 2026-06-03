namespace DemoApp.Services;

public sealed class PersonalCounter(int seed, int step) : IHitCounter
{
    private Dictionary<string, int> store = [];

    public int CountNext(string id)
    {
        lock(store)
        {
            int count;
            if(store.TryGetValue(id, out count))
                count += step;
            else
                count = seed;
            store[id] = count;
            return count;
        }
    }
}
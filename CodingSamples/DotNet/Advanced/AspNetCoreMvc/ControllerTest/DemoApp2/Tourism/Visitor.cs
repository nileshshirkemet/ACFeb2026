using System.Text.Json.Serialization;

namespace DemoApp.Tourism;

public class Visitor
{
    public string Id { get; set; }

    public int VisitCount { get; set; }

    public DateTime LastVisit { get; set; }

    [JsonIgnore]
    public int Rating { get; set; }

    public string Stars => new string('*', Rating);
}
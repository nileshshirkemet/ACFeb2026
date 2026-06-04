using System.ComponentModel.DataAnnotations;

namespace DemoApp.Models;

public class Feedback
{
    [Required, MinLength(4)]
    public string Person { get; set; }

    [Range(1, 5)]
    public int Ranking { get; set; }
}

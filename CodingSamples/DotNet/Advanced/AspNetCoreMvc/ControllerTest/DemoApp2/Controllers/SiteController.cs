using DemoApp.Models;
using DemoApp.Tourism;
using Microsoft.AspNetCore.Mvc;

namespace DemoApp.Controllers;

[ApiController]
[Route("/api/feedbacks")]
public class SiteController : ControllerBase
{
    [HttpGet("{low=1}")]
    public ActionResult<Visitor[]> ReadVisitors(SiteModel model, int low)
    {
        var selection = from v in model.FetchVisitors()
            where v.Rating >= low
            select v;
        if(selection.Any())
            return selection.ToArray();
        return NotFound();
    }   

    [HttpPut]
    public IActionResult UpdateVisits(SiteModel model, Feedback input)
    {
        model.AcceptVisit(input.Person, input.Ranking);
        return Ok();
    } 
}

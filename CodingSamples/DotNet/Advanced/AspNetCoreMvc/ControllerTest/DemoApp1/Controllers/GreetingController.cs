using DemoApp.Services;
using Microsoft.AspNetCore.Mvc;

namespace DemoApp.Controllers;

public class GreetingController : Controller
{
    public IActionResult Clock()
    {
        return Content(DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"));
    }

    public IActionResult Greet([FromServices] IHitCounter counting, string id = "Friend")
    {
        var info = new
        {
            GuestName = id,
            GreetCount = counting.CountNext(id)
        };
        string browser = Request.Headers.UserAgent;
        if(browser.Contains("Mobile"))
            return View("~/Views/Hello.cshtml", info);
        return View("~/Views/Welcome.cshtml", info);

    }

}
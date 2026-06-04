using DemoApp.Models;
using Microsoft.AspNetCore.Mvc;

namespace DemoApp.Controllers;

public class HomeController(SiteModel model) : Controller
{
    public IActionResult Index()
    {
        var visitors = model.FetchVisitors();
        //render ~/Views/[current-controller-name]/[current-action-name].cshtml
        return View(visitors);
    }

    public IActionResult Register()
    {
        return View();
    }

    [HttpPost]
    public IActionResult Register(string person, int ranking)
    {
        model.AcceptVisit(person, ranking);
        return RedirectToAction("Index");
    }
}
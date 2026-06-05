using System.Security.Claims;
using DemoApp.Shopping;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;

namespace DemoApp.Pages.Models;

public class IndexModel(ShopDbContext shop) : PageModel
{
    [BindProperty]
    public Customer Login { get; set; }

    public async Task<IActionResult> OnPostAsync()
    {
        int count = await shop.Customers
            .CountAsync(c => c.Id == Login.Id && c.Password == Login.Password);
        if(count == 1)
        {
            var identity = new ClaimsIdentity("Customer");
            identity.AddClaim(new Claim(ClaimTypes.Name, Login.Id));
            await HttpContext.SignInAsync(new ClaimsPrincipal(identity));
            return RedirectToPage("Detail");
        }
        ModelState.AddModelError("Login", "Invalid Customer ID or Password.");
        return Page();
    }


}
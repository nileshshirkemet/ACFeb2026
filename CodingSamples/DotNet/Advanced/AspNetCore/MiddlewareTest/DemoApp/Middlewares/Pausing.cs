namespace DemoApp.Middlewares;

//a middleware is defined as a class with a constructor whose first 
//parameter is of RequestDelegate type and which includes Invoke method 
//with one parameter of HttpContext type and Task as its return type
public class Pausing(RequestDelegate next)
{
    private DateTime last;

    public async Task Invoke(HttpContext context)
    {
        var current = DateTime.Now;
        if(current - last > TimeSpan.FromSeconds(3))
        {
            await next.Invoke(context);
            last = current;
        }
        else
        {
            context.Response.StatusCode = 503; //service not available
        }
    }

}
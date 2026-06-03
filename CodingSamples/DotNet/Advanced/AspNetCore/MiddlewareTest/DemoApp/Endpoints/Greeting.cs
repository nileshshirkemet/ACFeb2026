namespace DemoApp.Endpoints;

public class Greeting
{
    public static async Task Welcome(HttpResponse response)
    {
        await response.WriteAsync($"""
        <html>
            <head>
                <title>DemoApp</title>
            </head>
            <body>
                <h1>Welcome Visitor</h1>
                <b>Current Time: </b>{DateTime.Now}
            </body>
        </html>
        """);
    }

    public static async Task Hello(HttpContext context)
    {
        string person = context.Request.Form["visitor"];
        if(person.Length == 0)
            person = "Friend";
        int count = context.Session.GetInt32(person) ?? 0;
        context.Session.SetInt32(person, ++count);
        await context.Response.WriteAsync($"""
        <html>
            <head>
                <title>DemoApp</title>
            </head>
            <body>
                <h1>Hello {person}</h1>
                <b>Number of Greetings: </b>{count}
            </body>
        </html>        
        """);
    }
}
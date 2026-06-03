using DemoApp.Services;

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
                <p>
                    <form method="POST" action="Login">
                        <b>Name: </b>
                        <input type="text" name="visitor" />
                        <input type="submit" value="Pass" />
                    </form>
                </p>
            </body>
        </html>
        """);
    }

    public static async Task Hello(HttpRequest request, HttpResponse response, IHitCounter counting)
    {
        string person = request.Form["visitor"];
        if(person.Length == 0)
            person = "Friend";
        await response.WriteAsync($"""
        <html>
            <head>
                <title>DemoApp</title>
            </head>
            <body>
                <h1>Hello {person}</h1>
                <b>Number of Greetings: </b>{counting.CountNext(person)}
            </body>
        </html>        
        """);
    }
}
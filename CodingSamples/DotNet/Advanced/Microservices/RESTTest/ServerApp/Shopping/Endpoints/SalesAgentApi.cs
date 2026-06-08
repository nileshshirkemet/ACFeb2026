using ServerApp.Security;

namespace ServerApp.Shopping.Endpoints;

public class SalesAgentApi
{
    public static async Task<IResult> SignIn(string id, int passcode)
    {
        string agentMail = id + "@sales.met.edu";
        if(passcode == 3521)
        {
            await OtpHelper.MailPasscodeAsync(agentMail, "app@sales.met.edu");
            return Results.Ok();
        }
        if(OtpHelper.VerifyPasscode(agentMail, passcode))
        {
            var token = JwtHelper.CreateToken(id);
            return Results.Text(token);
        }
        return Results.Unauthorized();
    }
}
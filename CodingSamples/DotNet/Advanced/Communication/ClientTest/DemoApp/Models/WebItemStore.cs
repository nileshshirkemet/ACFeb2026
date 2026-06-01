using System.Xml.Linq;

namespace DemoApp.Models;

public class WebItemStore : IDataAccessLayer
{
    public ItemInfo FetchItemInfo(string id)
    {
        var url = new Uri($"http://iitdac.met.edu/shop/{id}");
        using var client = new HttpClient();
        var request = new HttpRequestMessage(HttpMethod.Get, url);
        request.Headers.Add("Accept", "application/xml");
        var response = client.Send(request);
        if(response.IsSuccessStatusCode)
        {
            var reply = response.Content.ReadAsStream();
            var item = XElement.Load(reply);
            return new ItemInfo
            {
                UnitCost = (double) item.Element("cost"),
                StockLevel = (int) item.Element("stock")
            };
        }
        return default; //new ItemInfo()
    }
}
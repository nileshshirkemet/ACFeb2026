using Microsoft.Data.Sqlite;

namespace DemoApp.Services.Shopping;

public class WholesaleStore : IDataAccessLayer
{
    public ItemInfo ReadItemInfo(string name)
    {
        using var connection = new SqliteConnection("Data Source=data/wholesale.db");
        connection.Open();
        using var command = connection.CreateCommand();
        command.CommandText = "SELECT Cost, Stock FROM Items WHERE Id=@key";
        command.Parameters.AddWithValue("@key", name);
        using var reader = command.ExecuteReader();
        if(reader.Read())
        {
            return new ItemInfo(
                Id: name,
                Cost: reader.GetDouble(0),
                Stock: reader.GetInt32(1)
            );
        }
        return null;
    }
}
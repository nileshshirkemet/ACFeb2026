namespace ServerApp.Shopping.Resources;

public readonly record struct OrderInfo(int ProductNo, int Quantity, string OrderDate);

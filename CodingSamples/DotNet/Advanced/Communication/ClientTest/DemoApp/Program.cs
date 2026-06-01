using DemoApp.Models;
using DemoApp.Views;

IDataAccessLayer store = args.Length > 0 
    ? new NetItemStore(args[0])
    : new WebItemStore();
var ui = new PresentationLayer(store);
ui.Render();

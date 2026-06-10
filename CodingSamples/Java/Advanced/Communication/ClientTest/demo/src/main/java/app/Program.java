package app;

import app.models.DataAccessLayer;
import app.models.NetItemStore;
import app.models.WebItemStore;
import app.views.PresentationLayer;

public class Program {
    
    public static void main(String[] args) throws Exception {
        DataAccessLayer store = args.length > 0
            ? new NetItemStore(args[0])
            : new WebItemStore();
        PresentationLayer ui = new PresentationLayer(store);
        ui.render();
    }

}


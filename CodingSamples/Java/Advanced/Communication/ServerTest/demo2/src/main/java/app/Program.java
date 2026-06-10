package app;

import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import app.services.common.CommunicationLayer;
import app.services.common.TransportLayer;
import app.services.shopping.DataAccessLayer;
import app.services.shopping.InventoryLookup;
import app.services.shopping.RetailStore;
import jakarta.inject.Singleton;

public class Program extends AbstractBinder {

    @Override
    protected void configure() {
        bind(InventoryLookup.class).to(CommunicationLayer.class);
        bind(RetailStore.class).to(DataAccessLayer.class).in(Singleton.class);
    }

    public static void main(String[] args) throws Exception {
        var builder = ServiceLocatorUtilities.bind(new Program());
        var app = builder.create(TransportLayer.class);
        app.run();
	}

}


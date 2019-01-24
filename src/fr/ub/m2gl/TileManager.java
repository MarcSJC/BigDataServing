package fr.ub.m2gl;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/tile")
public class TileManager extends ResourceConfig {

    public TileManager() {
        // Register resources and providers using package-scanning.
        packages("fr.ub.m2gl");

        register(new CORSFilter());

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");
   }
    
}


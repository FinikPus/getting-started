package org.acme.getting.started;

import org.jboss.logging.Logger;
import io.prometheus.client.Counter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {
    static final Counter requests = Counter.build()
            .name("requests_total").help("Total requests.").register();
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        requests.inc();
        LOG.info("Hello");
        return "hello";
    }
}
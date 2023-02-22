package com.practice.client;//package com.practice.client;
import io.dropwizard.testing.junit5.DropwizardClientExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

//import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(DropwizardExtensionsSupport.class)
public class CustomClientTest {
    @Path("/ping")
    public static class PingResource {
        @GET
        public String ping() {
            return "pong";
        }
    }

    private static final DropwizardClientExtension EXT = new DropwizardClientExtension(new PingResource());

    @Test
    public void  shouldPing() throws IOException {
        final URL url = new URL(EXT.baseUri() + "/ping");
        final String response = new BufferedReader(new InputStreamReader(url.openStream())).readLine();
        assertEquals("pong", response);
    }
}
